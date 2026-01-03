package com.example.mykotlinbasics

fun main()
{
    var arr:IntArray = intArrayOf(32, 45, 453,23,234,23435,2452,523,234,24,23)
    val arr3= intArrayOf(3245,35,4135,34,65,352,56,3)
    val arr4 = arrayOf(311,33,13,13,13,12)
    var arr2:Array<Int> = arrayOf(43,234,243,234,2342,234,24)
    println("${arr.contentToString()}")
    println("${arr4.component1()}") // this is just like data class
    for(x in arr2)
    {
        print("$x,")
    }
    println()
   val fruits= arrayOf(Fruit("Apple",3.5), Fruit("Orange", 4.2))

    for(index in fruits.indices) //fruits.indices give the index of the elements one by one
    {
        println("${fruits[index].name} is at index $index")
    }
    //Same functionality as above
    for((i, x) in fruits.withIndex())
    {
        println("${x.name} is at index $i")
    }
    println(arr3.size)
     val arr5 =arr3.toMutableList()//why does this work with arrays??
    arr5.add(8,2965)
    /*

    //Similar code as above
     var i=0
    for(x in fruits)
    {
        println("${x.name} is at index $i")
        i++
    }
     */
}
data class Fruit(val name:String, val price:Double)