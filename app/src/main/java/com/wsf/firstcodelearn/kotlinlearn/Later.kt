package com.wsf.firstcodelearn.kotlinlearn

import kotlin.reflect.KProperty

/**
 * kotlin委托和泛型
 */
class Later<T>(val block: () -> T) {
    var value: Any? = null
    operator fun getValue(any: Any?, prop: KProperty<*>): T {
        if (value == null) {
            value = block
        }
        return value as T
    }
}

fun <T> later(block: () -> T) = Later(block)