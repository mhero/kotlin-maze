package challenge

import java.util.*

class Trivia {
    private var answers: List<String>
    var questionsByTopic: MutableMap<Topic?, List<Question>> = HashMap()

    init {
        val gameOfThronesQuestions: MutableList<Question> = ArrayList()
        gameOfThronesQuestions
            .add(Question("Is Dany a wizard or a targaryen?", listOf("wizard", "targaryen"), 2))
        gameOfThronesQuestions.add(Question("Is Robert a chef or a king?", listOf("king", "chef"), 1))
        questionsByTopic[Topic.GAME_OF_THRONES] = gameOfThronesQuestions

        val cookingQuestions: MutableList<Question> = ArrayList()
        cookingQuestions.add(Question("Is cake a fruit or a desert?", listOf("fruit", "desert"), 2))
        cookingQuestions
            .add(Question("Do you put salt or sugar in your coffee?", listOf("salt", "sugar"), 2))
        questionsByTopic[Topic.COOKING] = cookingQuestions

        answers = listOf("is it? lol", "are you sure? I am asking...I'm not sure either", "uhmmm...")
    }

    fun getQuestion(topic: Topic?): Question {
        val questionTopic = topic ?: Topic.randomTopic()
        val random = Random()
        val questions = questionsByTopic[questionTopic]!!
        return questions[random.nextInt(questions.size)]
    }

    val answer: String
        get() {
            val random = Random()
            return answers[random.nextInt(answers.size)]
        }
}