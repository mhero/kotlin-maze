package maze

enum class Direction(val bit: Int, val dx: Int, val dy: Int) {
    N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);

    lateinit var opposite: Direction

    companion object {
        // use the static initializer to resolve forward references
        init {
            N.opposite = S
            S.opposite = N
            E.opposite = W
            W.opposite = E
        }
    }
}