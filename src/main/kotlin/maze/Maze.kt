package maze

import items.Characters
import items.Coordinates


class Maze(private var dimensions: Coordinates) {
    private val maze = MazeGenerator(dimensions).generateMaze()

    fun outsideLimits(x: Int, y: Int): Boolean {
        return x < 0 || y < 0 || x > dimensions.x - 1 || y > dimensions.y - 1
    }

    fun end(): Coordinates {
        return Coordinates(dimensions.x - 1, dimensions.y - 1)
    }

    fun hasFloorAt(x: Int, y: Int): Boolean {
        return (maze[x][y] and 1) == 0
    }

    fun hasWallAt(x: Int, y: Int): Boolean {
        return (maze[x][y] and 8) == 0
    }

    fun display(characters: Characters) {
        val x = dimensions.x
        val y = dimensions.y
        for (i in 0 until y) {
            for (j in 0 until x) {
                print(if ((maze[j][i] and 1) == 0) "+---" else "+   ")
            }
            println("+")
            for (j in 0 until x) {
                var event = if ((maze[j][i] and 8) == 0) "| x " else "  x "
                if (j == x - 1 && i == y - 1) {
                    event = if ((maze[j][i] and 8) == 0) "| END" else " END"
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

    companion object {
        fun validCoordinate(mazeDimensions: Coordinates): Coordinates {
            var x: Int
            var y: Int

            do {
                x = (0 until mazeDimensions.y).random()
                y = (0 until mazeDimensions.y).random()
            } while ((x == 0 && y == 0) || (x == mazeDimensions.x - 1 && y == mazeDimensions.y - 1))

            return Coordinates(x, y)
        }
    }

}