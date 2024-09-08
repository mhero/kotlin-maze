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
        val width = dimensions.x
        val height = dimensions.y
        val closedHorizontal = "+---"
        val openHorizontal = "+   "
        val closedVertical = "|"
        val openVertical = " "
        val endLabel = "END"
        val border = "+"

        fun printHorizontalWalls(row: Int) {
            val rowWalls = StringBuilder()
            for (column in 0 until width) {
                rowWalls.append(if ((maze[column][row] and 1) == 0) closedHorizontal else openHorizontal)
            }
            rowWalls.append(border)
            println(rowWalls)
        }

        fun printVerticalWalls(row: Int) {
            val rowWalls = StringBuilder()
            for (column in 0 until width) {
                val coordinates = Coordinates(column, row)
                val cellContent = characters.spaceFor(coordinates)
                val wallOrSpace = if ((maze[column][row] and 8) == 0) closedVertical else openVertical
                val cellText = if (column == width - 1 && row == height - 1) {
                    if (wallOrSpace == closedVertical) "$wallOrSpace$endLabel" else "$openVertical$endLabel"
                } else {
                    "$wallOrSpace $cellContent "
                }
                rowWalls.append(cellText)
            }
            rowWalls.append(closedVertical)
            println(rowWalls)
        }

        for (row in 0 until height) {
            printHorizontalWalls(row)
            printVerticalWalls(row)
        }

        // Print the bottom border
        println((closedHorizontal.repeat(width)) + border)
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