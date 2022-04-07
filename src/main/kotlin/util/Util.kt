package util

import java.util.*

class Util {
    companion object {
        fun pressAnyKey(message: String?) {
            val sc = Scanner(System.`in`)
            println(message)
            sc.nextLine()
        }

        fun <T> merge(first: List<T>, second: List<T>): List<T> {
            return first + second
        }
    }
}