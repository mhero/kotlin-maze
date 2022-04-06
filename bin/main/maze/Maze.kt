package maze

import items.Coordinates
import items.Characters

class Maze(var dimensions: Coordinates) {
    private val maze = MazeGenerator(dimensions).generateMaze()

    fun display(characters: Characters) {
        val x = dimensions.x
        val y = dimensions.y
        for (i in 0 until y) {
            for (j in 0 until x) {
                print(if (maze[j][i] and 1 == 0) "+---" else "+   ")
            }
            println("+")
            for (j in 0 until x) {
                var event = if (maze[j][i] and 8 == 0) "| x " else "  x "
                if (j == x - 1 && i == y - 1) {
                    event = if (maze[j][i] and 8 == 0) "| END" else " END"
                    print(event)
                } else {
                    print(event.replace("x", characters.spaceFor(Coordinates(j, i))))
                }
            }
            println("|")
        }
        for (j in 0 until x) {
            print("+---")
        }
        println("+")
    }

}