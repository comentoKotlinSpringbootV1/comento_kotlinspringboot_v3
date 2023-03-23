package com.comento.dbless.calculator.service

import org.springframework.stereotype.Service

import kotlin.math.pow
import kotlin.random.Random

@Service
class CalculatorServiceImpl : CalculatorService {

    override fun generateRandomNumberInRange(range: String): Double {
        val (start, end) = parseRange(range)

        validateRange(start, end)

        val scale = (10.0).pow(maxPlaces(start, end))
        val randomValue = getRandomNumberAfterScale(start, end, scale)

        return randomValue / scale
    }

    private fun validateRange(start: Double, end: Double) {
        require(start < end) { "Start 숫자값이 end 숫자값와 같거나 클 수 없습니다." }
        require(start >= 0) { "Start 숫자값이 0보다 작을 수 없습니다." }
    }

    private fun parseRange(range: String): Pair<Double, Double> {
        val (start, end) = range.split("~").map { it.trim().toDouble() }

        return Pair(start, end)
    }

    private fun maxPlaces(number1: Double, number2: Double): Int {
        return maxOf(countDecimalPlaces(number1), countDecimalPlaces(number2))
    }

    private fun countDecimalPlaces(num: Double): Int {
        val str = num.toString()
        val decimalIndex = str.indexOf('.')
        return if (decimalIndex == -1) {
            0
        } else {
            str.substring(decimalIndex + 1)
                .trimEnd('0')
                .length
        }
    }

    private fun getRandomNumberAfterScale(start: Double, end: Double, scale: Double): Double {
        val scaledStart = (start * scale)
        val scaledEnd = (end * scale)

        return Math.floor(Random.nextDouble(scaledStart, scaledEnd + 1))
    }
}
