package challenge

import java.util.*

enum class Topic {
    GAME_OF_THRONES, COOKING;

    companion object {
        private val VALUES = listOf(*values())
        private val SIZE = VALUES.size
        private val RANDOM: Random = Random()
        fun randomTopic(): Topic {
            return VALUES[RANDOM.nextInt(SIZE)]
        }
    }
}