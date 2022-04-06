package items

abstract class Character(initialPosition: Coordinates, power: Int) {
     var currePosition = initialPosition

    abstract fun getLogo():String
}