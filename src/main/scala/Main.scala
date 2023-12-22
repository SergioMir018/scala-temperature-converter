import java.io.IOException

object Main extends App {
  println(
    """
      ||-----------------------------|
      || WELCOME TO MY VERY FIRST    |
      || SCALA TEMPERATURE CONVERTER |
      ||-----------------------------|
      |""".stripMargin)

  private var mainUserInput: Double = Double.MinValue
  private val tempUserInput: Option[Double] = Some(Double.MinValue)

  while (mainUserInput != 0) {
    println(
      """
        |
        |What kind of temperature do you want to initialize?
        |1 - Celsius
        |2 - Fahrenheit
        |3 - Kelvin
        |0 - Exit
        |""".stripMargin)

    print("user ->> ")

    mainUserInput = userInputValue

    val tempConverter: Option[Temperature] = mainUserInput match {
      case 0 =>
        println(s"${Console.CYAN} Exited from program")
        None
      case 1 =>
        println("")
        print("Enter the temperature value(C): ")
        Some(new CelsiusConverter(userInputValue))
      case 2 =>
        println("")
        print("Enter the temperature value(F): ")
        Some(FahrenheitConverter(userInputValue))
      case 3 =>
        println("")
        print("Enter the temperature value(K): ")
        Some(KelvinConverter(userInputValue))
      case _ => None
    }

    tempConverter match {
      case Some(value) => handleTempInput(tempUserInput.get, value)
      case None =>
    }
  }
}

def readUserInput: Option[Double] = {
  try {
    Some(scala.io.StdIn.readDouble())
  } catch {
    case e: IOException =>
      println(s"${Console.RED}There has been an error during input reading: ${e.getMessage}${Console.RESET}")
      None
    case e: NumberFormatException =>
      None
  }
}

def userInputValue: Double = {
  readUserInput.getOrElse {
    println(s"${Console.YELLOW}Please enter a valid value${Console.RESET}")
    userInputValue
  }
}

def handleTempInput(value: Double, tempConverter: Temperature): Unit = {
  var tempUserInput: Double = value

  while (tempUserInput != 0) {
    tempConverter match {
      case temp: CelsiusConverter =>
        println(
          """
            |
            |The Celsius value will be converted to...
            |1 - Fahrenheit
            |2 - Kelvin
            |0 - Back
            |""".stripMargin)

        print("user ->> ")

        tempUserInput = userInputValue
        userCelsiusConverterOption(tempUserInput, temp)
      case temp: FahrenheitConverter =>
        println(
          """
            |
            |The Fahrenheit value will be converted to...
            |1 - Celsius
            |2 - Kelvin
            |0 - Back
            |""".stripMargin)

        print("user ->> ")

        tempUserInput = userInputValue
        userFahrenheitConverterOption(tempUserInput, temp)
      case temp: KelvinConverter =>
        println(
          """
            |
            |The Kelvin value will be converted to...
            |1 - Celsius
            |2 - Fahrenheit
            |0 - Back
            |""".stripMargin)

        print("user ->> ")

        tempUserInput = userInputValue
        userKelvinConverterOption(tempUserInput, temp)
      case _ =>
        println(s"${Console.YELLOW_B}Issues while reading temperature value${Console.RESET}")
    }
  }
}

def userCelsiusConverterOption(inputValue: Double, temp: CelsiusConverter): Unit = {
  inputValue match {
    case 1 => println(s"The Fahrenheit temperature equivalent is: ${temp.toFahrenheit}")
    case 2 => println(s"The Kelvin temperature equivalent is: ${temp.toKelvin}")
    case 0 => println(s"${Console.CYAN} Exited from Celsius conversion${Console.RESET}")
  }
}

def userFahrenheitConverterOption(inputValue: Double, temp: FahrenheitConverter): Unit = {
  inputValue match {
    case 1 => println(s"The Celsius temperature equivalent is: ${temp.toCelsius}")
    case 2 => println(s"The Kelvin temperature equivalent is: ${temp.toKelvin}")
    case 0 => println(s"${Console.CYAN} Exited from Fahrenheit conversion${Console.RESET}")
  }
}

def userKelvinConverterOption(inputValue: Double, temp: KelvinConverter): Unit = {
  inputValue match {
    case 1 => println(s"The Celsius temperature equivalent is: ${temp.toCelsius}")
    case 2 => println(s"The Fahrenheit temperature equivalent is: ${temp.toFahrenheit}")
    case 0 => println(s"${Console.CYAN} Exited from Kelvin conversion${Console.RESET}")
  }
}
