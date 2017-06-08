/**
 * Created by Administrator on 2017/6/7.
 */

val a: Int = 1
val b = 2
//val c: Int
//c = 3

var x = 5

fun main(args: Array<String>) {
    //println(sum(10, 2))
    //printProduction("a", "b")
    //printProduction("2", "2")

//    val items = listOf("apple", "banana", "kiwi")
//    for (item in items) println(item)
//    for (index in items.indices) println("item at $index is ${items[index]}")
//
//    var index = 0
//    while (index < items.size) {
//        println("item at $index is ${items[index]}")
//        index++
//    }

//    val x = 10
//    val y = 9
//    if (x in 1..y + 1) println("fit in ranges")

//    val list = listOf("a", "b", "c")
//    if (-1 !in 0..list.lastIndex) println("-1 is out of range")
//    if (list.size !in list.indices) println("list size is out of valid list indices range too")

//    for (x in 1..5) println(x)

//    /**
//     * 等价 for(int i = 1; i < 11; i += 2) {
//     *          println(i);
//     *      }
//     */
//    for (x in 1..10 step 2) println(x)
//
//    /**
//     * 等价 for(int i = 9; i > -1; i -= 3) {
//     *          print(x);
//     *      }
//     */
//    for (x in 9 downTo 0 step 3) print(x)

//    val items = listOf("apple", "banana", "kiwi")
//    for (item in items) println(item)
//
//    when {
//        "orange" in items -> println("juicy")
//        "apple" in items -> println("apple is fine too")
//    }

    val fruits = listOf("apple", "banana", "orange", "at", "an")

    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduction(arg1: String, arg2: String) {
    // val x = parseInt(arg1)
    val x = arg1.toIntOrNull()
    val y = parseInt(arg2)

    if (x != null && y != null) println(x * y)
    else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) return obj.length
    return null
}

fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a String"
            else -> "Unknown"
        }

