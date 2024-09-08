package challenge

import java.util.*

enum class Topic {
    GAME_OF_THRONES, COOKING;

    companion object {
        private val VALUES = Topic.entries
        private val SIZE = VALUES.size
        fun randomTopic(): Topic {
            return VALUES[Random().nextInt(SIZE)]
        }
    }
}