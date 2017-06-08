import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Author: ly(emiya.angra@gmail.com)
 * <p>
 * Date:  2017/6/8
 * <p>
 * Time:  11:00
 */


fun main(args: Array<String>) {
//    val customer = Customer("Name", "Email", "Address")

//     foo()

//     filterList(listOf(0, 1, 2, 3, 4, 5))

//     stringInterpolation("Kotlin")

//    instanceCheck(customer)
//    instanceCheck(Foo("Name"))

//    val map = mapOf("a" to 0, "b" to 1, "c" to 2)
//    traversingMap(map)

//    useRanges(2)

//    readOnlyList()

//    readOnlyMap()

//    accessingMap()

//    println(p)

//    extensionFunctions()

//    val resource = Resource
//    val resource2 = Resource
//    可以看出打印的内存地址是一样的, 所以是单列
//    println("resource is $resource, resource2 is $resource2")

//    notNullShorthand("ABC")

//    notNullAndElseShorthand("ABC")

//    statementIfNull()

//    executeNotNull()

//    println(transform("Yellow"))

//    println(arrayOfMinusOnes(16))

//    testTurtle()

//    tryJdk7()
}

data class Customer(val name: String, val email: String, val address: String)

// 参数带默认值的方法
fun foo(a: Int = 0, b: String = "") = println("a is $a, b is $b")

// 过滤集合
fun filterList(list: List<Int>) {
    // 过滤掉所有小于等于0的值
    val positives = list.filter { x -> x > 0 }
    println("list size is ${list.size}, but positives size is ${positives.size}")
    // 可以通过使用隐参来简写
    val positives2 = list.filter { it > 0 }
    println("list size is ${list.size}, but positives size is ${positives2.size}")
}

// String占位符
fun stringInterpolation(name: String) {
    println("Name $name")
}

// 实例检查
fun instanceCheck(x: Any) {
    when (x) {
        is Foo -> println("This is Foo")
        is Bar -> println("This is Bar")
        else -> println("Unknown")
    }
}

data class Foo(val name: String)
data class Bar(val name: String)

// 遍历map/list
fun traversingMap(map: Map<Any, Any>) {
    for ((k, v) in map) {
        println("$k -> $v")
    }
}

fun traversingList(list: List<Any>) {
    for (l in list) {
        println(l)
    }
}

// 使用范围
fun useRanges(y: Int) {
    for (i in 1..100) { // [1,100]
        print("$i ")
    }
    println()

    for (i in 1 until 100) { // [1,100)
        print("$i ")
    }
    println()

    for (x in 2..10 step 2) {
        print("$x ")
    }
    println()

    for (x in 10 downTo 1) {
        print("$x ")
    }
    println()

    if (y in 1..10) {
        println("$y between 1 - 10")
    }
}

// 只读list
fun readOnlyList() {
    val list = listOf("a", "b", "c")
//    list = list.plus("d")  // 这里会报错 因为val类型为只读

    var list2 = listOf("a", "b", "c")
    list2 = list2.plus("d") // 这里不会报错 因为var类型可以改变
    println(list2[3])
}

// 只读map
fun readOnlyMap() {
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
//    map = map.plus("d" to 4)  // 这里会报错 因为val类型为只读

    var map2 = mapOf("a" to 1, "b" to 2, "c" to 3)
    map2 = map2.plus("d" to 4) // 这里不会报错 因为var类型可以改变
    println(map2["d"])
}

// 访问map
fun accessingMap() {
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    println(map["a"])
}

// lazy属性 0v0 不是很懂 以后慢慢了解
val p: String by lazy { "This is p" }

// 扩展方法
fun String.spaceToCamelCase(): String { // 字面意思是把空格去掉并使用驼峰式命名 不知道有没有更好的实现方法
    val args = split(" ")
    var out = ""
    for (arg in args) out += (arg[0].toUpperCase() + arg.substring(1))

    return out
}

fun extensionFunctions() {
    println("Convert this to camelcase".spaceToCamelCase())
}

// 创建一个单例
object Resource {
    val name = "name"
}

// 非空速记
fun notNullShorthand(s: String) {
    // 当参数s乱填的时候这里并没有报错
    // 按照debug的结果看到files为null
    // Java在这里要catch IOException和NullPointerException (╯‵□′)╯︵┻━┻
    val files = File(s).listFiles()
    // 当files不为null时输出files的size, 为null时输出null
    println(files?.size)
}

// 非空和else速记
fun notNullAndElseShorthand(s: String) {
    val files = File(s).listFiles()
    // 当files不为null时输出files的size, 为null时输出empty
    println(files?.size ?: "empty")
}

// 执行一个可能为null的语句
fun statementIfNull() {
    val data = mapOf("name" to "My Name", "address" to "My Address")
    val email = data["email"] ?: throw IllegalStateException("Email is missing!")
}

// 不为null时才执行
fun executeNotNull() {
    val data = null
    data?.let { println("$it not null") }

    val data2 = "Name"
    data2?.let { println("$it not null") }
}

// return时使用when语句
fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

// try/catch表达式
fun test() {
    val result = try {
        count()
    } catch (e: ArithmeticException) {
        throw IllegalArgumentException(e)
    }
}

fun count() {

}

// if表达式
fun foo(param: Int) {
    val result = if (param == 1) {
        "One"
    } else if (param == 2) {
        "Two"
    } else {
        "Three"
    }
}

// Builder-style usage of methods that return Unit
fun arrayOfMinusOnes(size: Int): IntArray {
    // 初始化一个指定长度的数组并用-1填充它
    return IntArray(size).apply { fill(-1) }
}

// 单行表达式方法
fun thAnswer() = 42

fun thAnswer2(): Int {
    return 42
}

fun transform2(color: String): Int = when (color) {
    "Red" -> 0
    "Green" -> 1
    "Blue" -> 2
    else -> throw IllegalArgumentException("Invalid color param value")
}

//在一个实例对象上调用多个方法('with')
class Turtle {
    fun penDown() {
        println("pen down")
    }

    fun penUp() {
        println("pen up")
    }

    fun turn(degrees: Double) {
        println("turn $degrees")
    }

    fun forward(pixels: Double) {
        println("forward $pixels")
    }
}

fun testTurtle() {
    val myTurtle = Turtle()
    with(myTurtle) {
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}

// 尝试使用Java 7
fun tryJdk7() {
    // 这里填你自己的txt文件的路径哦
    val stream = Files.newInputStream(Paths.get("/some/file.txt"))
    stream.buffered().reader().use { println(it.readText()) }
}

// 需要一般参数的一般方法的简便写法 一脸懵逼 看不懂
// public final class Gson {
//    public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxExpection
// }

// inline fun <reified T : Any> Gson.fromJson(json): T = this.fromJson(json, T::class.java)

// 消费可能为null的Boolean
fun nullableBoolean() {
    var b: Boolean? = true //文档里面问号是和等号一起的 这里格式化后怎么跑Boolean后面去了(╯‵□′)╯︵┻━┻
    if (b == true) {
        println("b is true")
    } else {
        println("b is null or false")
    }
}