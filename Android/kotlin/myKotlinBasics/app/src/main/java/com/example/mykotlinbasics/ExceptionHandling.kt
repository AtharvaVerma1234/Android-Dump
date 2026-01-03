package com.example.mykotlinbasics

//EXCEPTION HANDLING DOCUMENTATION -https://kotlinlang.org/docs/exceptions.html#exception-classes
fun main()
{
     val str=getNumber("10")
    val str2=getNumber("10.6")
    println(str)
    println(str2)
}
//Four keywords used in exception handling
// try catch finally throw
fun getNumber(str:String):Int
{
    return try{
        Integer.parseInt(str)
    }catch(e:Exception){
        0
    }finally{
        println("This will run no matter what")
    }
}