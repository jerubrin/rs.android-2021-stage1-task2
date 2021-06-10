package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var listA = a.toUpperCase().toMutableList()
        val listB = b.toList()

        var i = 0
        while ((i <= listA.lastIndex) && (i <= listB.lastIndex)) {
            if (listA[i] != listB[i]) listA.removeAt(i) else i++
        }

        if (listA.lastIndex > listB.lastIndex) listA = listA.subList(0, listB.lastIndex+1)

        return if (listA == listB) "YES" else "NO"
    }
}
