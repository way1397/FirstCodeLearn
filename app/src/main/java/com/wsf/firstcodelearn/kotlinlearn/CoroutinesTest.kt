package com.wsf.firstcodelearn.kotlinlearn

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        coroutineScope {
            launch {
                println(".")
                delay(1000)
            }
        }
    }

    suspend fun printDot() = coroutineScope {
        launch {
            println(".")
            delay(1000)
        }
    }

}