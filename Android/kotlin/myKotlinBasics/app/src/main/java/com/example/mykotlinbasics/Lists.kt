package com.example.mykotlinbasics

fun main()
{
    //LISTS
    val months = listOf<Any>("January","February","March","April")
    val months2=months.toMutableList()
    months2.add(4,"May")

    val additionalMonths=arrayOf("June", "July","August")
    months2.addAll(additionalMonths)
    println(months2)
//    months2.addAll(8,months)
//    println(months2)
    months2.addAll(8,listOf("September", "October", "November","December"))
    println(months2)

    var list2= mutableListOf<Any>("Monday","Tuesday",'W',"Thursday",5,6,7.0,'W',7.00)
    println(list2)
    list2.removeAll(listOf('W',7.0))
    println(list2)
    //SETS
    val fruit=setOf("Apple","Mango","Banana", "Mango","Grape","Apple")
    println(fruit)
    var newFruits= fruit.toMutableList()
    newFruits.addAll(listOf("Watermelon","Pear","Peach"))
    println(newFruits)
    println(newFruits[3])
    println(newFruits.elementAt(5))
    newFruits.add("Apple")
    println(newFruits)
    for(index in fruit)
    {
        println(index)
    }
    for(index in newFruits.indices)
    {
        println("${newFruits[index]} is at $index")
    }


    //MAPS
    var days= mapOf<String, Any>("Somwar" to "Monday", "Mangalwar" to "Tuesday", "Buddhawar" to "Wednesday", "Brahaspatiwar" to "Thursday")
    println("------------MAPS------------------")
    //println(days)
//    for( key in days.keys)
//    {
//        println("${days[key]} is mapped with $key")
//    }
    var days2=days.toMutableMap()
//    days2.put("Shukrawar","Friday")
    days2["Shukrawar"] = "Friday"
    println(days2)
    // <Any,__> maps cant be sorted using to sorted maps // for non integer types we have to use the compareBy comparable
   // Comparables -https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/
    println(days2.toSortedMap(compareBy<String> { it }))
    for( key in days2.keys)
    {
       // println("${days2[key]} is mapped with $key")
    }
    months2.add(12,days2)
   println(months2)

    // you can add a map to a list and vice versa
    // but if you add a list to a map and then add the same map to the same list
    // it gives a runtime error of "Stack Overflow"
}