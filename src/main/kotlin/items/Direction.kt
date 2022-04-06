package items

enum class Direction(val logo: String, val xForward: Int, val yForward: Int) {
    N("▲", 0, -1),
    S("▼", 0, 1),
    E("►", 1, 0),
    W("◄", -1, 0);

    val left: Direction
        get() = when (this) {
            N -> W
            S -> E
            E -> N
            W -> S
        }

    val right: Direction
        get() = when (this) {
            N -> E
            S -> W
            E -> S
            W -> N
        }

    val opposite: Direction
        get() = when (this) {
            N -> S
            S -> N
            E -> W
            W -> E
        }


}