package items

class Coordinates(val x: Int, val y: Int) {

    override fun equals(other: Any?): Boolean {
        var isEqual = false
        if (other != null && other is Coordinates) {
            isEqual = x == other.x && y == other.y
        }
        return isEqual
    }

    override fun toString(): String {
        return "x: $x y: $y"
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}