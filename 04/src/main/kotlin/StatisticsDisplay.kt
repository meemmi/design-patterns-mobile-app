package org.example

class StatisticsDisplay : Observer {
    private val temperatureReadings = mutableListOf<Float>()

    override fun update(data: WeatherData) {
        temperatureReadings.add(data.temperature)
        display()
    }

    fun display() {
        val avgTemp = temperatureReadings.average()
        println("StatisticsDisplay: Avg temperature: ${avgTemp}C")
    }

}