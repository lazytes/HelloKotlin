/**
 * Author: ly(emiya.angra@gmail.com)
 * <p>
 * Date:  2017/6/8
 * <p>
 * Time:  9:33
 */
// 虽然可以放在任意位置 但是会报警告
package my.demo

import java.lang.*

/**
 * 主函数, 对应Java里面的main函数
 */
fun main(args: Array<String>) {
    Math.min(1, 2) // 为import java.lang.*添加, 防止格式化代码的时候被删掉
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

// 简写成 不能同名 所以改成sum2
fun sum2(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

// Unit可以被省略 简写成 不能同名 所以改成printSum2
fun printSum2(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

// 只读变量
val a: Int = 1
val b = 2
// val c: Int  // 这种写法必须在方法内才行
// c = 3

// 可变变量
var x = 5  // x自动检测为Int
// x += 1  // 写在方法内

// Kotlin支持Java的注释格式
/**
 * /**
 *  * Kotlin还支持注释块的嵌套
 *  */
 */
/*
  /*
     Kotlin还支持注释块的嵌套
   */
 */

// 字符串表达式
fun stringTemplates() {
    var a = 1 //
    val s1 = "a is $a"

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
}

// 使用条件表达式
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

// 使用if表达式后
fun maxOf2(a: Int, b: Int) = if (a > b) a else b // 重命名为maxOf2防冲突

// 使用可能为null的值并检查是否为null
fun parseInt(str: String): Int? {
    // 官方文档中这里没有写实现方法
    // 使用自己的判断, 我在接口中看到有现成的就直接用了
    // 具体使用?可以参考该方法的源码
    return str.toIntOrNull()
}

fun printProduction(arg1: String, arg2: String) {
    val x = parseInt(arg1) // 等价val x = arg1.toIntOrNull()
    val y = parseInt(arg2) // 等价val y = arg2.toIntOrNull()

    if (x != null && y != null) println(x * y)
    else println("either ‘$arg1’ or '$arg2' is a number")
}

// 使用类型检查和自动转换
fun getStringLength(obj: Any): Int? {
    if (obj is String) return obj.length
    return null
}

// 换一种写法
fun getStringLength2(obj: Any): Int? { // 重命名为getStringLength2防冲突
    if (obj !is String) return null
    return obj.length
}

// 使用for循环
fun forLoop() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) println(item)
}

// 使用while循环
fun whileLoop() {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

// 使用when表达式
fun describe(obj: Any): String =
        when (obj) { // 吐槽: 在这里idea的缩进真难看
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a String"
            else -> "Unknown"
        }

// 使用ranges
fun rangeAndIn() { // 使用range和in
    val x = 10
    val y = 9
    if (x in 1..y + 1) println("fit in ranges") // x在1-10之内就打印
}

fun checkOutOfRange() { // 检查数字是否超出范围
    var list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) println("-1 is out of range")
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
}

fun iteratorRange() { // 迭代一个范围
    for (x in 1..5) println(x)

    /**
     * 等价 for(int i = 1; i < 11; i += 2) {
     *          print(i);
     *      }
     */
    for (x in 1..10 step 2) print(x) // 从1开始每次增加2直到10

    /**
     * 等价 for(int i = 9; i > -1; i -= 3) {
     *          print(x);
     *      }
     */
    for (x in 9 downTo 0 step 3) print(x) // 从9开始每次减少3直到0
}

// 使用集合
fun iteratorCollections() {
    // 迭代一个集合
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) println(item)

    // 判断集合内的对象是否在操作符中使用
    when {
        "orange" in items -> "juicy"
        "apple" in items -> "apple is fine too"
    }

    // 使用拉姆达表达式并转换集合内的对象
    val fruits = listOf("apple", "banana", "kiwi")
    fruits
            // 这里的it应该是和gradle里面一样的隐参
            // 过滤集合, 条件为所有不是以a开头的全部过滤掉
            .filter { it.startsWith("a") }
            // 将集合内的对象全部排序
            // 这里是String, 应该是先按第一个字母排序，再按第二个字母排序
            .sortedBy { it }
            // 全部转换为大写(这里的map和RxJava好像)
            .map { it.toUpperCase() }
            // 打印出来
            .forEach { println(it) }
}
