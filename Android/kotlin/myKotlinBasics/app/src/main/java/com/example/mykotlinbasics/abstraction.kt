package com.example.mykotlinbasics

// An abstract class cannot be instantiated
// (you cannot create objects of an abstract class).
// However, you can inherit subclasses from can them.
// The members (properties and methods) of an abstract class are non-abstract
// unless you explicitly use the abstract keyword to make them abstract.
abstract class Mammal(val name: String, val origin: String,
                      val weight: Double) {   // Concrete (Non Abstract) Properties

    // Abstract Property (Must be overridden by Subclasses)
    abstract var maxSpeed: Double

    // Abstract Methods (Must be implemented by Subclasses)
    abstract fun run()
    abstract fun breath()

    // Concrete (Non Abstract) Method
    fun displayDetails() {
        println("Name: $name, Origin: $origin, Weight: $weight, " +
                "Max Speed: $maxSpeed")
    }
}

class Human(name: String, origin: String, weight: Double,
            override var maxSpeed: Double): Mammal(name, origin, weight) {

    override fun run() {
        // Code to run
        println("Runs on two legs")
    }

    override fun breath() {
        // Code to breath
        println("Breath through mouth or nose")
    }
}

class Elephant(name: String, origin: String, weight: Double,
               override var maxSpeed: Double): Mammal(name, origin, weight) {

    override fun run() {
        // Code to run
        println("Runs on four legs")
    }

    override fun breath() {
        // Code to breath
        println("Breathe through the trunk")
    }
}
class Bat(name: String,origin: String,weight: Double):Mammal(name, origin, weight)
{
    override var maxSpeed: Double=0.0


    override fun run() {
        println("Bats dont run. They fly")
    }

    override fun breath() {
        println("Breathe while flying")
    }
}

fun main() {
    val human = Human("Denis", "Russia",
        70.0, 28.0)
    val elephant = Elephant("Rosy", "India",
        5400.0, 25.0)

    human.run()

    elephant.run()

    human.breath()
    elephant.breath()

    val bat= Bat("Dracula","India", 0.4)
    bat.maxSpeed=60.0

    bat.run()
    bat.breath()
    println("${bat.maxSpeed}")
    bat.displayDetails()
}
//Interfaces don't have constructors and cant hold a value i.e. we cant initialize a variable in an
// interface but we can do both of these things in an abstract class