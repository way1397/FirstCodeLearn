package com.wsf.firstcodelearn.myjetpack

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyUser(var firstName: String, var lastName: String, var age: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0;
}