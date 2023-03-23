package com.comento.dbless.calculator.presentation

import com.comento.dbless.calculator.service.CalculatorService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/calculator")
class CalculatorController(
    private val calculatorService: CalculatorService
) {
    @GetMapping("/generate/{range}")
    fun generateRandomNumber(@PathVariable range: String): Double {
        try {
            return calculatorService.generateRandomNumberInRange(range)
        } catch (e: IllegalArgumentException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message)
        }
    }
}
