package com.wsf.firstcodelearn.kotlinlearn

class Animal() {
    var name = "dog"
        get() {
            return field + " nb"
        }
        set(value) {
            field = "Cute " + value
        }
    var color = "yellow"
        get() {
            return field + " nb"
        }
        set(value) {
            field = "Cute " + value
        }
}