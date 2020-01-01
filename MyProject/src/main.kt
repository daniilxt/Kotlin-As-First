fun main() {
  val t = Text()

  do {
    val str = readLine()
    t.parseString(str)
  } while (str != null)

  t.printContainer()
}