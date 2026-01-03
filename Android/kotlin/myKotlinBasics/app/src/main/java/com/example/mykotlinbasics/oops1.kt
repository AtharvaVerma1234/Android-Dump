package com.example.mykotlinbasics

fun main(args:Array<String>)
{
    var x:person =person("Atharva", "Verma",25)
    println("The person when the object is printed is $x")
    println(x.ageOfPerson)
    //println(x.fn) -- This does not work here but it works for Data Class
    println(x.lastName)
   // x.hobby="Dance"
    x.Walk()
    x.sleep()
    println(x.hobby)
    // we can set default values of arguments of our choice
    var elon= person(ln="Chaiwala")
    //we have to pass all the arguments of primary constructor in case of secondary constructor
    var osama=person("Osama", "Bin Laden",44,hobby="Bombing")
    println(osama.hobby)
    println(elon.ageOfPerson)
    println(elon.hobby)
    elon.hobby="Firing"
    println(elon.hobby)

}
class person(fn:String="Elon", ln:String="Musk", age:Int=15)
{
    //THE STATEMENT BELOW IS WRONG because the scope of fn , ln, age is in the constructor i.e. init block only
    //Useless member variables. we can directly use fn,ln,age


    //The variables below should be initialised in init block so that they can be accessed by the member functions also
    var lastName:String?=null
    var firstName:String?=null
    //age= age is a bad practice because now in this block we can only access the var age and there is no fukin way of accessing the parameter a
    var ageOfPerson:Int?=null
    var hobby:String?=null
   // hobby?.let{println(it)}
    //cpp constructor doesn't work here !!!
//    fun person(ln:String, fn:String , age:Int=15)
//    {
//        lastName=ln
//        firstName=fn
//        Age=age
//    }
    //SECONDARY CONSTRUCTOR
    constructor(fn:String, ln:String, age:Int , hobby:String):this(fn, ln,age)
   {
        this.hobby=hobby
       this.ageOfPerson=age
    }
    init{
        this.firstName=fn
        this.lastName=ln
        println("$firstName $lastName created as an object")
    }
    fun Walk()
    {
        println("$firstName is walking")
    }
    fun sleep()
    {
        println("Go to sleep $firstName ")
    }
}