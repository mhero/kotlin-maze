package items

abstract class Character(initialPosition: Coordinates, var power: Int) {
    var currentPosition = initialPosition

    abstract fun getLogo(): String
}