package com.wsf.firstcodelearn.kotlinlearn

import com.alibaba.fastjson.JSON
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.max
import kotlin.time.ExperimentalTime
import kotlin.time.milliseconds
import kotlin.time.seconds

@ExperimentalTime
fun main() {
    //1620788500457
    val timeStr = "10:10:10"
    val sf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = Date(1620788500457)
    val formateString = sf.format(date)
//    val time = (System.currentTimeMillis() - 1620788500457).milliseconds.inSeconds
    println("" + formateString)

    val Str = "2021-05-12 11:01:40"
    val date2 = sf.parse(Str)
    val sf2 = SimpleDateFormat("HH:mm:ss")
    val strOnlyHours = sf2.format(date2)
    println("" + strOnlyHours)


    val time1 = "00:00:00"
    val time2 = "01:00:00"

    val date1 = sf2.parse(time1)
    val date3 = sf2.parse(time2)
    val diff=date3.time - date1.time
    print("结束时间：${date3.time}，开始时间${date1.time},时间相差${diff}")
}


fun letterToNumber(letter: String): Int {
    val length: Int = letter.length
    var num = 0
    var number = 0
    for (i in 0 until length) {
        val ch: Char = letter[length - i - 1]
        num = (ch - 'A' + 1)
        num *= Math.pow(26.0, i.toDouble()).toInt()
        number += num
    }
    return number
}

// 给函数的第二个参数设置了默认值，这样调用的时候就可以不用给第二个参数传值
fun printParams(num: Int = 5, str: String = "hello") {
    println("num is $num,$str")
}

fun cost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println(System.currentTimeMillis() - start)
}

inline fun inLineCost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println(System.currentTimeMillis() - start)
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
