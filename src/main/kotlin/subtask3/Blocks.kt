package subtask3

import java.time.LocalDate
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        if (blockB == Int::class) {
            var count = 0
            blockA.forEach {
                if (it is Int) {
                    count += it
                }
            }
            return count
        }

        if (blockB == String::class) {
            var text = ""
            blockA.forEach {
                if (it is String) {
                    text += it
                }
            }
            return text
        }

        if (blockB == LocalDate::class) {
            var date :LocalDate = LocalDate.ofEpochDay(0)
            blockA.forEach {
                if (it is LocalDate) {
                    if (it > date) date = it
                }
            }
            return "${date.dayOfMonth}.${date.monthValue}.${date.year}"
        }

        return false
    }
}
