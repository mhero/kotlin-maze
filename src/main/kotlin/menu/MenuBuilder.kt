package menu

import Game
import java.util.*
import kotlin.system.exitProcess


class MenuBuilder {
    private lateinit var menu: Menu
    private lateinit var game: Game

    init {
        val mainMenu = Menu("Main", "")
        val subMenuGame = Menu("Game", "current game")
        mainMenu.putAction("start new game") {
            game = Game()
            game.display()
            activateMenu(subMenuGame)
        }
        mainMenu.putAction("load game") {
            if (game != null) {
                println("game loaded")
                game.display()
                activateMenu(subMenuGame)
            } else {
                println("failed to load game")
                activateMenu(mainMenu)
            }
        }
        mainMenu.putAction("save current game") {
            println("game saved")
            activateMenu(mainMenu)
        }
        mainMenu.putAction("quit") {
            println("game ended, return soon!")
            exitProcess(0)
        }
        subMenuGame.putAction("step forward") {
            game.moveHeroForward()

            game.display()
            activateMenu(subMenuGame)
        }
        subMenuGame.putAction("rotate 180ª") {
            game.rotateHero180()
            game.display()
            activateMenu(subMenuGame)
        }
        subMenuGame.putAction("turn left") {
            game.turnHeroLeft()
            game.display()
            activateMenu(subMenuGame)
        }
        subMenuGame.putAction("turn right") {
            game.turnHeroRight()
            game.display()
            activateMenu(subMenuGame)
        }
        subMenuGame.putAction("main menu") { activateMenu(mainMenu) }
        activateMenu(mainMenu)
    }

    private fun activateMenu(newMenu: Menu) {
        menu = newMenu
        println(newMenu.generateText())
        while (true) {
            try {
                val scanner = Scanner(System.`in`)
                val actionNumber = scanner.nextLine().toInt()
                menu.executeAction(actionNumber)
            } catch (ex: NumberFormatException) {
                println("Invalid input. Please try again.")
            }
        }
    }
}