package com.example.mykotlinbasics

fun main()
{
    fun addition(a:Int,b:Int)
    {
        println(a+b)
    }
    addition(5,10)
    println(sum(5,10))

    val sum2={a:Int,b:Int-> println(a+b)}
    sum2(10,5)

}

//Lambda Expression for the above function
val sum:(Int,Int)->Int={a,b -> (a+b)}
//val sum ={a:Int,b:Int->(a+b)}
