package com.example.mykotlinbasics

import kotlin.math.floor

fun main()
{
    val stringList:List<String> = listOf("BM", "SKM", "TS", "SK")
    val mixedTypeList:List<Any> = listOf("BM","Buddha", 60, 'C',7.6,6.7f)

    for(value in mixedTypeList)
    {
        when(value)
        {
            is Int -> println("$value is integer")
            is Char ->println("$value is character")
            is String-> println("$value is String of length ${value.length}")
            is Double-> println("$value is Double of floor value ${floor(value)}")
            is Float-> println("$value is float")
            else -> println("Type of $value not recognized")
        }
    }


    //Safe Casting
    val obj:Any=23
    if(obj !is String)
    {
        println("Not a string")
    }else{
        println("A string of length ${obj.length} detected")
    }
   // val str1:String=obj as String
    //Explicit(unsafe) typecasting
    val obj2:Any = 1337
    //Another unsafe cast though it works fine if it is in fact an integer but it will not work when obj2 is not an integer
    val integer:Int?=obj2 as Int?
   // var str2:String=obj2 as String // This throws Error

    //Explicit(safe) Typecasting
    var str3:String?= obj2 as? String // This works because of as? keyword
//    println("Str1: $str1")
   // println("Str2: $str2")
    println("Str3: $str3")
    val x:String="5482796498"
    val str:Long=x.toLong()
    println(str)
    println(integer)



}