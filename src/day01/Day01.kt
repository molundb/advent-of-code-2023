fun main() {
    val input = readInput("day01/Day01_input")

    solvePartOne(input)
}

private fun solvePartOne(input: List<String>) {
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

    print(sum)
}
