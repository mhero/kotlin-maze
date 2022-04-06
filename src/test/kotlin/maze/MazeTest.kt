package maze

import items.Coordinates
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue


internal class MazeTest {
    private lateinit var mazeH: Maze
    private lateinit var mazeV: Maze

    @BeforeEach
    fun setUp() {
        mazeH = Maze(Coordinates(1, 2))
        mazeV = Maze(Coordinates(2, 1))
    }

    @Test
    fun testSuccessTrueFloor() {
        val success = mazeH.hasFloorAt(0, 0)
        assertTrue(success)
    }

    @Test
    fun testSuccessFalseFloor() {
        val success = mazeV.hasFloorAt(0, 0)
        assertTrue(success)
    }

    @Test
    fun testSuccessFalseWall() {
        val success = mazeH.hasWallAt(0, 0)
        assertTrue(success)
    }

    @Test
    fun testSuccessTrueWall() {
        val success = mazeV.hasWallAt(0, 0)
        assertTrue(success)
    }

    @Test
    fun testSuccessTrueLimits() {
        var success: Boolean? = mazeV.outsideLimits(1, 1)
        assertTrue(success!!)
        success = mazeH.outsideLimits(2, 2)
        assertTrue(success)
    }
}