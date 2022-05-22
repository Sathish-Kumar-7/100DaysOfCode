import kotlin.math.pow
import kotlin.math.*

// This Is Single Line Comment
/*
This
    Is
        Multi-Line
            Comment
 */
fun variableDec(){
    val value1 = 10 // Unchangeable
    var value2 = 20 // Changeable
    println(value1)
    println(value2)
}

fun arithmeticOperations(){
    val a = 12
    println(10+12)
    println(20-15)
    println(10*2)
    println(120/32)
    println(12%3)
    println(4 shl 2)
    println(4 shr 2)
    println()
}

fun mathFunction(){
    println(sin(1.0))
    println(cos(1.0))
    println(sqrt(4.0))
    println(max(32,12))
    println(min(12,64))
    println(log(12.0,10.0))
}
fun types(){
    val integer:Int = 100
    val decimal:Double = 12.5
    val float:Float = 12.5f
    val byte:Byte = 15
    val short:Short = 1234
    val long:Long = 12_234_2345_234L
    val str:String = "String $long"
    val multistr:String = """
        Sathish
        Kumar
        Wow
    """.trimIndent()
    println(multistr)
    val char:Char = 'A'
    val any:Any = "Shiva"
    val unit:Unit
    val intNullable:Int? = null
    val listof:List<String> = listOf<String>("Sarah","Sada","Saaj")
    val mutablelistof:MutableList<String> = mutableListOf("Sathish","Kumar")
    mutablelistof.add("HS")
    val arrayOf:Array<String> = arrayOf<String>("Sarah","Sada")
    val intArray:IntArray = intArrayOf(1,2,3)
    val set:Set<Int> = setOf(1,2,4,4)
    var pair:Pair<String,Long> = Pair("Sathish",123L)
    pair = "Sarah" to 12
    val (a,b) = pair
    val (f,_) = pair
    val triple:Triple<String,Int,Float> = Triple("Sarah",35,12.4f)
    val (c,d,e) = triple
    val sequence:Sequence<Int> = sequenceOf(3,6,2)
}
fun comparison(){
    println(12>4)
    println(12==12)
    println(12===12)
    println(true && false)
    println(true || false)
}
fun conditionStatements(){
    if(true)
        println("Sathish")
    else if (true)
        println("Sada")
    else
        println("Sarah")
    when(14){
        in 1..3 -> println("1 to 3")
        in 4 .. 7 -> println("4 to 7")
        in 8..12 -> println("8 to 12")
        else -> println("above 12")
    }
}
fun loops(){
    var i:Int=5
    while (i>0){
        println(i)
        i-=1
    }
    i=5
    do{
        println(i)
        i-=1
    }while (i>0)
    for(i in 1..5 step 2){
        println(i)
    }
    1 downTo -5
    1 until 6
    for (i in arrayOf("Sathish","Kumar")){
        println(i)
    }
    repeat(5){
        println(it)
    }
}
fun display(value:Int){
    println(value)
}
val d = ::display
fun nullable(){
    val res:Int? = null
    println(res?.plus(12))
    println(res!!)
    println(res?:0)
    res?.let{
        println("Lol")
    }
}
// Arrays
// List
// Mutable List
// Map - mapOf mutableMapOf hashMapOf
// Sets - setOf mutableSetOf

// lambda functions
var multiply:(Int,Int) -> Int = {
    a:Int,b:Int -> a*b
}
fun oper(a:Int,b:Int,operation:(Int,Int)->Int):Int{
    println("Hello")
    return operation(a,b)
}
fun main(){
//    println(oper(1,2, operation = { a: Int, b: Int -> a + b }))
//    println(oper(3,5,Int::plus))

}