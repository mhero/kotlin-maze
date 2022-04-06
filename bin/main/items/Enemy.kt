package items

class Enemy(initialPosition: Coordinates, power: Int) : Character(initialPosition, power) {
    override fun getLogo(): String {
        return "X"
    }
}