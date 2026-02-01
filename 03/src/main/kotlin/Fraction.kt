package org.example
import kotlin.math.abs

class Fraction ( numerator: Int, denominator: Int, private val sign: Int = 1): Comparable<Fraction> {

    val numerator: Int
    val denominator: Int

    init {
        val gcd = gcd(abs(numerator), abs(denominator))
        this.numerator = abs(numerator) / gcd
        this.denominator = abs(denominator) / gcd
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }


    fun add(other: Fraction): Fraction {
        return Fraction(sign * numerator * other.denominator + other.sign * other.numerator * denominator,
            denominator * other.denominator)
    }

    fun mult(other: Fraction): Fraction {
        return Fraction( numerator * other.numerator, denominator * other.denominator, sign * other.sign)
    }

    fun div(other: Fraction): Fraction {
        return Fraction(numerator * other.denominator, denominator *  other.numerator, sign * other.sign)
    }


    fun subtr(other: Fraction): Fraction {
        return Fraction(sign * numerator * other.denominator - other.sign * other.numerator * denominator, denominator * other.denominator)
    }

    fun negate(): Fraction {
        return Fraction(numerator, denominator, -sign)
    }

    operator fun plus(other: Fraction) = add(other)

    operator fun minus(other: Fraction) = subtr(other)

    operator fun times(other: Fraction) = mult(other)

    operator fun unaryMinus() = negate()


    override fun compareTo(other: Fraction): Int {
        return (sign * numerator * other.denominator).compareTo(other.sign * other.numerator * denominator)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Fraction) return false
        return sign * numerator == other.sign * other.numerator && denominator == other.denominator
    }

    override fun toString(): String {
        return "${sign * numerator}/$denominator"
    }
    }


fun main() {
    val a = Fraction(1,2,-1)
    println(a)
    println(a.add(Fraction(1,3)))
    println(a.mult(Fraction(5,2, -1)))
    println(a.div(Fraction(2,1)))
    println(-Fraction(1,6) + Fraction(1,2))
    println(Fraction(2,3) * Fraction(3,2))
    println(Fraction(1,2) > Fraction(2,3))
}