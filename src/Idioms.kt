/**
 * Created by Administrator on 2017/6/8.
 */

data class Customer(val name: String, val email: String)

fun main(args: Array<String>) {
    Customer("Name", "Email").component1()
}