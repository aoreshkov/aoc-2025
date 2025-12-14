fun main() {
    fun part1(input: List<String>): Long {
        return input[0]
            .split(",")
            .map { str -> str.split("-").map { v -> v.toLong() } }
            .sumOf {
                var sum = 0L
                for (x in it[0]..it[1]) {
                    val y = x.toString()
                    if (y.take(y.length / 2) == y.substring(y.length / 2)) sum += x
                }
                sum
            }
    }

    fun part2(input: List<String>): Long {
        val sum = input[0]
            .split(",")
            .map { str -> str.split("-").map { v -> v.toLong() } }
            .sumOf {
                var sum = 0L
                for (x in it[0]..it[1]) {
                    if (x.check()) sum += x
                }
                sum
            }
        return sum
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 1227775554L)

    val input = readInput("Day02")
    part1(input).println()

    check(part2(testInput) == 4174379265L)

    part2(input).println()
}

private fun Long.check(): Boolean {
    val s = this.toString().toCharArray().toList()
    for(i in 1..s.size / 2) {
        if( s.chunked(i).toSet().size == 1) return true
    }
    return false
}
