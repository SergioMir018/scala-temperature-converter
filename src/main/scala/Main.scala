import java.io.IOException

object Main extends App {
  println(
    """
      ||-----------------------------|
      || WELCOME TO MY VERY FIRST    |
      || SCALA TEMPERATURE CONVERTER |
      ||-----------------------------|
      |""".stripMargin)

  private var input: Double = Double.MinValue

  while (input != 0) {
    println("What kind of temperature do you want to initialize?")
    println("1 - Celsius")
    println("2 - Fahrenheit")
    println("3 - Kelvin")
    println("0 - Exit")

    print("user ->> ")

    val userInput = scala.io.StdIn.readLine()

    try {
      input = userInput.toDouble
    } catch {
      case e: IOException => println(s"${Console.RED}There has been an error during input reading: ${e.getMessage}${Console.RESET}")
      case e: NumberFormatException => println(s"${Console.YELLOW}Please enter a valid option${Console.RESET}")
    }

    input match {
      case 0 => println(s"${Console.CYAN} Exited from program")
      case 1 => {
        println
      }
    }
  }
}
