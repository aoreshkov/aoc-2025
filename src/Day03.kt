fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            val d = it.toCharArray().map { c -> c.digitToInt() }
            val max = d.take(d.size - 1).max()
            val p = d.indexOf(max)
            val min = d.drop(p + 1).max()
            max * 10 + min
        }
    }

    fun part2(input: List<String>): Long {
        return input.sumOf {
            var sum = 0L
            var d = it.toCharArray().map { c -> c.digitToInt() }
            for(i in 6 downTo 1) {
                val max = d.take(d.size - i * 2 + 1).max()
                val l = d.indexOf(max)
                val min = d.drop(l + 1).dropLast(i * 2 - 2).max()
                val r = l + 1 + d.drop(l + 1).indexOf(min)
                sum = sum * 100 + max * 10 + min
                d = d.drop(r + 1)
            }
            sum
        }
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 357)

    val input = readInput("Day03")
    part1(input).println()

    check(part2(testInput) == 3121910778619L)

    part2(input).println()
}