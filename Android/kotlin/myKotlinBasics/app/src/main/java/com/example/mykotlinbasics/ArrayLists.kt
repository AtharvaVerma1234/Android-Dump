package com.example.mykotlinbasics

fun main()
{
    val arrayList= ArrayList<String>()
    arrayList.add("One")
    arrayList.add("Two")
    println(arrayList)
    val x= listOf<Any>(12,12,3,"ok",41,3,13,1)
    val arrList= x
    //the below code works for only strings
    //val arrList= ArrayList<Any>()
    //arrayList.addAll(x)
    println(arrList)

    // the below code is implementation of a while loop for iterating through a ArrayList which is just trash method
//    val itr = arrList.iterator()
//    while(itr.hasNext())
//    {
//        println(itr.next())
//    }
//    for(i in arrList)
//    {
//        println(i)
//    }
    println(arrList.lastIndex+1) // for arrList.size
    println(arrList[0])
    val list=ArrayList<Double>()
    list.add(1.0)
    list.add(2.0)
    list.add(3.0)
    list.add(4.0)
    list.add(5.0)
    list.add(6.0)
    list.add(7.0)
    var sum=0.0
    for(i in list)
    {
        sum+=i
    }

    println("Average is ${sum/list.size}")
}