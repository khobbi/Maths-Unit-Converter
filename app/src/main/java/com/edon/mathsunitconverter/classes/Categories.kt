package com.edon.mathsunitconverter.classes

class Categories{
    //ArrayList to contain the various categories
    private val area: ArrayList<String> = ArrayList()
    private val energy: ArrayList<String> = ArrayList()
    private val force: ArrayList<String> = ArrayList()
    private val length: ArrayList<String> = ArrayList()
    private val mass: ArrayList<String> = ArrayList()
    private val power: ArrayList<String> = ArrayList()
    private val pressure: ArrayList<String> = ArrayList()
    private val temperature: ArrayList<String> = ArrayList()
    private val time: ArrayList<String> = ArrayList()
    private val velocity: ArrayList<String> = ArrayList()
    private val volume: ArrayList<String> = ArrayList()
    private val weight: ArrayList<String> = ArrayList()
    val categoryList: ArrayList<String> = ArrayList()

    init {
        area.add("Square millimeters")
        area.add("Square centimeters")
        area.add("Square meters")
        area.add("Hectares")
        area.add("Square kilometers")
        area.add("Square inches")
        area.add("Square feet")
        area.add("Square yards")
        area.add("Acres")
        area.add("Square miles")
        energy.add("Joules")
        energy.add("Kilojoules")
        energy.add("Calories")
        energy.add("Kilocalories")
        energy.add("British thermal units")
        energy.add("Foot-pounds")
        energy.add("Electron volts")
        force.add("Newtons")
        force.add("Pounds")
        length.add("Microns")
        length.add("Millimeters")
        length.add("Centimeters")
        length.add("Meters")
        length.add("Kilometers")
        length.add("Inches")
        length.add("Rods")
        length.add("Feet")
        length.add("Yards")
        length.add("Fathoms")
        length.add("Miles")
        length.add("Nautical Miles")
        length.add("Astronomical units")
        mass.add("Milligrams")
        mass.add("Grams")
        mass.add("Kilograms")
        power.add("Watts")
        power.add("Horsepower")
        power.add("Lumens")
        power.add("Kilowatts")
        pressure.add("Pascals")
        pressure.add("Kilopascals")
        pressure.add("Millimeters of Mercury")
        pressure.add("Bars")
        pressure.add("Atmospheres")
        pressure.add("Pounds per square inch")
        temperature.add("Degrees Celsius")
        temperature.add("Degrees Fahrenheit")
        temperature.add("Kelvin")
        time.add("Microseconds")
        time.add("Milliseconds")
        time.add("Seconds")
        time.add("Minutes")
        time.add("Hours")
        time.add("Days")
        time.add("Months")
        time.add("Years")
        velocity.add("Meters/Second")
        velocity.add("Miles/Hour")
        velocity.add("Feet/Hour")
        velocity.add("Kilometers/Hour")
        volume.add("Cubic centimeters")
        volume.add("Liters")
        volume.add("Cubic meters")
        volume.add("Cubic inches")
        volume.add("Fluid ounces (UK)")
        volume.add("Fluid ounces (US)")
        volume.add("Pints (US)")
        volume.add("Pints (UK)")
        volume.add("Quarts (US)")
        volume.add("Quarts (UK)")
        volume.add("Gallons (US)")
        volume.add("Gallons (UK)")
        volume.add("Cubic feet")
        volume.add("Cubic yards")
        weight.add("Milligrams (on Earth)")
        weight.add("Grams (on Earth)")
        weight.add("Kilograms (on Earth)")
        weight.add("Tonnes")
        weight.add("Ounces")
        weight.add("Pounds")
        weight.add("Short tons")
        weight.add("Long tons")
        categoryList.add("Area")
        categoryList.add("Energy")
        categoryList.add("Force")
        categoryList.add("Length")
        categoryList.add("Mass")
        categoryList.add("Power")
        categoryList.add("Pressure")
        categoryList.add("Temperature")
        categoryList.add("Time")
        categoryList.add("Velocity")
        categoryList.add("Volume")
        categoryList.add("Weight/Mass")
    }

    //get a category
    fun getCategory(position: Int): ArrayList<String>{
        return when (position) {
            0 -> area
            1 -> energy
            2 -> force
            3 -> length
            4 -> mass
            5 -> power
            6 -> pressure
            7 -> temperature
            8 -> time
            9 -> velocity
            10 -> volume
            11 -> weight
            else -> area
        }
    }
}