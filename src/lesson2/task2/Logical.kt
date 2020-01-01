@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
  if ((number % 10) + ((number / 10) % 10) == (((number / 10) / 10) % 10) + ((((number / 10) / 10) / 10) % 10)) {
    println("Is True")
    return true
  }
  print("Is False")
  return false
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
  return ((x1 == x2) || (y1 == y2)) || ((abs(x1 - x2) == abs(y1- y2)))
}

/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
  val date_31 = listOf(1, 3, 5, 7, 8, 10, 12)
  val date_30: List<Int> = listOf(4, 6, 9, 11)

  if (month in date_31 ) {
    return 31
  }
  else if (month in date_30) {
    return 30
  }
  else if ((month == 2) && (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))) {
    return 29
  }
  else if (month == 2) {
    return 28
  }
  else return -1
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {
  return sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2)) <= r2 - r1
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
  return ((a <= s) && (c <= r)) || ((b <=s) && (c <=r))
}

fun main (args: Array<String>) {
  print(circleInside(2.0, 2.0, 2.0, 2.0, 2.0, 2.0))
}