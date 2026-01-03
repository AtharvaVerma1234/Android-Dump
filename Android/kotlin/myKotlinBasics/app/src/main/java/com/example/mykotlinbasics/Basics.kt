package com.example.mykotlinbasics

fun main()
{
    /*
    val name: String = "kekdaa"
    val age = 100
    //the statement below will give an error as val is immutable i.e. val can't be overwritten
    //age=23
    //todo: Add a functionality
    print("Hello World \n$name")
    print("\n The length of the string is ${name.length} \n")
    val firstChar= name[0]
    val lastChar= name[name.length-1]
//converted concatenation to template ... This is called interpolation
    print("$firstChar $lastChar")

    //HOMEWORK
    var a:String ="Android Masterclass"
    var b:Float= 13.37f
    //value of pie should not be changed later so it is of val type
    val pi:Double=3.141592
    var d:Byte=127
    var e:Short = 32767
    var f:Int=2020
    var g:Long=18881234567
    var h:Boolean=true;
    var i:Char='a';
println("\n the result of division is "+ (5/3).toDouble())//typecasting in Kotlin
   // var j =5.0/3
    println("value of division using double values is "+(5.0/3))
    //If we want to create a variable without assigning any value to it WE MUST declare its type
//    var ab:Int=2
    if(ab>d)
        println("good")
    else if(ab==d.toInt())
        println("decent")
        //println("enough")
    else
        println("Bad")
//Spaces and orientation does not matter in kotlin like cpp and java where we use curly braces unlike python where we use
   // val age=21
//    if(age>21) {
//        println("You may drink legally in US")
//    }
//   else if(age>=18) {
//        println("You may vote")
//    }
//    else{
//        println("You are a minor")
//    }
    when(age)
    {
        in 1..15 -> println("You are a minor")
        16,17 -> println("You may drive in US")
        in 18..20-> println("You may vote")
        !in 20 downTo 0-> println("You can drink legally in US")
        //else -> println("You don't exist")
    }
    //WHEN Expressions
    var month=11
    when(month)
    {
       in 1..2 -> println("Its cold")
        3-> println("The perfect season")
        in 4..5 , 6 -> println("Its sunny and warm")
        in 7..9 -> println("Its always raining ")
        10-> println("Winter is coming")
        11,12->println("Winter has come") // this does not throw an error without the print statement
        //in 1..2, in 11..12 ->println("Hodor")
        else -> println("There are only 12 months in a season")
    }

    var x:Any = 14.0012
    when(x)
    {
        is Int -> println("$x is an Integer")
        is Double-> println("$x is a double")
        is String-> println("$x is a String")
        else -> println("x is a user defined data type")
    }
   // val x : Any = 13.37
//assign when to a variable
//    val result =  when(x) {
////let condition for each block be only a string
//        is Int -> "is an Int"
//        !is Double -> "is not Double"
//        is String -> "is a String"
//        else -> "is none of the above"
//    }
//then print x with the result
    //println("$x $result")
    // We printed the code directly without creating a variable
    x="abcd"
    print("$x ${when(x) {
//let condition for each block be only a string
        is Int -> "is an Int"
        !is Double -> "is not Double"
        is String -> "is a String"
        else -> "is none of the above"
    }}")


     */
    var x=1
    while(x<=10)
    {
        println("x = $x")
        x++
    }
    for(n in 1..10)
    {
        print("$n ")
    }
    println()

    for(n in 1 until 10)//10 not included
    {
        print("$n ")
    }
    println()
    for(n in 10 downTo 1)// both are included
    {
        print("$n ")
    }
    println()
    for(n in 0..12 step 3)
    {
        print("$n ")
    }
println()
    for(n in 1.until(10).step(2))
        print("$n ")
    /*
    var temp=11
    var tempStatus="too cold"
    while(tempStatus=="too cold")
    {
        println("Current Temp is $temp. Please increase it")
        temp++
        if(temp>=23) {
            tempStatus = "Its comfy now"
            println(tempStatus)
        }
    }

     */

}