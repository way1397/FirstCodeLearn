package com.wsf.firstcodelearn.kotlinlearn

import kotlin.math.max

fun main() {
    // 给函数的第二个参数赋值，这样就可以不用按照java那样按照顺序传参
//    printParams(str = "hhh")
//    var studen= Student(sno = "第一个参数", age = 2)
    val list = listOf("apple", "banana", "orange", "grape")
    val result2=java.lang.StringBuilder().run {
        append("start eat\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("finish")
        toString()
    }
    println(result2)
}

// 给函数的第二个参数设置了默认值，这样调用的时候就可以不用给第二个参数传值
fun printParams(num: Int = 5, str: String = "hello") {
    println("num is $num,$str")
}

fun study(student: Student?) {
    student?.readBooks()
    student?.doHomeWorks()

    student?.let { stu ->
        stu.readBooks()
        stu.doHomeWorks()
    }
    student?.let {
        it.readBooks()
        it.doHomeWorks()
    }
}

fun a() {
    val a = null
}

fun methodFor() {
    // for有点类似于java的for-each，在kotlin中叫做for-in
// kotlin可以声明一个闭区间 0-10
    val range = 0..10
    // until可以创建左闭合右开的区间[0,10) 0-9
    val range2 = 0 until 10
    // 降序区间 [10,1]
    val range3 = 10 downTo 1
    val range4 = 10 until 1
    // step 2类似 i=i+2
    for (i in range step 2) {
        println(i)
    }
}


// when相当于java中的switch
// 匹配值->{执行逻辑}，逻辑只有一行代码的时候{}可以省略
fun getScore(name: String) = when (name) {
    "Tom" -> 10
    "Jim" -> 77
    "Lily" -> 60
    else -> 0
}

// 还有一种写法是when不传参,比较灵活,但是可能用的少
// 这种写法就可以在结构体中有丰富的扩展性
fun getScore2(name: String) = when {
    name.startsWith("Tom") -> 10
    name == "Jim" -> 77
    name == "Lily" -> 60
    else -> 0
}

// 匹配类型，is相当于instanceof
fun checkNumber(num: Number) {
    when (num) {
        is Int -> println("number is int")
        is Double -> println("number is double")
        else -> println("number not support")
    }
}

fun methodName(param1: Int, param2: Int): Int {
    return if (param1 > param2) {
        param1
    } else {
        param2
    }
}

fun methodName1(param1: Int, param2: Int): Int = max(param1, param2)

fun methodName2(param1: Int, param2: Int) = if (param1 > param2) {
    param1
} else {
    param2
}
