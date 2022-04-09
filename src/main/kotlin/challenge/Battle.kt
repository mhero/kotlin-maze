package challenge

import java.util.*

class Battle {
    fun result(): Boolean {
        val isCorrectAnswer = isCorrectAnswer(
            getAnswer(),
            askQuestion().correctAnswer
        )
        if (isCorrectAnswer) {
            println("Correct!")
        }
        return isCorrectAnswer
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
        val sc = Scanner(System.`in`)
        return sc.nextInt()
    }

    private fun isCorrectAnswer(userAnswer: Int, correctAnswer: Int): Boolean =
        if (userAnswer == correctAnswer) true else randomizeAnswerResult()

    private fun randomizeAnswerResult(): Boolean {
        println("Your answer was incorrect! Let's randomize if you still win")
        return if (Random().nextBoolean()) {
            println(Trivia().answer)
            true
        } else {
            println("NOPE!")
            false
        }
    }
}