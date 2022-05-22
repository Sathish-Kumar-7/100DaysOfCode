//class Sample{
//    var a=10
//    var b = 20
//    var num:Int = 0
//        get() = a+b
//        private set(value){
//            field = a+b
//         }
//    fun displayNum(num:Int) {
//        this.num = num
//        println(this.num)
//    }
//}

//class Sample{
//    init {
//        println("Hello Initializing 1")
//    }
//    init {
//        println("Hello Initializing 2")
//    }
//}

//class Sample(value1: Int){
//    init {
//     println(value1)
//    }
//    constructor(value2: Int,value3: Int):this(value2+value3)
//
//    constructor(value4:Int,value5:Int,value6:Int):this(value4+value5+value6)
//}

//class Sample{
//    private val num1 = 100
//    protected val num2 = 200
//    public val num3 = 300
//    internal val num4 = 400
//}

//open class Parent{
//    init {
//        println("Parent Class")
//    }
//    open var num = 100
//}
//class Child:Parent() {
//    override var num = 100
//    init {
//        println("Child Class")
//    }
//}

//abstract class AbstractClass(num: Int) {
//    abstract val number:Int
//    abstract fun display():Boolean
//    fun print(){
//        println("I Am A Function")
//    }
//}
//class InheritingClass(num: Int):AbstractClass(num) {
//    override val number: Int = 100
//    override fun display(): Boolean {
//        print()
//        println(number)
//        return true
//    }
//}

//interface Interface1{
//    val num:Int
//    fun display1():Boolean{
//        return true
//    }
//}
//interface Interface2{
//    fun display2():Boolean{
//        return false
//    }
//}
//class InheritingClass():Interface1,Interface2{
//    override val num: Int= 100
//    init {
//        println(display1())
//    }
//}

//open class Apple(num:Int){
//    constructor() : this(0)
//
//    init {
//        println("Hello Apple!")
//    }
//}
//object Sample:Apple(){
//    init {
//        println("Singleton Object")
//    }
//    private val num:Int = 100
//    fun dispaly(){
//        println(num)
//    }
//}

//data class Sample(val num1:Int,val num2:Int)

//enum class Fruits(val value:Int){
//    APPLE(1),
//    BANANA(2),
//    ORANGE(3)
//}

//sealed class Seal{
//    init {
//        println("Class Sealed")
//    }
//}
//class Apple:Seal()
//
//class Banana:Seal()
//
//class Orange:Seal()
//fun main(){
//    val seal:Seal = Apple()
//    println(when(seal){
//        is Apple -> "Apple"
//        is Banana -> "Banana"
//        else -> "Other"
//    })
//}

//class Happy(){
//    init {
//        val num = "Happy"
//    }
//}
//fun Happy.display(){
//    println("Happy Lolala")
//}
//fun main(){
//    Happy().display()
//}

//class GenericTypes<T>(val value:T){
//    fun display(value: T):T{
//        println(value)
//        return value
//    }
//}
//class InGenericType<in T>{
//    fun display(value:T):String{
//        return value.toString()
//    }
//}
//
//fun main(){
//    GenericTypes<String>("Happy").display("Happy")
//}