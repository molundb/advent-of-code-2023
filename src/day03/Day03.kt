package day03

import readInput
import java.lang.StringBuilder

fun main() {
    val input = readInput("day03/Day03_input")

    print(solvePartOne(input))
//    print(solvePartTwo(input))
}

private fun solvePartOne(input: List<String>): Int {
    var sum = 0

    for (i in input.indices) {
        val line = input[i]

        val numberBuilder = StringBuilder()

        for (j in line.indices) {
            val c = line[j]

            if (c.isDigit()) {
                numberBuilder.append(c)
            }

            if (numberBuilder.isNotEmpty() && (!c.isDigit() || j == line.length - 1)) {
                // number found
                val startJ = j - numberBuilder.length
                val number = numberBuilder.toString().toInt()
                numberBuilder.clear()

                var toAdd = addNumberIfAdjacentSymbol(i, input, startJ, number)
                if (toAdd == 0) {
                    toAdd = addNumberIfAdjacentSymbol(i, input, j - 1, number)
                }
                sum += toAdd
            }
        }
    }

    return sum
}

private fun addNumberIfAdjacentSymbol(
    i: Int,
    input: List<String>,
    numberEdgeJ: Int,
    number: Int,
): Int {
    if (numberEdgeJ > 0) {
        if (input[i][numberEdgeJ - 1].isSymbol()) {
            return number
        }
    }

    if (numberEdgeJ < input[i].length) {
        if (input[i][numberEdgeJ + 1].isSymbol()) {
            return number
        }
    }

    if (i > 0) {
        if (numberEdgeJ > 0) {
            if (input[i - 1][numberEdgeJ - 1].isSymbol() ||
                input[i - 1][numberEdgeJ].isSymbol()
            ) {
                return number
            }
        }

        if (numberEdgeJ < input[i].length - 1) {
            if (input[i - 1][numberEdgeJ + 1].isSymbol()) {
                return number

            }
        }
    }

    if (i < input.size - 1) {
        if (numberEdgeJ > 0) {
            if (input[i + 1][numberEdgeJ - 1].isSymbol() ||
                input[i + 1][numberEdgeJ].isSymbol()
            ) {
                return number
            }
        }

        if (numberEdgeJ < input[i].length - 1) {
            if (input[i + 1][numberEdgeJ + 1].isSymbol()) {
                return number
            }
        }
    }
    return 0
}

private fun Char.isSymbol() = !this.isDigit() && this != '.'


private fun solvePartTwo(input: List<String>) {

}
