private class Temperature(value: Double)

class CelsiusConverter(value: Double) extends Temperature(value) {
  def this() = this(0)

  def toKelvin: Double = this.value + 273.15

  def toFahrenheit: Double = (9/5) * this.value + 32
}

class KelvinConverter(value: Double) extends Temperature(value) {
  def this() = this(0)

  def toCelsius: Double = this.value  - 273.15

  def toFahrenheit: Double = (9/5) * toCelsius + 32
}

class FahrenheitConverter(value: Double) extends Temperature(value) {
  def this() = this(0)

  def toCelsius: Double = (5.0 / 9.0) * (this.value - 32)

  def toKelvin: Double = toCelsius + 273.15
}
