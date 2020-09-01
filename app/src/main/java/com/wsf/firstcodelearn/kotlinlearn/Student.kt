package com.wsf.firstcodelearn.kotlinlearn

class Student(val sno: String="", val gradle: Int=0, name: String="", age: Int=0) : Person(name, age), Study {

    constructor(name: String, age: Int) : this("", 0, name, age)

    override fun readBooks() {
        println(name + "is read")
    }

     override fun doHomeWorks() {
        //modifier private is incompatible with override
        println(name + "is do homework")
    }
}