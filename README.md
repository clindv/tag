# tag

将剪切板的英语文本词频排序后输入回剪切板，Ctrl+V查看结果。

## Installation

可另行下载换用更高级的向量数据库
Download glove.6B.50d.txt to ./target from https://nlp.stanford.edu/projects/glove/
Mirror link: https://www.kaggle.com/datasets/anindya2906/glove6b?resource=download
再依次调用acrostic和init-actostic-trim即完成resources构建，词汇量为acrostic函数的默认400000

## Usage

FIXME: explanation

    $ java -jar tag-0.1.0-standalone.jar [args]

## Options

可添加数字作为参数，filter easy words, default 10000. (designed for book思议 = 苏苏)

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

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
