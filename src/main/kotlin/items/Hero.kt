package items

class Hero(initialPosition: Coordinates, power: Int) : Character(initialPosition, power) {
    private var direction = Direction.S

    override fun getLogo(): String {
        return direction.logo
    }

    fun displayCurrentStats() {
        print("hero power: $power")
        println("hero position: $curentPosition")
    }

    fun turnLeft() {
        this.direction = direction.left
    }

    fun turnRight() {
        this.direction = direction.right
    }

    fun rotate180() {
        this.direction = direction.opposite
    }
}