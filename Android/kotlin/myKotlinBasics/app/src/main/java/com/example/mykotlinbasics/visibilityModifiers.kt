package com.example.mykotlinbasics

fun main() {
}
open abstract class Animal(val animal:String, private val livesOn:String)
{

    fun isAlive()
    {
        println("$animal is alive")
    }
    fun move()
    {
        if(livesOn.lowercase()=="land")
            println("${animal}s live on land so it is walking")
        else if(livesOn.lowercase()=="water")
            println("${animal}s live in water so it is swimming")
        else
            println("${animal}s live in air so it is flying")
    }
}
class Dog(animal:String,livesOn:String,val name:String,  val legs:Int ,private val sound:String):Animal(animal, livesOn)
{

    fun makeSound()
    {
        println("$name is a $animal so it is making a $sound sound")
    }
    //VISIBILITY MODIFIERS
// https://kotlinlang.org/docs/visibility-modifiers.html
}


