# MAD - Exercise 01
## Tasks
* Watch the Kotlin Crashcourse Video in Moodle or complete the tutorials **[Introduction to programming in Kotlin](https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1)** and **[Kotlin fundamentals](https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-1
)**.
* Answer the questions inside this Readme.md file and push it to your repository.
* Submit your coding solution of the Number Guessing Game inside the repository.
* Submit the link to your repository in Moodle.

## Questions
### Describe how Kotlin handles null safety. What are nullable types and non-null types in Kotlin? (0,5 points)

<span style="color:blue">used to prevent null pointer exceptions<br>
there are two types of references:<br>
* non-nullable references - cannot hold null (= for normal initialization)<br>
* nullable references - can hold null (= you can declare a variable as null-able if you add a ? after the classname)<br>
</span>
> Note: you can also use code snippets to illustrate your answer. 

```kotlin
// example code snippet
val a: String = "value" // non-null type
var b: String? = "abc" // can be set to null - nullable
```

<span style="color:blue">use of nullable value:<br>
the occurrence must be handled, there are these options:<br>
* Checking for null in conditions (with if else before)<br>
* Safe calls (use a question mark (=safe call operator) before accessing a specific property or function)<br>
* Elvis operator ("if b is not null, use it, otherwise use some non-null value")<br>
* The !! operator (converts any value to a non-nullable type and throws an exception if the value is null)<br>
(<br>
Nullable receiver<br>
Safe casts<br>
)<br>

Quelle: https://kotlinlang.org/docs/null-safety.html#safe-casts
</span>



### What are lambda expressions and higher order functions in Kotlin? Why would you store a function inside a variable? (0,5 points)


<span style="color:blue">Higher-order function = a function that takes functions as parameters, or returns a function<br>
Lambda expressions (also anonymous functions) = functions that are not declared but are passed immediately as an expression

```kotlin
// example code snippet
val sum: (Int, Int) -> Int = { x, y -> x + y } //lambda
fun operation(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    return op(x, y)
} //higher order function
```

Quelle: https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions
</span>


### Provide a solution for the following number guessing game inside `App.kt`. (3 points)

## Number Guessing Game in Kotlin
The game is a simple number guessing game. The task is to generate a random, max 9-digit, number. The number must **not contain repeating digits**. Valid digits are 1-9.
Ask the user to guess the max 9-digit number. The game is finished when the user guesses the correct digits in the correct order.
In each round, the user gets feedback about the number of correct digits and the number of correct digits in the correct position.
The output should be in the format "n:m", where "n" is the number of digits guessed correctly regardless of their position, 
and "m" is the number of digits guessed correctly at their correct position. Here are some examples:

This example shows the game flow with 4-digits to guess (the default argument)

Generated number: 8576
-	User input: 1234, Output: 0:0
-	User input: 5678, Output: 4:1
-	User input: 5555, Output: 1:1
-	User input: 3586, Output: 3:2
-	User input: 8576, Output: 4:4 -> user wins

Take a look into the provided code structure in `src/main/kotlin/App.kt`. Implement the following methods (lambda expressions):
- _playNumberGame(digitsToGuess: Int = 4)_ (1 point): The main game loop that handles user input and game state. Make use of _generateRandomNonRepeatingNumber_ and _checkUserInputAgainstGeneratedNumber_ here. This function also utilizes a default argument 
- _generateRandomNonRepeatingNumber_ (1 point): A lambda expression that generates a random number with non-repeating digits of a specified length.
- _checkUserInputAgainstGeneratedNumber_ (1 point): A lambda expression that compares the user's input against the generated number and provides feedback.

``CompareResult.kt`` This class is a data structure which helps with bundling the result of the comparison of the user input and the generated number. Look at the toSting() and use it in your output.

Run the project with `./gradlew run` and test your implementation with the provided tests in `src/test/kotlin/AppTest.kt` with `./gradlew test`.

# Project Structure
The project is structured into two main Kotlin files:

**App.kt**: Contains the main game logic and functions.

**AppTest.kt**: Contains unit tests for the various functions in App.kt.

