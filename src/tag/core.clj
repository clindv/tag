(ns tag.core
  (:import (java.awt Toolkit
                     datatransfer.Clipboard
                     datatransfer.DataFlavor
                     datatransfer.StringSelection))
  (:require clojure.pprint)
  (:gen-class))
(defn acrostic []
  (with-open [rdr (clojure.java.io/reader "target/glove.6B.50d.txt")
              wtr (clojure.java.io/writer "target/all.txt")]
    (dotimes [_ 400000]
      (try (.write wtr (str (read-string (.readLine rdr)) ","))
           (catch Exception e "")))))
(defn init-acrostic-trim []
  (let [new-list (->> "target/all.txt"
                      slurp
                      (#(clojure.string/split % #","))
                      distinct
                      (filter (comp (partial every? (comp not number?))
                                    (partial map #(try (read-string %) (catch Exception e "")))
                                    #(clojure.string/split % #"-"))))]
    (with-open [wtr (clojure.java.io/writer "resources/vocabulary.txt")]
      (try (.write wtr (apply str (interpose "," new-list)))
           (catch Exception e "")))))
(def vocabulary
  (-> (Thread/currentThread)
      .getContextClassLoader
      (.getResourceAsStream "vocabulary.txt")
      slurp
      (clojure.string/split #",")
      (interleave (range))
      ((partial apply hash-map))))
(defn annotate
  [input-string threshold]
  (->> input-string
       (#(clojure.string/split % #"[^\w'-]+|[_]+"))
       (map clojure.string/lower-case)
       distinct
       (map #(list % (vocabulary %)))
       (filter (comp not nil? second))
       (sort-by second >)
       (filter (comp (partial < threshold) second))))
(defn -main
  [& args]
  (let [threshold-read (try (read-string (first args)) (catch Exception e ""))
        threshold (if (number? threshold-read) threshold-read 10000)
        content (.getContents (.getSystemClipboard (Toolkit/getDefaultToolkit)) nil)
        input-string (if (.isDataFlavorSupported content DataFlavor/stringFlavor)
                       (.getTransferData content DataFlavor/stringFlavor) "")
        result (annotate input-string threshold)
        output-str (apply str (flatten (interpose \newline (map (juxt (comp (partial map identity) first)
                                                                      #(list \space (second %)))
                                                                result))))]
    (.setContents (.getSystemClipboard (Toolkit/getDefaultToolkit)) (StringSelection. output-str) nil)
    (println output-str)))
