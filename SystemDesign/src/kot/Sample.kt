package kot

var name = "david"
fun main(args: Array<String>) {
    var num = 12_23_43L
    println(num)
    num++
    println(name)

    val a = 43
    val b = 43
    val match = (a == b)
}

fun add(vararg nums: Int): Int {
    var sum = 0
    for(i in nums) {
        sum += i
    }
    return sum
}