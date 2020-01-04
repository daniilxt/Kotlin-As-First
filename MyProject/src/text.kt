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
        } else if (str[i].isDefined() && isPunctuation(str[i])) {
          val tmp = parsePunct(str, i)
          text_.add(tmp.first)
          if (tmp.second < str.length) {
            i = tmp.second
          } else break
        } else if (str[i].isDefined() && !isPunctuation(str[i])) {
          i++
        }
      }
    }
  }

  fun printContainer(minSize: Int): Unit {
    var flag = false
    var isFirst = true
    val line = StringBuilder()

    for (item in text_) {
      // for first UpperCase word
      if (isFirst) {
        line.append(firstUpperCase(text_[0]))
        line.append(' ')
        isFirst = false
        continue
      }
      if (item[0] == '.') {
        flag = true
      }
      // for UpperCase words after dot
      if (!isPunctuation(item[0]) && flag) {
        line.append(firstUpperCase(item))
        line.append(' ')
        flag = false
        continue
      }
      if ((line.toString() + item).length <= minSize) {
        line.append(item)
        line.append(' ')
      } else {
        println(line)
        line.clear()
        line.append(item)
        line.append(' ')
      }
    }
    if (line.isNotEmpty()) {
      println(line)
    }
  }

  fun statistics() {
    var words = 0
    var numbers = 0
    var punct = 0
    println("\nStatistics:")

    for (item in text_) {
      if (item[0].isLetter()) {
        words++
      } else if (item[0].isDigit()) {
        numbers++
      } else if (isPunctuation(item[0])) {
        punct++
      }
    }
    println(" Words: $words\n Numbers: $numbers\n Punctuations: $punct".trimMargin())
  }
}
