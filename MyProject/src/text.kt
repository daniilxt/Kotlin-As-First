import java.util.*

class Text() {
  private var text_ = arrayListOf<String>()
  fun parseString(str: String?): Unit {
    if (str != null && str != "") {
      var i = 0
      while (i != str.lastIndex + 1) {
        if (str[i].isLetter()) {
          val tmp = parseWord(str, i)
          text_.add(tmp.first)
          if (tmp.second < str.length) {
            i = tmp.second
          } else break
        } else if (str[i].isDigit()) {
          val tmp = parseDigit(str, i)
          text_.add(tmp.first)
          if (tmp.second < str.length) {
            i = tmp.second
          } else break
        } else if (str[i].isWhitespace()) {
          i++
        } else if (str[i].isDefined()) {
          val tmp = parsePunct(str, i)
          text_.add(tmp.first)
          if (tmp.second < str.length) {
            i = tmp.second
          } else break
        }
      }
    }
  }

  fun printContainer(minSize: Int): Unit {
/*    for (i in text_) {
      println("$i ")
    }*/
    var line = StringBuilder()
    for (item in text_) {
      if ((line.toString() + item).length <= minSize) {
        line.append(item)
        line.append(' ')
      } else {
        println(line)
        line.clear()
      }
    }
    if (line.isNotEmpty()){
      println(line)
    }
  }
}
