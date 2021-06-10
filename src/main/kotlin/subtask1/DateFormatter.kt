package subtask1

import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {
    private var iDay :Int = 0;
    private var iMonth :Int = 0;
    private var iYear :Int = 0;

    fun toTextDay(day: String, month: String, year: String): String {
        iDay   = day.toIntOrNull() ?: 0
        iMonth = month.toIntOrNull() ?: 0
        iYear  = year.toIntOrNull() ?: 0

        if (!isPossiblyDate(iDay, iMonth, iYear))
            return "Такого дня не существует"

        val textMonth = intMonthToRussianText(iMonth)
        val dayOfWeek = dayOfWeekToText(whatTheDayOfWeek(iDay, iMonth, iYear))

        return "$day $textMonth, $dayOfWeek"
    }

    private fun whatTheDayOfWeek(day :Int, month: Int, year :Int) :Int {
        var daysFromBeginnings =  countAllDaysForYears(year)
            daysFromBeginnings += countAllDaysForMonthes(month, year)
            daysFromBeginnings += day
        return (daysFromBeginnings % 7)
    }

    private fun isPossiblyDate(day :Int, month: Int, year :Int) : Boolean{
        if (day > 0) {
            when (month) {
                1, 3, 5, 7, 8, 10, 12 -> if(day <= 31) return true
                4, 6, 9, 11 -> if(day <= 30) return true
            }
        }
        if((month == 2) && (day == 29) && (year % 4) == 0 && (year % 100) != 0) return true
        if((month == 2) && (day <= 28)) return true
        return false
    }

    private fun countAllDaysForYears(year: Int) : Int {
        var count = (year-1) * 365
        count += ((year-1) / 4)
        count -= ((year-1) / 100)
        count += ((year-1) / 400)
        return count
    }

    private fun countAllDaysForMonthes(month: Int, year: Int) :Int {
        var count = 0
        for (i in 0 until month) {
            count += daysInThisMonth(i, year)
        }
        return count
    }

    private fun daysInThisMonth (month: Int, year: Int) :Int{
        when (month) {
            1, 3, 5, 7, 8, 10, 12 -> return 31
            4, 6, 9, 11 -> return 30
        }
        if((month == 2) && isLeapYear(year)) return 29
        if(month == 2) return 28
        return 0
    }

    private fun intMonthToRussianText(month: Int) :String {
        when (month) {
            1 -> return "января"
            2 -> return "февраля"
            3 -> return "марта"
            4 -> return "апреля"
            5 -> return "мая"
            6 -> return "июня"
            7 -> return "июля"
            8 -> return "августа"
            9 -> return "сентября"
            10 -> return "окрября"
            11 -> return "ноября"
            12 -> return "декабря"
        }
        return "небритября"
    }

    private fun dayOfWeekToText(dayOfWeek :Int) :String {
        when (dayOfWeek) {
            0 -> return "воскресенье"
            1 -> return "понедеьник"
            2 -> return "вторник"
            3 -> return "среда"
            4 -> return "четверг"
            5 -> return "пятница"
            6 -> return "суббота"
        }
        return "бездельник"
    }

    private fun isLeapYear(year: Int) :Boolean {
        return (((year % 4) == 0) && ((year % 100) != 0 || (year % 400) == 0))
    }
}
