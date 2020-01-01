import java.util.*

class Text() {
  private var text_ = arrayListOf<String>()
  private val punct_ = arrayListOf<Char>()

  fun parseString(str: String?): Unit {
    if (str != null && str!="") {
      var i = 0
      while (i != str.lastIndex+1) {
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
        } else if (str[i].isDefined())
          i++
      }
    }
  }

  fun printContainer(): Unit {
    for (i in text_) {
      println("$i ")
    }
  }
}

fun parseWord(str: String?, index: Int): Pair<String, Int> {
  var line: String = ""
  var i = index

  while ((str?.get(i)?.isLetter()!!) && (i != str.lastIndex)) {
    line += str[i]
    i++
  }
  if (i == str.lastIndex && str[i].isLetter()) {
    line += str.get(i)
    i++
  }
  return Pair(line, i)
}

fun parseDigit(str: String?, index: Int): Pair<String, Int> {
  var line: String = ""
  var i = index

  while ((str?.get(i)?.isDigit()!!) && (i != str.lastIndex)) {
    line += str[i]
    i++
  }
  if (i == str.lastIndex && str[i].isDigit()) {
    line += str[i]
    i++
  }
  return Pair(line, i)
}