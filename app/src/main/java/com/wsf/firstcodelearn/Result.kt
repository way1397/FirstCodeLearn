package com.wsf.firstcodelearn

// 没用密封类，需要多加一个else的判断，相当于default
interface ResultA
class SuccessA(val msg: String) : ResultA
class FailureA(val error: Exception) : ResultA

fun getResultA(result: ResultA) = when (result) {
    is SuccessA -> result.msg
    is FailureA -> result.error.message
    else -> "aaa"
}


// 密封类，class前面加上sealed，密封类及其所有子类只能定义在同一个kt文件中
sealed class Result

class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()

fun getResult(result: Result) = when (result) {
    is Success -> result.msg
    is Failure -> result.error.message
}
