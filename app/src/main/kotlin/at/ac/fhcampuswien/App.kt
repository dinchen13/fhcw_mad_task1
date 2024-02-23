/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package at.ac.fhcampuswien

import kotlin.random.Random
import kotlin.math.pow

class App {
    // Game logic for a number guessing game
    fun playNumberGame(digitsToGuess: Int = 4) {
        //TODO: build a menu which calls the functions and works with the return values
        /*if (digitsToGuess in 1..9){ println(generateRandomNonRepeatingNumber(digitsToGuess)) }
        else{ println("digitcount not valid")} */
        try {
            val numberToGuess = generateRandomNonRepeatingNumber(digitsToGuess)
            var guess =0
            do{
                guess = readlnOrNull()?.toIntOrNull() ?: continue   //das ?: heißt elvis operator
                if (guess.toString().toSet().size!=guess.toString().length) {println("all digits must be unique"); continue}
                if (guess == numberToGuess) continue
                try {       //zweimal try catch weil ich nd will dass as speil aufhört nur weil ich einmal zahl mit falscher länge eingegeben hab
                    println( checkUserInputAgainstGeneratedNumber(guess, numberToGuess).toString())
                }catch(e: IllegalArgumentException) {
                    println(e.message)
                }

            }while(guess != numberToGuess)
        }catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    /**
     * Generates a non-repeating number of a specified length between 1-9.
     *
     * Note: The function is designed to generate a number where each digit is unique and does not repeat.
     * It is important to ensure that the length parameter does not exceed the maximum possible length
     * for non-repeating digits (which is 9 excluding 0 for base-10 numbers).
     *
     * @param length The length of the non-repeating number to be generated.
     *               This dictates how many digits the generated number will have.
     * @return An integer of generated non-repeating number.
     *         The generated number will have a number of digits equal to the specified length and will
     *         contain unique, non-repeating digits.
     * @throws IllegalArgumentException if the length is more than 9 or less than 1.
     */
    val generateRandomNonRepeatingNumber: (Int) -> Int = { length ->
        //TODO implement the function
        if (length !in 1 .. 9){
            throw IllegalArgumentException("Length must be between 1 and 9")
        }
        var number = Random.nextInt(
            10.0.pow(length-1).toInt(),      //wenns immer gleich viele stellen haben muss dann so, sonst 0
            10.0.pow(length).toInt()
            ) //between 0 (inclusive) and x (exclusive)
        println("initialer wert: $number")
        val charSet = LinkedHashSet<String>() //check for duplicates, maintains the order in which elements were inserted
        for(i in number.toString()) {
            var char = i.toString()
            while (charSet.contains(char)) {  //already existing
                println("$char ist doppelt")
                char =  Random.nextInt(0, 9).toString()
                println("suggesting $char instead")
            }
            charSet.add(char)
        }
        val stringBuilder = StringBuilder()
        for (char in charSet) {
            stringBuilder.append(char)
        }
        println("number to guess: ${stringBuilder.toString().toInt()}")
        stringBuilder.toString().toInt()
        // return value:  ensure the last expression of the block is the value you want to return
    }

    /**
     * Compares the user's input integer against a generated number for a guessing game.
     * This function evaluates how many digits the user guessed correctly and how many of those
     * are in the correct position. The game generates number with non-repeating digits.
     *
     * Note: The input and the generated number must both be numbers.
     * If the inputs do not meet these criteria, an IllegalArgumentException is thrown.
     *
     * @param input The user's input integer. It should be a number with non-repeating digits.
     * @param generatedNumber The generated number with non-repeating digits to compare against.
     * @return [CompareResult] with two properties:
     *         1. `n`: The number of digits guessed correctly (regardless of their position).
     *         2. `m`: The number of digits guessed correctly and in the correct position.
     *         The result is formatted as "Output: m:n", where "m" and "n" represent the above values, respectively.
     * @throws IllegalArgumentException if the inputs do not have the same number of digits.
     */
    val checkUserInputAgainstGeneratedNumber: (Int, Int) -> CompareResult = { input, generatedNumber ->
        //TODO implement the function
        if (input.toString().length != generatedNumber.toString().length){
            throw IllegalArgumentException("Lengths aren't the same")
        }
        val intersection = input.toString().toList().intersect(generatedNumber.toString().toList())
        var rightCount = 0;
        for ((i, j) in input.toString().zip(generatedNumber.toString()) ){
            if (i == j) rightCount += 1
    }
        CompareResult(intersection.size, rightCount)   // return value is a placeholder
    }
}

fun main() {
    println("Hello World!")
    // TODO: call the App.playNumberGame function with and without default arguments
    val app = App()
    app.playNumberGame()
    app.playNumberGame(3)
    app.playNumberGame(10)
}
