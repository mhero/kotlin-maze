package items

import challenge.Battle
import maze.Maze
import util.Util

class Characters(mazeSize: Int) {

    private val ENEMY_AMOUNT = 8
    private val ENEMY_POWER = 20
    private val HERO_POWER = 100
    private val hero: Hero = Hero(Coordinates(0, 0), HERO_POWER)
    private val enemies = mutableListOf<Character>()

    init {
        repeat(ENEMY_AMOUNT) {
            val enemy = Enemy(validCoordinate(mazeSize), ENEMY_POWER)
            enemies.add(enemy)
        }
    }

    fun displayHeroStats() {
        hero.displayCurrentStats()
    }

    fun moveHeroForwardIn(maze: Maze) {
        hero.moveForwardIn(maze)
    }

    fun collidingEnemy(): Boolean {
        return getCharacterAt(hero.currentPosition, enemies) != null
    }

    fun heroIsAtEnd(maze: Maze): Boolean {
        return hero.currentPosition.equals(maze.end())
    }

    fun heroScore() {
        println(java.lang.String.format("Your score is %d", hero.power))
        println("You finished the puzzle!")
        if (hero.power < 0) {
            println("...but with a negative score...so...haha!")
        }
        Util.pressAnyKey("Press any key to play again...")
    }

    fun battle() {
        val battleResult = Battle().result()
        val enemyPower = removeEnemyColliding()
        val heroHit = if (battleResult) enemyPower else enemyPower * -1
        hero.heroBattleOutcome(heroHit)
    }

    private fun removeEnemyColliding(): Int {
        val enemy = getCharacterAt(hero.currentPosition, enemies)
        enemies.removeAll { it.currentPosition.equals(hero.currentPosition) }
        return enemy?.power ?: 0
    }

    fun turnHeroLeft() {
        hero.turnLeft()
    }

    fun turnHeroRight() {
        hero.turnRight()
    }

    fun rotateHero180() {
        hero.rotate180()
    }

    fun spaceFor(coordinate: Coordinates): String {
        return getCharacterAt(
            coordinate,
            Util.merge(listOf(hero), enemies)
        )?.getLogo() ?: " "
    }

    private fun getCharacterAt(coordinate: Coordinates, characters: List<Character>): Character? {
        return characters.firstOrNull { it.currentPosition.equals(coordinate) }
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