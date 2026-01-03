package com.example.mykotlinbasics

fun main()
{
    var redmi=MobilePhone()
   // println(redmi.battery)
    redmi.chargeBattery(30)
}
class MobilePhone(osName: String="Android", brand: String="Xiaomi", model: String="Note 8 Pro"){
   private var battery:Int
    init {
        this.battery=35
        println("The phone $model from $brand uses $osName as its Operating System")
    }
    fun chargeBattery(charge:Int)
    {
       var charge=if(charge+battery<=100 && charge>=0) charge else { if(charge<0) throw IllegalArgumentException("We have to charge the battery not discharge it") else 100-battery}
        println("Initial Charge $battery")
        println("$charge was further charged")
        println("Current battery status ${charge+battery}")
    }
}