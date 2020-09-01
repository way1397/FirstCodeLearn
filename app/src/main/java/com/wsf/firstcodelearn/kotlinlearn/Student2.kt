package com.wsf.firstcodelearn.kotlinlearn

import com.wsf.firstcodelearn.kotlinlearn.Person

// 当类中只有次构造函数,那么这个子类就没有主构造函数
// 父类后面就不需要带括号，改成由次构造函数来调用父类的主构造函数
class Student2 : Person {
    constructor(name: String, age: Int) : super(name, age)

    override fun eat() {
        super.eat()
    }

}