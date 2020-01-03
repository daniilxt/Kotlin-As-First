fun main() {
  val t = Text()
  var MIN_WIDTH: Int
  try {
    MIN_WIDTH = readLine()!!.toInt()
  } catch (e:NumberFormatException){
    MIN_WIDTH = 40
    println("Default is $MIN_WIDTH")
  }

  do {
    val str = readLine()
    t.parseString(str)
  } while (str != null)
  t.printContainer(MIN_WIDTH)
}