package day02

import readInput
import java.lang.StringBuilder

fun main() {
    val input = readInput("day02/Day02_input")

    print(solvePartOne(input))
//    solvePartTwo(input)
}

private fun solvePartOne(input: List<String>): Int {
    var sum = 0

    for (i in input.indices) {
        var possible = true

        val content = input[i].split(':')[1]
        var j = 1
        while (j < content.length) {
            val s = StringBuilder()

            while (content[j].isDigit()) {
                s.append(content[j])
                j++
            }
            val c = s.toString().toInt()

            j += 1
            when (content[j]) {
                'r' -> {
                    if (c > 12) {
                        possible = false
                    }
                    j += 5
                }
                'b' -> {
                    if (c > 14) {
                        possible = false
                    }
                    j += 6
                }
                'g' -> {
                    if (c > 13) {
                        possible = false
                    }
                    j += 7
                }
            }
        }

        if (possible) {
            sum += i+1
        }
    }

    return sum
}

private fun solvePartTwo(input: List<String>) {

}