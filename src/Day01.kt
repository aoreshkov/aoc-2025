fun main() {
    fun part1(input: List<String>): Int {
        var start = 50
        return input
            .map { line -> line[0] to line.drop(1).toInt() }
            .filter { instruction ->
                if(instruction.first == 'R') start += instruction.second
                else if(instruction.first == 'L') start -= instruction.second
                while(start < 0) start += 100
                while(start > 99) start -= 100
                start == 0
            }
            .size
    }

    fun part2(input: List<String>): Int {
        var start = 50
        var nb = 0

        input
            .map { line -> line[0] to line.substring(1).toInt() }
            .forEach { instruction ->
            if(instruction.first == 'R') {
                start += instruction.second
                while(start > 99) {
                    start -= 100
                    nb++
                }
            }
            else if(instruction.first == 'L') {
                if(start == 0) nb--
                start -= instruction.second
                while(start < 0) {
                    start += 100
                    nb++
                }
                if(start == 0) nb++
            }
        }
        return nb
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 3)

    val input = readInput("Day01")
    part1(input).println()

    check(part2(testInput) == 6)

    part2(input).println()
}