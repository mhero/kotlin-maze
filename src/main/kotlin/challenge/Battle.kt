package challenge

import java.util.*

class Battle {
    private lateinit var sc: Scanner

    fun result(): Boolean {
        val question = askQuestion()
        val answer = getAnswer()
        return isCorrectAnswer(answer, question.correctAnswer)
    }

    private fun askQuestion(): Question {
        val question = Trivia().getQuestion(null)
        println(question.question)
        for (i in question.optionAnswers.indices) {
            println(String.format("%d. = %s", i + 1, question.optionAnswers[i]))
        }
        return question
    }

    private fun getAnswer(): Int {
        sc = Scanner(System.`in`)
        return sc.nextInt()
    }

    private fun isCorrectAnswer(userAnswer: Int, correctAnswer: Int): Boolean =
        if (userAnswer == correctAnswer) true else randomizeAnswerResult()

    private fun randomizeAnswerResult(): Boolean {
        val rand = Random()
        val answer = Trivia().answer
        println()
        return if (rand.nextBoolean()) {
            println(answer)
            true
        } else {
            println("NOPE!")
            false
        }
    }
}