# tag
将剪切板的英语文本词频排序，输入回剪切板，Ctrl+V查看结果。

## Installation

下载 https://github.com/clindv/tag/releases/download/取词器/tag.jar

## Usage

先Ctrl+C整本书，再运行
    $ java -jar tag.jar
Ctrl+V查看结果

## Options

默认过滤掉最常见的10000个简单词汇。(designed for book思议 = 苏苏)
可添加数字参数调整
    $ java -jar tag.jar 50000
即忽略掉最常见的50000个单词

## Examples

Ctrl+C复制小说《老人与海》，运行
    $ java -jar tag.jar 200000
打开任意编辑软件如记事本，Ctrl+V粘贴可见
albacores 346366
convulsively 335877
manolin 324817
slitted 316443
two-decker 294827
long-winged 293413
treacheries 290339
oakum 282597
guanabacoa 280438
fishless 273004
hatuey 270710
mushed 266906
fibered 250140
hueso 240910
eighty-fifth 240889
panic-stricken 237430
broadbill 237367
campeon 218013
gunwale 211338
ligas 208038

### Might be Useful

可另行下载换用更高级的向量数据库。
Download glove.6B.50d.txt to ./target from https://nlp.stanford.edu/projects/glove/
Mirror link: https://www.kaggle.com/datasets/anindya2906/glove6b?resource=download
再依次调用acrostic和init-actostic-trim即完成resources构建
默认词汇量为acrostic函数中的400000

## License

Copyright © 2023 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
