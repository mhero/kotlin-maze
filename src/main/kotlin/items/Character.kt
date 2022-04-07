package items

abstract class Character(initialPosition: Coordinates, val power: Int) {
    var currentPosition = initialPosition

    abstract fun getLogo(): String
}