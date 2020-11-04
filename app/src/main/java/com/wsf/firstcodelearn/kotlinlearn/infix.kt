package com.wsf.firstcodelearn.kotlinlearn

/*用法：if("hello world" beginWith "hello")*/
infix fun String.beginsWith(prefix: String) = startsWith(prefix)

