package org.example

class CurrentConditionsDisplay: Observer {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f


    override fun update(data: WeatherData) {
        temperature = data.temperature
        humidity = data.humidity
        display()
    }

    private fun display() {
        println("CurrentConditionsDisplay: Current conditions: ${temperature}C degrees and ${humidity}% humidity")
    }
}