package items

import maze.Maze


class Hero(initialPosition: Coordinates, power: Int) : Character(initialPosition, power) {
    private var direction = Direction.S

    override fun getLogo(): String {
        return direction.logo
    }

    fun displayCurrentStats() {
        println("hero power: $power")
        println("hero position: $currentPosition")
    }

    fun turnLeft() {
        this.direction = direction.left
    }

    fun turnRight() {
        this.direction = direction.right
    }

    fun rotate180() {
        this.direction = direction.opposite
    }

    fun moveForwardIn(maze: Maze) {
        val coordinate = Coordinates(currentPosition.x + direction.xForward, currentPosition.y + direction.yForward)
        if (!invalidMoveFromHere(coordinate, maze)) {
            currentPosition = coordinate
        }
    }

    private fun invalidMoveFromHere(coordinate: Coordinates, maze: Maze): Boolean {
        val x = coordinate.x
        val y = coordinate.y
        return maze.outsideLimits(x, y) || hitsFloor(x, y, maze) || hitsWall(x, y, maze)
    }

    private fun hitsFloor(x: Int, y: Int, maze: Maze): Boolean {
        return (direction == Direction.S && maze.hasFloorAt(x, y))
                || (direction == Direction.N && maze.hasFloorAt(x, y + 1))
    }

    private fun hitsWall(x: Int, y: Int, maze: Maze): Boolean {
        return (direction == Direction.E && maze.hasWallAt(x, y))
                || (direction == Direction.W && maze.hasWallAt(x + 1, y))
    }

}