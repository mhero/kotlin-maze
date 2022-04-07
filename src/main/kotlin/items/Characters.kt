package items

import maze.Maze

class Characters(mazeSize: Int) {

    private val ENEMY_AMOUNT = 8
    private val ENEMY_POWER = 20
    private val HERO_POWER = 100
    private val hero: Hero = Hero(Coordinates(0, 0), HERO_POWER)
    private val characters = mutableListOf<Character>()

    init {
        characters.add(hero)
        repeat(ENEMY_AMOUNT) {
            characters.add(
                Enemy(validCoordinate(mazeSize), ENEMY_POWER)
            )
        }
    }

    fun moveHeroForwardIn(maze: Maze) {
        hero.moveForwardIn(maze)
    }

    fun spaceFor(coordinate: Coordinates): String {
        val distinctBy = characters.firstOrNull { it.currentPosition.equals(coordinate) }
        return distinctBy?.getLogo() ?: " "
    }

    private fun validCoordinate(mazeSize: Int): Coordinates {
        var x: Int
        var y: Int

        do {
            x = (0 until mazeSize).random()
            y = (0 until mazeSize).random()
        } while ((x == 0 && y == 0) || (x == mazeSize - 1 && y == mazeSize - 1))

        return Coordinates(x, y)
    }
}