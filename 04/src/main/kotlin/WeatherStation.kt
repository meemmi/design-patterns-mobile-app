package org.example

class WeatherStation(): Subject {
    private val observers = mutableSetOf<Observer>()
    private var currentData: WeatherData? = null

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        val data = currentData ?: return
        observers.forEach {it.update(data)}
    }


    // This method is called whenever new weather data is available.
    fun measurementsChanged(newData: WeatherData) {
        this.currentData = newData
        println("WeatherStation: Got new data -> $currentData")
        notifyObservers()
    }
}
