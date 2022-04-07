package items

abstract class Character(private val initialPosition: Coordinates, var power: Int) {
    var currentPosition = initialPosition

    abstract fun getLogo(): String
}