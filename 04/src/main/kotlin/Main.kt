package org.example

fun main() {
// 1. Create the WeatherStation (the subject).
    val weatherStation = WeatherStation()

// 2. Create the display devices (the observers).
    val currentDisplay = CurrentConditionsDisplay()
    val statsDisplay = StatisticsDisplay()

// 3. Register the observers with the weather station.
    weatherStation.registerObserver(currentDisplay)
    weatherStation.registerObserver(statsDisplay)

// Simulate new weather measurements.
    println("--- Simulating new measurement ---")
    weatherStation.measurementsChanged(WeatherData(25.0f, 65f,1012f))
    println("\n--- Simulating another measurement ---")
    weatherStation.measurementsChanged(WeatherData(27.5f, 70f,1011f))

// 4. Unregister one of the observers.
    println("\n--- Unregistering Statistics Display ---")
    weatherStation.removeObserver(statsDisplay)

    println("\n--- Simulating a final measurement ---")
    weatherStation.measurementsChanged(WeatherData(26.0f, 90f,1013f))
}
