import items.*
import maze.Maze
import java.io.IOException

class Game {
    private val maze: Maze
    private val characters: Characters
    private val MAZE_DIMENSIONS = Coordinates(8, 6)

    init {
        maze = Maze(MAZE_DIMENSIONS)
        characters = Characters(MAZE_DIMENSIONS)
    }

    fun display() {
        cls()
        maze.display(characters)
        characters.displayHeroStats()
    }

    fun moveHeroForward() {
        characters.moveHeroForwardIn(this.maze)
        if (characters.collidingEnemy()) {
            characters.battle()
        }
    }

    fun finished(): Boolean {
        return characters.heroIsAtEnd(maze)
    }

    fun finishGame() {
        characters.heroScore()
    }


    fun turnHeroLeft() {
        characters.turnHeroLeft()
    }

    fun turnHeroRight() {
        characters.turnHeroRight()
    }

    fun rotateHero180() {
        characters.rotateHero180()
    }

    private fun cls() {
        try {
            val operatingSystem = System.getProperty("os.name")
            if (operatingSystem.contains("Windows")) {
                val pb = ProcessBuilder("cmd", "/c", "cls")
                val startProcess = pb.inheritIO().start()
                startProcess.waitFor()
            } else {
                val pb = ProcessBuilder("clear")
                val startProcess = pb.inheritIO().start()
                startProcess.waitFor()
            }
        } catch (ex: IOException) {
            print(ex)
        } catch (ex: InterruptedException) {
            print(ex)
        }
    }
}