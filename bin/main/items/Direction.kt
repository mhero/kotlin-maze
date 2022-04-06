package items

enum class Direction(val logo: String, val xForward: Int, val yForward: Int) {
    N("▲", 0, -1),
    S("▼", 0, 1),
    E("►", 1, 0),
    W("◄", -1, 0);

    private var left: Direction? = null
    private var right: Direction? = null
    private var opposite: Direction? = null

    companion object {
        init {
            N.left = W
            S.left = E
            E.left = N
            W.left = S
            N.right = E
            S.right = W
            E.right = S
            W.right = N
            N.opposite = S
            S.opposite = N
            E.opposite = W
            W.opposite = E
        }
    }
}