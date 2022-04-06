package items

class Hero(initialPosition: Coordinates, power: Int) : Character(initialPosition, power) {
    private var direction = Direction.S

    override fun getLogo(): String {
        return direction.logo
    }
}