package com.example.mykotlinbasics

fun main()
{
// var x:Int = add(5,4)
// println(x)
    add(5,4)
    println()
    println("${average(4,9)} is the average of 4 and 9")

    //we can make a variable nullable by expressing its datatype explicitly and then adding a '?' at the end
    var str:String? = null
    //str=null
    //var len = str?.length
    str?.let{ println(it) }
    //val name =str Why the hell does this work?? // this gives no compile time error but
    //it gives "Null pointer Exception" runtime error
    //?: ELVIS OPERATOR
    val name= str?:"hola"
//    println(name)

    //!! not null assertion

    println("$name is name")

    println(name.uppercase())
    println(str?.let { it.uppercase() })
    //The above statement will create a null pointer exception


    /*
    val listWithNulls: List<String?> = listOf("Kotlin", null, "Kutta")
    for (item in listWithNulls) {
        item?.let { println(it.length) } // prints Kotlin and ignores null
    }

     */
    /*
    //println(str)
    var len=str?.length
/*
var len:Any=0;
    //the above code is same as below
    if(str!=null)
    {
        len=str.length
    }else{
    null
    }

 */

    println(len)
   if(str!=null)
   {
       println(str.length)
   }
    else
   {
       println(null)
   }

     */
    //All of the above ways can be done using let statement . Can they??
    //Why does this not work when the variable is declared as null in the beginning???????
    // Works is variable is null at declaration itself.. Doesn't if the var is initialized and then changed later to null

}
fun add(a:Int, b:Int) {
     print(a+b)
}
fun average(a:Int , b:Int):Float{
    return (a.toFloat() + b.toFloat())/2.0f
}