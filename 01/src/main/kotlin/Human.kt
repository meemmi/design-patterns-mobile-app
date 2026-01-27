package org.example

open class Human(val name: String, initialAge: Int) {
    var age: Int = initialAge
        private set

    fun getOlder(){
        age ++
    }
}








