import java.lang.Integer.min

fun main() {
    val input = readInput("day01/Day01_input")

    solvePartOne(input)
    solvePartTwo(input)
}

private fun solvePartOne(input: List<String>): Int {
    var sum = 0

    for (line in input) {
        val first = line.find {
            it.isDigit()
        }

        val last = line.findLast {
            it.isDigit()
        }

        sum += "$first$last".toInt()
    }

    return sum
}

private fun solvePartTwo(input: List<String>): Int {
    var sum = 0

    val words = mapOf(
        "one" to '1',
        "two" to '2',
        "three" to '3',
        "four" to '4',
        "five" to '5',
        "six" to '6',
        "seven" to '7',
        "eight" to '8',
        "nine" to '9',
    )
    for (line in input) {
        val word = StringBuilder("")
        val lastWord = StringBuilder("")

        var first: Char? = null
        var last: Char? = null

        for (i in line.indices) {
            val c = line[i]
            val cb = line[line.length - 1 - i]

            if (first == null) {
                if (c.isDigit()) {
                    first = c
                }

                word.append(c)

                if (word.length >= 3) {
                    for (j in 3..min(5, word.length)) {
                        val subSequence = word.subSequence(word.length - j, word.length)
                        if (subSequence in words) {
                            first = words[subSequence]
                            break
                        }
                    }
                }
            }

            if (last == null) {
                if (cb.isDigit()) {
                    last = cb
                }

                lastWord.insert(0, cb)

                if (lastWord.length >= 3) {
                    for (j in 3..min(5, lastWord.length)) {
                        val subSequence = lastWord.subSequence(0, j)
                        if (subSequence in words) {
                            last = words[subSequence]
                            break
                        }
                    }
                }
            }

            if (first != null && last != null) {
                break
            }
        }

        sum += "$first$last".toInt()
    }

    return sum
}