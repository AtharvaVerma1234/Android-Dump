package com.example.mykotlinbasics

import java.util.logging.XMLFormatter
import kotlin.properties.Delegates

fun main()
{
    val myCar= Car()
   // myCar.name="abnvjdn"
    println(myCar.name)

}
class Car()
{
    lateinit var name:String
    init{
        name="ABCD"
    }
}