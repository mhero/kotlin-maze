package items

abstract class Character(initialPosition: Coordinates, val power: Int) {
    var curentPosition = initialPosition

    abstract fun getLogo(): String
}