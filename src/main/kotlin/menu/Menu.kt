package menu

class Menu(private val name: String, private val text: String) {
    private val actionsMap = LinkedHashMap<String, Runnable>()

    fun putAction(name: String, action: Runnable) {
        actionsMap[name] = action
    }

    fun generateText(): String {
        val actionNames = ArrayList(actionsMap.keys)

        return StringBuilder().run {
            append("$name: $text:\n")
            for (i in actionNames.indices) {
                append(String.format(" %d: %s%n", i + 1, actionNames[i]))
            }
            append("Enter number and press return :)")
            toString()
        }
    }

    fun executeAction(actionNumber: Int) {
        val effectiveActionNumber = actionNumber - 1
        if (effectiveActionNumber < 0 || effectiveActionNumber >= actionsMap.size) {
            println("Ignoring menu choice: $actionNumber")
        } else {
            val actions: List<Runnable> = ArrayList(actionsMap.values)
            actions[effectiveActionNumber].run()
        }
    }
}