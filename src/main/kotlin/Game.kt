import items.*
import maze.Maze
import java.io.IOException


class Game {
    private val maze: Maze
    private val characters: Characters
    private val MAZE_SIZE = 5

    init {
        maze = Maze(Coordinates(MAZE_SIZE, MAZE_SIZE))
        characters = Characters(MAZE_SIZE)

    }

    fun display() {
        maze.display(characters)
    }

    fun moveHeroForward() {
        characters.moveHeroForwardIn(this.maze)
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