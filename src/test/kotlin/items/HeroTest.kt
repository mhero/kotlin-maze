package items

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class HeroTest {

    private lateinit var hero: Hero

    @BeforeEach
    fun setUp() {
        hero = Hero(Coordinates(0, 0), 1)
    }

    @Test
    fun getLogo() {
        assertEquals(hero.getLogo(), Direction.S.logo)
    }


    @Test
    fun turnLeft() {
        hero.turnLeft()
        assertEquals(hero.getLogo(), Direction.E.logo)
        hero.turnLeft()
        assertEquals(hero.getLogo(), Direction.N.logo)
        hero.turnLeft()
        assertEquals(hero.getLogo(), Direction.W.logo)
        hero.turnLeft()
        assertEquals(hero.getLogo(), Direction.S.logo)
    }

    @Test
    fun turnRight() {
        hero.turnRight()
        assertEquals(hero.getLogo(), Direction.W.logo)
        hero.turnRight()
        assertEquals(hero.getLogo(), Direction.N.logo)
        hero.turnRight()
        assertEquals(hero.getLogo(), Direction.E.logo)
        hero.turnRight()
        assertEquals(hero.getLogo(), Direction.S.logo)
    }

    @Test
    fun rotate180() {
        hero.rotate180()
        assertEquals(hero.getLogo(), Direction.N.logo)
        hero.rotate180()
        assertEquals(hero.getLogo(), Direction.S.logo)
        hero.turnRight()
        assertEquals(hero.getLogo(), Direction.W.logo)
        hero.rotate180()
        assertEquals(hero.getLogo(), Direction.E.logo)
        hero.rotate180()
        assertEquals(hero.getLogo(), Direction.W.logo)

    }
}