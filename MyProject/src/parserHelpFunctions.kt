val punct_ = arrayListOf<Char>('.', ',', ':', ';', '-')
fun isPunctuation(ch: Char?): Boolean
{
  return ch in punct_
}

fun parseWord(str: String?, index: Int): Pair<String, Int>
{
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

fun parseDigit(str: String?, index: Int): Pair<String, Int>
{
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

fun parsePunct(str: String?, index: Int): Pair<String, Int>
{
  var line: String = ""
  var i = index

  while ((isPunctuation(str?.get(i))) && (i != str?.lastIndex)) {
    line += str?.get(i)
    i++
  }
  if (i == str?.lastIndex && isPunctuation(str[i])) {
    line += str[i]
    i++
  }
  return Pair(line, i)
}

fun firstUpperCase(word:String):String {
  if (word.isEmpty()) return "";//или return word;
  return word.substring(0, 1).toUpperCase() + word.substring(1)
}