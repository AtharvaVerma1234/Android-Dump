package com.example.mykotlinbasics

fun main()
{
    val user1= user("Dabba", 40)
    //how can we change a val type object?
    user1.name="Kachra"
    var user2 =user("Kachra", 40)
    println(user1.equals(user2))
    //Data classes have toString method so we can directly print user
    println(user1)
    val user3 =user2
    val user4 = user2.copy(name="Babu Bhapkara")//We can pass arguments in copy that we want to change
    println(user3==user4)
    println(user4)
    //we can also access the attributes of the data class by using component keyword
    println(user1.component1()) // prints the name of user 1 as name is the first parameter of the data class constructor

    //we can also assign attributes of a data class object to different variables like
    var(name, age)=user4
    /*
    The above code is same as writing
    var name=user4.name
    var age=user4.age
     */
}
//must have atleast one parameter
data class user(var name:String, var age:Int)