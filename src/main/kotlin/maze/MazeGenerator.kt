package maze

import items.Coordinates

open class MazeGenerator(private var dimensions: Coordinates) {
    private var maze: Array<IntArray> = Array(this.dimensions.x) { IntArray(this.dimensions.y) }

    fun generateMaze(): Array<IntArray> {
        generateMaze(0, 0)
        return maze
    }

    private fun generateMaze(cx: Int, cy: Int) {
        val directions = Direction.values()
        directions.shuffle()

        for (direction in directions) {
            val nx = cx + direction.dx
            val ny = cy + direction.dy
            if (between(nx, dimensions.x) && between(ny, dimensions.y) && maze[nx][ny] == 0) {
                maze[cx][cy] = maze[cx][cy] or direction.bit
                maze[nx][ny] = maze[nx][ny] or direction.opposite.bit
                generateMaze(nx, ny)
            }
        }

    }

    companion object {
        private fun between(v: Int, upper: Int): Boolean {
            return v in 0 until upper
        }
    }
}