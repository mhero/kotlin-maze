package maze

enum class Direction(val bit: Int, val dx: Int, val dy: Int) {
    N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);

    val opposite: Direction
        get() = when (this) {
            N -> S
            S -> N
            E -> W
            W -> E
        }
}