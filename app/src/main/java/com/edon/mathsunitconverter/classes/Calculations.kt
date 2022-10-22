package com.edon.mathsunitconverter.classes

object Calculations {
    var indexOfFrom: Int = 0
    var indexOfTo: Int = 0
    var categoryIndex: Int = 0

    //do calculations
    fun calculate(number: Double): Double{
        //separate calculation for temperature conversion
        if (categoryIndex == 7) {
            return calcTemperature(number, indexOfFrom, indexOfTo)
        }
        val factor: Double = detFactor(categoryIndex, indexOfFrom, indexOfTo)
        return number * factor
    }

    //method for finding factor for the temperature category
    fun calcTemperature(temperature: Double, from: Int, to: Int): Double {
        return if (from == 0 && to == 1) temperature * (9.0 / 5.0) + 32.0
        else if (from == 0 && to == 2) temperature + 273.15
        else if (from == 1 && to == 0) (temperature - 32.0) * (5.0 / 9.0)
        else if (from == 1 && to == 2) (temperature - 32.0) * (5.0 / 9.0) + 273.15
        else if (from == 2 && to == 0) temperature - 273.15
        else if (from == 2 && to == 1) (temperature - 273.15) * (9.0 / 5.0) + 32.0
        else temperature
    }

    //determine factor of calculation
    fun detFactor(categoryPosition: Int, from: Int, to: Int): Double {
        return when (categoryPosition) {
            0 -> {
                detFactorArea(from, to)
            }
            1 -> {
                detFactorEnergy(from, to)
            }
            2 -> {
                detFactorForce(from, to)
            }
            3 -> {
                detFactorLength(from, to)
            }
            4 -> {
                detFactorMass(from, to)
            }
            5 -> {
                detFactorPower(from, to)
            }
            6 -> {
                detFactorPressure(from, to)
            }
            8 -> {
                detFactorTime(from, to)
            }
            9 -> {
                detFactorVelocity(from, to)
            }
            10 -> {
                detFactorVolume(from, to)
            }
            11 -> {
                detFactorWeight(from, to)
            }
            else -> {
                1.0
            }
        }
    }

    fun detFactorWeight(from: Int, to: Int): Double {
        //milligrams on Earth with others
        if(from == 0 && to == 1)
            return 0.001
        else if(from == 0 && to == 2)
            return 1E-06
        else if(from == 0 && to == 3)
            return 1E-09
        else if(from == 0 && to == 4)
            return 3.5273962105112E-05
        else if(from == 0 && to == 5)
            return 2.20462262184878E-06
        else if(from == 0 && to == 6)
            return 1.10231131092439E-09
        else if(from == 0 && to == 7)
            return 9.84206527417328E-10
        //grams on Earth with others
        else if(from == 1 && to == 0)
            return 1000.0
        else if(from == 1 && to == 2)
            return 0.001
        else if(from == 1 && to == 3)
            return 1E-06
        else if(from == 1 && to == 4)
            return 0.035273962105112
        else if(from == 1 && to == 5)
            return 0.00220462262184878
        else if(from == 1 && to == 6)
            return 1.10231131092439E-06
        else if(from == 1 && to == 7)
            return 9.84206527417328E-07
        //kilograms on Earth with others
        else if(from == 2 && to == 0)
            return 1000000.0
        else if(from == 2 && to == 1)
            return 1000.0
        else if(from == 2 && to == 3)
            return 0.001
        else if(from == 2 && to == 4)
            return 35.273962105112
        else if(from == 2 && to == 5)
            return 2.20462262184878
        else if(from == 2 && to == 6)
            return 0.00110231131092439
        else if(from == 2 && to == 7)
            return 0.000984206527417328
        //tonnes with others
        else if(from == 3 && to == 0)
            return 1000000000.0
        else if(from == 3 && to == 1)
            return 1000000.0
        else if(from == 3 && to == 2)
            return 1000.0
        else if(from == 3 && to == 4)
            return 35273.962105112
        else if(from == 3 && to == 5)
            return 2204.62262184878
        else if(from == 3 && to == 6)
            return 1.10231131092439
        else if(from == 3 && to == 7)
            return 0.984206527417328
        //ounces with others
        else if(from == 4 && to == 0)
            return 28349.523
        else if(from == 4 && to == 1)
            return 28.349523
        else if(from == 4 && to == 2)
            return 0.028349523
        else if(from == 4 && to == 3)
            return 2.8349523E-05
        else if(from == 4 && to == 5)
            return 0.0624999997244222
        else if(from == 4 && to == 6)
            return 3.12499998622111E-05
        else if(from == 4 && to == 7)
            return 2.79017855857677E-05
        //pounds with others
        else if(from == 5 && to == 0)
            return 453592.37
        else if(from == 5 && to == 1)
            return 453.59237
        else if(from == 5 && to == 2)
            return 0.45359237
        else if(from == 5 && to == 3)
            return 0.00045359237
        else if(from == 5 && to == 4)
            return 16.0000000705479
        else if(from == 5 && to == 6)
            return 0.0005
        else if(from == 5 && to == 7)
            return 0.000446428571340696
        //short tons with others
        else if(from == 6 && to == 0)
            return 907184740.0
        else if(from == 6 && to == 1)
            return 907184.74
        else if(from == 6 && to == 2)
            return 907.18474
        else if(from == 6 && to == 3)
            return 0.90718474
        else if(from == 6 && to == 4)
            return 32000.0001410958
        else if(from == 6 && to == 5)
            return 2000.0
        else if(from == 6 && to == 7)
            return 0.892857142681392
        //long tons with others
        else if(from == 7 && to == 0)
            return 1016046909.0
        else if(from == 7 && to == 1)
            return 1016046.909
        else if(from == 7 && to == 2)
            return 1016.046909
        else if(from == 7 && to == 3)
            return 1.016046909
        else if(from == 7 && to == 4)
            return 35840.0001650821
        else if(from == 7 && to == 5)
            return 2240.00000044092
        else if(from == 7 && to == 6)
            return 1.12000000022046
        else
            return 1.0
    }

    fun detFactorVolume(from: Int, to: Int): Double {
        //cubic centimeters with others
        if(from == 0 && to == 1)
            return 0.001
        if(from == 0 && to == 2)
            return 1E-06
        if(from == 0 && to == 3)
            return 0.0610237440947323
        if(from == 0 && to == 4)
            return 0.035195079727854
        if(from == 0 && to == 5)
            return 0.033814022701843
        if(from == 0 && to == 6)
            return 0.00211337641886519
        if(from == 0 && to == 7)
            return 0.0017597539863927
        if(from == 0 && to == 8)
            return 0.00105668820943259
        if(from == 0 && to == 9)
            return 0.000879876993196351
        if(from == 0 && to == 10)
            return 0.000264172052358148
        if(from == 0 && to == 11)
            return 0.000219969248299088
        if(from == 0 && to == 12)
            return 3.53146667214886E-05
        if(from == 0 && to == 13)
            return 1.30795061931439E-06
        //liters with others
        if(from == 1 && to == 0)
            return 1000.0
        if(from == 1 && to == 2)
            return 0.001
        if(from == 1 && to == 3)
            return 61.0237440947323
        if(from == 1 && to == 4)
            return 35.1950797278541
        else if(from == 1 && to == 5)
            return 33.814022701843
        else if(from == 1 && to == 6)
            return 2.11337641886519
        else if(from == 1 && to == 7)
            return 1.7597539863927
        else if(from == 1 && to == 8)
            return 1.05668820943259
        else if(from == 1 && to == 9)
            return 0.879876993196351
        else if(from == 1 && to == 10)
            return 0.264172052358148
        else if(from == 1 && to == 11)
            return 0.219969248299088
        else if(from == 1 && to == 12)
            return 0.0353146667214886
        else if(from == 1 && to == 13)
            return 0.00130795061931439
        //cubic meters with others
        else if(from == 2 && to == 0)
            return 1000000.0
        else if(from == 2 && to == 1)
            return 1000.0
        else if(from == 2 && to == 3)
            return 61023.7440947323
        else if(from == 2 && to == 4)
            return 35195.079727854
        else if(from == 2 && to == 5)
            return 33814.022701843
        else if(from == 2 && to == 6)
            return 2113.37641886519
        else if(from == 2 && to == 7)
            return 1759.7539863927
        else if(from == 2 && to == 8)
            return 1056.68820943259
        else if(from == 2 && to == 9)
            return 879.876993196351
        else if(from == 2 && to == 10)
            return 264.172052358148
        else if(from == 2 && to == 11)
            return 219.969248299088
        else if(from == 2 && to == 12)
            return 35.3146667214886
        else if(from == 2 && to == 13)
            return 1.30795061931439
        //cubic inches with others
        else if(from == 3 && to == 0)
            return 16.387064
        else if(from == 3 && to == 1)
            return 0.016387064
        else if(from == 3 && to == 2)
            return 1.6387064E-05
        else if(from == 3 && to == 4)
            return 0.576744023985447
        else if(from == 3 && to == 5)
            return 0.554112554112554
        else if(from == 3 && to == 6)
            return 0.0346320346320346
        else if(from == 3 && to == 7)
            return 0.0288372011992723
        else if(from == 3 && to == 8)
            return 0.0173160173160173
        else if(from == 3 && to == 9)
            return 0.0144186005996362
        else if(from == 3 && to == 10)
            return 0.00432900432900433
        else if(from == 3 && to == 11)
            return 0.00360465014990904
        else if(from == 3 && to == 12)
            return 0.000578703703703704
        else if(from == 3 && to == 13)
            return 2.14334705075446E-05
        //fluid ounces (UK) with others
        else if(from == 4 && to == 0)
            return 28.4130625
        else if(from == 4 && to == 1)
            return 0.0284130625
        else if(from == 4 && to == 2)
            return 2.84130625E-05
        else if(from == 4 && to == 3)
            return 1.73387145494763
        else if(from == 4 && to == 5)
            return 0.960759940403884
        else if(from == 4 && to == 6)
            return 0.0600474962752427
        else if(from == 4 && to == 7)
            return 0.05
        else if(from == 4 && to == 8)
            return 0.0300237481376214
        else if(from == 4 && to == 9)
            return 0.025
        else if(from == 4 && to == 10)
            return 0.00750593703440534
        else if(from == 4 && to == 11)
            return 0.00625
        else if(from == 4 && to == 12)
            return 0.00100339783272433
        else if(from == 4 && to == 13)
            return 3.71628826934935E-05
        //fluid ounces (US) with others
        else if(from == 5 && to == 0)
            return 29.5735295625
        else if(from == 5 && to == 1)
            return 0.0295735295625
        else if(from == 5 && to == 2)
            return 2.95735295625E-05
        else if(from == 5 && to == 3)
            return 1.8046875
        else if(from == 5 && to == 4)
            return 1.04084273078624
        else if(from == 5 && to == 6)
            return 0.0625
        else if(from == 5 && to == 7)
            return 0.0520421365393118
        else if(from == 5 && to == 8)
            return 0.03125
        else if(from == 5 && to == 9)
            return 0.0260210682696559
        else if(from == 5 && to == 10)
            return 0.0078125
        else if(from == 5 && to == 11)
            return 0.00650526706741397
        else if(from == 5 && to == 12)
            return 0.00104437934027778
        else if(from == 5 && to == 13)
            return 3.86807163065844E-05
        //pints (US) with others
        else if(from == 6 && to == 0)
            return 473.176473
        else if(from == 6 && to == 1)
            return 0.473176473
        else if(from == 6 && to == 2)
            return 0.000473176473
        else if(from == 6 && to == 3)
            return 28.875
        else if(from == 6 && to == 4)
            return 16.6534836925798
        else if(from == 6 && to == 5)
            return 16.0
        else if(from == 6 && to == 7)
            return 0.832674184628989
        else if(from == 6 && to == 8)
            return 0.5
        else if(from == 6 && to == 9)
            return 0.416337092314494
        else if(from == 6 && to == 10)
            return 0.125
        else if(from == 6 && to == 11)
            return 0.104084273078624
        else if(from == 6 && to == 12)
            return 0.0167100694444444
        else if(from == 6 && to == 13)
            return 0.00061889146090535
        //pints (UK) with others
        else if(from == 7 && to == 0)
            return 568.26125
        else if(from == 7 && to == 1)
            return 0.56826125
        else if(from == 7 && to == 2)
            return 0.00056826125
        else if(from == 7 && to == 3)
            return 34.6774290989527
        else if(from == 7 && to == 4)
            return 20.0
        else if(from == 7 && to == 5)
            return 19.2151988080777
        else if(from == 7 && to == 6)
            return 1.20094992550486
        else if(from == 7 && to == 8)
            return 0.600474962752428
        else if(from == 7 && to == 9)
            return 0.5
        else if(from == 7 && to == 10)
            return 0.150118740688107
        else if(from == 7 && to == 11)
            return 0.125
        else if(from == 7 && to == 12)
            return 0.0200679566544865
        else if(from == 7 && to == 13)
            return 0.000743257653869871
        //quarts (US) with others
        else if(from == 8 && to == 0)
            return 946.352946
        else if(from == 8 && to == 1)
            return 0.946352946
        else if(from == 8 && to == 2)
            return 0.000946352946
        else if(from == 8 && to == 3)
            return 57.75
        else if(from == 8 && to == 4)
            return 33.3069673851596
        else if(from == 8 && to == 5)
            return 32.0
        else if(from == 8 && to == 6)
            return 2.0
        else if(from == 8 && to == 7)
            return 1.66534836925798
        else if(from == 8 && to == 9)
            return 0.832674184628989
        else if(from == 8 && to == 10)
            return 0.25
        else if(from == 8 && to == 11)
            return 0.208168546157247
        else if(from == 8 && to == 12)
            return 0.0334201388888889
        else if(from == 8 && to == 13)
            return 0.0012377829218107
        //quarts (UK) with others
        else if(from == 9 && to == 0)
            return 1136.5225
        else if(from == 9 && to == 1)
            return 1.1365225
        else if(from == 9 && to == 2)
            return 0.0011365225
        else if(from == 9 && to == 3)
            return 69.3548581979054
        else if(from == 9 && to == 4)
            return 40.0
        else if(from == 9 && to == 5)
            return 38.4303976161554
        else if(from == 9 && to == 6)
            return 2.40189985100971
        else if(from == 9 && to == 7)
            return 2.0
        else if(from == 9 && to == 8)
            return 1.20094992550486
        else if(from == 9 && to == 10)
            return 0.300237481376214
        else if(from == 9 && to == 11)
            return 0.25
        else if(from == 9 && to == 12)
            return 0.040135913308973
        if(from == 9 && to == 13)
            return 0.00148651530773974
        //gallons (US) with others
        if(from == 10 && to == 0)
            return 3785.411784
        if(from == 10 && to == 1)
            return 3.785411784
        if(from == 10 && to == 2)
            return 0.003785411784
        if(from == 10 && to == 3)
            return 231.0
        if(from == 10 && to == 4)
            return 133.227869540638
        if(from == 10 && to == 5)
            return 128.0
        if(from == 10 && to == 6)
            return 8.0
        if(from == 10 && to == 7)
            return 6.66139347703191
        if(from == 10 && to == 8)
            return 4.0
        if(from == 10 && to == 9)
            return 3.33069673851596
        else if(from == 10 && to == 11)
            return 0.832674184628989
        else if(from == 10 && to == 12)
            return 0.133680555555556
        else if(from == 10 && to == 13)
            return 0.0049511316872428
        //gallons (UK) with others
        else if(from == 11 && to == 0)
            return 4546.09
        else if(from == 11 && to == 1)
            return 4.54609
        else if(from == 11 && to == 2)
            return 0.00454609
        else if(from == 11 && to == 3)
            return 277.419432791621
        if(from == 11 && to == 4)
            return 160.0
        if(from == 11 && to == 5)
            return 153.721590464621
        if(from == 11 && to == 6)
            return 9.60759940403884
        if(from == 11 && to == 7)
            return 8.0
        if(from == 11 && to == 8)
            return 4.80379970201942
        if(from == 11 && to == 9)
            return 4.0
        else if(from == 11 && to == 10)
            return 1.20094992550486
        else if(from == 11 && to == 12)
            return 0.160543653235892
        else if(from == 11 && to == 13)
            return 0.00594606123095897
        //cubic feet with others
        else if(from == 12 && to == 0)
            return 28316.846592
        else if(from == 12 && to == 1)
            return 28.316846592
        else if(from == 12 && to == 2)
            return 0.028316846592
        else if(from == 12 && to == 3)
            return 1728.0
        else if(from == 12 && to == 4)
            return 996.613673446852
        else if(from == 12 && to == 5)
            return 957.506493506494
        else if(from == 12 && to == 6)
            return 59.8441558441559
        else if(from == 12 && to == 7)
            return 49.8306836723426
        else if(from == 12 && to == 8)
            return 29.9220779220779
        else if(from == 12 && to == 9)
            return 24.9153418361713
        else if(from == 12 && to == 10)
            return 7.48051948051948
        else if(from == 12 && to == 11)
            return 6.22883545904283
        else if(from == 12 && to == 13)
            return 0.037037037037037
        //cubic yards with others
        else if(from == 13 && to == 0)
            return 764554.857984
        else if(from == 13 && to == 1)
            return 764.554857984
        else if(from == 13 && to == 2)
            return 0.764554857984
        else if(from == 13 && to == 3)
            return 46656.0
        else if(from == 13 && to == 4)
            return 26908.569183065
        else if(from == 13 && to == 5)
            return 25852.6753246753
        else if(from == 13 && to == 6)
            return 1615.79220779221
        else if(from == 13 && to == 7)
            return 1345.42845915325
        else if(from == 13 && to == 8)
            return 807.896103896104
        else if(from == 13 && to == 9)
            return 672.714229576625
        else if(from == 13 && to == 10)
            return 201.974025974026
        else if(from == 13 && to == 11)
            return 168.178557394156
        else if(from == 13 && to == 12)
            return 27.0
        else
            return 1.0
    }

    fun detFactorVelocity(from: Int, to: Int): Double {
        //m/s with others
        if(from == 0 && to == 1)
            return 2.2369362920544
        else if(from == 0 && to == 2)
            return 11811.0
        else if(from == 0 && to == 3)
            return 3.6
        //M/h with others
        if(from == 1 && to == 0)
            return 0.44704
        else if(from == 1 && to == 2)
            return 5279.98944
        else if(from == 1 && to == 3)
            return 1.609344
        //f/h with others
        if(from == 2 && to == 0)
            return 8.46668360003387E-05
        else if(from == 2 && to == 1)
            return 0.000189394318182576
        else if(from == 2 && to == 3)
            return 0.000304800609601219
        //km/h with others
        if(from == 3 && to == 0)
            return 0.277777777777778
        else if(from == 3 && to == 1)
            return 0.621371192237334
        else if(from == 3 && to == 2)
            return 3280.83333333333
        else
            return 1.0
    }

    fun detFactorTime(from: Int, to: Int): Double {
        //microseconds with others
        if(from == 0 && to == 1)
            return 0.001
        else if(from == 0 && to == 2)
            return 1E-06
        else if(from == 0 && to == 3)
            return 1.66666666666667E-08
        else if(from == 0 && to == 4)
            return 2.77777777777778E-10
        else if(from == 0 && to == 5)
            return 1.15740740740741E-11
        else if(from == 0 && to == 6)
            return 1.65343915343915E-12
        else if(from == 0 && to == 7)
            return 3.16887645350786E-14
        //milliseconds with others
        else if(from == 1 && to == 0)
            return 1000.0
        else if(from == 1 && to == 2)
            return 0.001
        else if(from == 1 && to == 3)
            return 1.66666666666667E-05
        else if(from == 1 && to == 4)
            return 2.77777777777778E-07
        else if(from == 1 && to == 5)
            return 1.15740740740741E-08
        else if(from == 1 && to == 6)
            return 1.65343915343915E-09
        else if(from == 1 && to == 7)
            return 3.16887645350786E-11
        // seconds with others
        else if(from == 2 && to == 0)
            return 1000000.0
        else if(from == 2 && to == 1)
            return 1000.0
        else if(from == 2 && to == 3)
            return 0.0166666666666667
        else if(from == 2 && to == 4)
            return 0.000277777777777778
        else if(from == 2 && to == 5)
            return 1.15740740740741E-05
        else if(from == 2 && to == 6)
            return 1.65343915343915E-06
        else if(from == 2 && to == 7)
            return 3.16887645350786E-08
        // minutes with others
        else if(from == 3 && to == 0)
            return 60000000.0
        else if(from == 3 && to == 1)
            return 60000.0
        else if(from == 3 && to == 2)
            return 60.0
        else if(from == 3 && to == 4)
            return 0.0166666666666667
        else if(from == 3 && to == 5)
            return 0.000694444444444444
        else if(from == 3 && to == 6)
            return 9.92063492063492E-05
        else if(from == 3 && to == 7)
            return 1.90132587210471E-06
        // hours with others
        else if(from == 4 && to == 0)
            return 3600000000.0
        else if(from == 4 && to == 1)
            return 3600000.0
        else if(from == 4 && to == 2)
            return 3600.0
        else if(from == 4 && to == 3)
            return 60.0
        else if(from == 4 && to == 5)
            return 0.0416666666666667
        else if(from == 4 && to == 6)
            return 0.00595238095238095
        else if(from == 4 && to == 7)
            return 0.000114079552326283
        // days with others
        else if(from == 5 && to == 0)
            return 86400000000.0
        else if(from == 5 && to == 1)
            return 86400000.0
        else if(from == 5 && to == 2)
            return 86400.0
        else if(from == 5 && to == 3)
            return 1440.0
        else if(from == 5 && to == 4)
            return 24.0
        else if(from == 5 && to == 6)
            return 0.142857142857143
        else if(from == 5 && to == 7)
            return 0.00273790925583079
        // weeks with others
        else if(from == 6 && to == 0)
            return 604800000000.0
        else if(from == 6 && to == 1)
            return 604800000.0
        else if(from == 6 && to == 2)
            return 604800.0
        else if(from == 6 && to == 3)
            return 10080.0
        else if(from == 6 && to == 4)
            return 168.0
        else if(from == 6 && to == 5)
            return 7.0
        else if(from == 6 && to == 7)
            return 0.0191653647908155
        // years with others
        else if(from == 7 && to == 0)
            return 31556926080000.0
        else if(from == 7 && to == 1)
            return 31556926080.0
        else if(from == 7 && to == 2)
            return 31556926.08
        else if(from == 7 && to == 3)
            return 525948.768
        else if(from == 7 && to == 4)
            return 8765.8128
        else if(from == 7 && to == 5)
            return 365.2422
        else if(from == 7 && to == 6)
            return 52.1774571428571
        else
            return 1.0
    }

    fun detFactorPressure(from: Int, to: Int): Double {
        //pascals with others
        if(from == 0 && to == 1)
            return 0.001
        else if(from == 0 && to == 2)
            return 0.00750187546886722
        else if(from == 0 && to == 3)
            return 1E-05
        else if(from == 0 && to == 4)
            return 9.86923266716013E-06
        else if(from == 0 && to == 5)
            return 0.000145037743897283
        //kilopascals with others
        else if(from == 1 && to == 0)
            return 1000.0
        else if(from == 1 && to == 2)
            return 7.50187546886722
        else if(from == 1 && to == 3)
            return 0.01
        else if(from == 1 && to == 4)
            return 0.00986923266716013
        else if(from == 1 && to == 5)
            return 0.145037743897283
        //millimeters of mercury with others
        else if(from == 2 && to == 0)
            return 133.3
        else if(from == 2 && to == 1)
            return 0.1333
        else if(from == 2 && to == 3)
            return 0.001333
        else if(from == 2 && to == 4)
            return 0.00131556871453245
        else if(from == 2 && to == 5)
            return 0.0193335312615078
        //bars with others
        else if(from == 3 && to == 0)
            return 100000.0
        else if(from == 3 && to == 1)
            return 100.0
        else if(from == 3 && to == 2)
            return 750.187546886722
        else if(from == 3 && to == 4)
            return 0.986923266716013
        else if(from == 3 && to == 5)
            return 14.5037743897283
        //atmospheres with others
        else if(from == 4 && to == 0)
            return 101325.0
        else if(from == 4 && to == 1)
            return 101.325
        else if(from == 4 && to == 2)
            return 760.127531882971
        else if(from == 4 && to == 3)
            return 1.01325
        else if(from == 4 && to == 5)
            return 14.6959494003922
        //pounds per square inch with others
        else if(from == 5 && to == 0)
            return 6894.757
        else if(from == 5 && to == 1)
            return 6.894757
        else if(from == 5 && to == 2)
            return 51.7236084021005
        else if(from == 5 && to == 3)
            return 0.06894757
        else if(from == 5 && to == 4)
            return 0.068045961016531
        else
            return 1.0
    }

    fun detFactorPower(from: Int, to: Int): Double {
        //watts with others
        if(from == 0 && to == 1)
            return 0.00134102209244049
        else if(from == 0 && to == 2)
            return 680.000000136
        else if(from == 0 && to == 3)
            return 0.001
        //horsepower with others
        else if(from == 1 && to == 0)
            return 745.69987
        else if(from == 1 && to == 2)
            return 507075.911701415
        else if(from == 1 && to == 3)
            return 0.74569987
        //lumens with others
        else if(from == 2 && to == 0)
            return 0.001470588235
        else if(from == 2 && to == 1)
            return 1.97209131201806E-06
        else if(from == 2 && to == 3)
            return 1.470588235E-06
        //kilowatts with others
        else if(from == 3 && to == 0)
            return 1000.0
        else if(from == 3 && to == 1)
            return 1.34102209244049
        else if(from == 3 && to == 2)
            return 680000.000136
        else
            return 1.0
    }

    fun detFactorMass(from: Int, to: Int): Double {
        //milligrams with others
        if(from == 0 && to == 1)
            return 0.001
        else if(from == 0 && to == 2)
            return 1E-06
        //grams with others
        if(from == 1 && to == 0)
            return 1000.0
        else if(from == 1 && to == 2)
            return 0.001
        //grams with others
        if(from == 2 && to == 0)
            return 1000000.0
        else if(from == 2 && to == 1)
            return 1000.0
        else
            return 1.0
    }

    fun detFactorLength(from: Int, to: Int): Double {
        //microns with others
        if(from == 0 && to == 1)
            return 0.001
        else if(from == 0 && to == 2)
            return 0.0001
        else if(from == 0 && to == 3)
            return 1E-06
        else if(from == 0 && to == 4)
            return 1E-09
        else if(from == 0 && to == 5)
            return 3.93700787401575E-05
        else if(from == 0 && to == 6)
            return 5.02921015550418E-06
        else if(from == 0 && to == 7)
            return 3.28083989501312E-06
        else if(from == 0 && to == 8)
            return 1.09361329833771E-06
        else if(from == 0 && to == 9)
            return 5.46806649168854E-07
        else if(from == 0 && to == 10)
            return 6.21371192237334E-10
        else if(from == 0 && to == 11)
            return 5.39956803455723E-10
        else if(from == 0 && to == 12)
            return 6.68455676876547E-18
        //millimeters with others
        else if(from == 1 && to == 0)
            return 1000.0
        else if(from == 1 && to == 2)
            return 0.1
        else if(from == 1 && to == 3)
            return 0.001
        else if(from == 1 && to == 4)
            return 1E-06
        else if(from == 1 && to == 5)
            return 0.0393700787401575
        else if(from == 1 && to == 6)
            return 0.00502921015550418
        else if(from == 1 && to == 7)
            return 0.00328083989501312
        else if(from == 1 && to == 8)
            return 0.00109361329833771
        else if(from == 1 && to == 9)
            return 0.000546806649168854
        else if(from == 1 && to == 10)
            return 6.21371192237334E-07
        else if(from == 1 && to == 11)
            return 5.39956803455724E-07
        else if(from == 1 && to == 12)
            return 6.68455676876547E-15
        //centimeters with others
        else if(from == 2 && to == 0)
            return 10000.0
        else if(from == 2 && to == 1)
            return 10.0
        else if(from == 2 && to == 3)
            return 0.01
        else if(from == 2 && to == 4)
            return 1E-05
        else if(from == 2 && to == 5)
            return 0.393700787401575
        else if(from == 2 && to == 6)
            return 0.0502921015550418
        else if(from == 2 && to == 7)
            return 0.0328083989501312
        else if(from == 2 && to == 8)
            return 0.0109361329833771
        else if(from == 2 && to == 9)
            return 0.00546806649168854
        else if(from == 2 && to == 10)
            return 6.21371192237334E-06
        else if(from == 2 && to == 11)
            return 5.39956803455724E-06
        else if(from == 2 && to == 12)
            return 6.68455676876547E-14
        //meters with others
        else if(from == 3 && to == 0)
            return 1000000.0
        else if(from == 3 && to == 1)
            return 1000.0
        else if(from == 3 && to == 2)
            return 100.0
        else if(from == 3 && to == 4)
            return 0.001
        else if(from == 3 && to == 5)
            return 39.3700787401575
        else if(from == 3 && to == 6)
            return 5.02921015550418
        else if(from == 3 && to == 7)
            return 3.28083989501312
        else if(from == 3 && to == 8)
            return 1.09361329833771
        else if(from == 3 && to == 9)
            return 0.546806649168854
        else if(from == 3 && to == 10)
            return 0.000621371192237334
        else if(from == 3 && to == 11)
            return 0.000539956803455724
        else if(from == 3 && to == 12)
            return 6.68455676876547E-12
        //kilometers with others
        else if(from == 4 && to == 0)
            return 1000000000.0
        else if(from == 4 && to == 1)
            return 1000000.0
        else if(from == 4 && to == 2)
            return 100000.0
        else if(from == 4 && to == 3)
            return 1000.0
        else if(from == 4 && to == 5)
            return 39370.0787401575
        else if(from == 4 && to == 6)
            return 5029.21015550418
        else if(from == 4 && to == 7)
            return 3280.83989501312
        else if(from == 4 && to == 8)
            return 1093.61329833771
        else if(from == 4 && to == 9)
            return 546.806649168854
        else if(from == 4 && to == 10)
            return 0.621371192237334
        else if(from == 4 && to == 11)
            return 0.539956803455724
        else if(from == 4 && to == 12)
            return 6.68455676876547E-09
        //inches with others
        else if(from == 5 && to == 0)
            return 25400.0
        else if(from == 5 && to == 1)
            return 25.4
        else if(from == 5 && to == 2)
            return 2.54
        else if(from == 5 && to == 3)
            return 0.0254
        else if(from == 5 && to == 4)
            return 2.54E-05
        else if(from == 5 && to == 6)
            return 0.127741937949806
        else if(from == 5 && to == 7)
            return 0.0833333333333333
        else if(from == 5 && to == 8)
            return 0.0277777777777778
        else if(from == 5 && to == 9)
            return 0.0138888888888889
        else if(from == 5 && to == 10)
            return 1.57828282828283E-05
        else if(from == 5 && to == 11)
            return 1.37149028077754E-05
        else if(from == 5 && to == 12)
            return 1.69787741926643E-13
        //rods with others
        else if(from == 6 && to == 0)
            return 198838.38
        else if(from == 6 && to == 1)
            return 198.83838
        else if(from == 6 && to == 2)
            return 19.883838
        else if(from == 6 && to == 3)
            return 0.19883838
        else if(from == 6 && to == 4)
            return 0.00019883838
        else if(from == 6 && to == 5)
            return 7.82828267716535
        else if(from == 6 && to == 7)
            return 0.652356889763779
        else if(from == 6 && to == 8)
            return 0.217452296587927
        else if(from == 6 && to == 9)
            return 0.108726148293963
        else if(from == 6 && to == 10)
            return 0.00012355244124314
        else if(from == 6 && to == 11)
            return 0.000107364136069114
        else if(from == 6 && to == 12)
            return 1.32914643891936E-12
        //feet with others
        else if(from == 7 && to == 0)
            return 304800.0
        else if(from == 7 && to == 1)
            return 304.8
        else if(from == 7 && to == 2)
            return 30.48
        else if(from == 7 && to == 3)
            return 0.3048
        else if(from == 7 && to == 4)
            return 0.0003048
        else if(from == 7 && to == 5)
            return 12.0
        else if(from == 7 && to == 6)
            return 1.53290325539768
        else if(from == 7 && to == 8)
            return 0.333333333333333
        else if(from == 7 && to == 9)
            return 0.166666666666667
        else if(from == 7 && to == 10)
            return 0.000189393939393939
        else if(from == 7 && to == 11)
            return 0.000164578833693305
        else if(from == 7 && to == 12)
            return 2.03745290311972E-12
        //yards with others
        else if(from == 8 && to == 0)
            return 914400.0
        else if(from == 8 && to == 1)
            return 914.4
        else if(from == 8 && to == 2)
            return 91.44
        else if(from == 8 && to == 3)
            return 0.9144
        else if(from == 8 && to == 4)
            return 0.0009144
        else if(from == 8 && to == 5)
            return 36.0
        else if(from == 8 && to == 6)
            return 4.59870976619303
        else if(from == 8 && to == 7)
            return 3.0
        else if(from == 8 && to == 9)
            return 0.5
        else if(from == 8 && to == 10)
            return 0.000568181818181818
        else if(from == 8 && to == 11)
            return 0.000493736501079914
        else if(from == 8 && to == 12)
            return 6.11235870935915E-12
        //fathroms with others
        else if(from == 9 && to == 0)
            return 1828800.0
        else if(from == 9 && to == 1)
            return 1828.8
        else if(from == 9 && to == 2)
            return 182.88
        else if(from == 9 && to == 3)
            return 1.8288
        else if(from == 9 && to == 4)
            return 0.0018288
        else if(from == 9 && to == 5)
            return 72.0
        else if(from == 9 && to == 6)
            return 9.19741953238605
        else if(from == 9 && to == 7)
            return 6.0
        if(from == 9 && to == 8)
            return 2.0
        if(from == 9 && to == 10)
            return 0.00113636363636364
        if(from == 9 && to == 11)
            return 0.000987473002159827
        if(from == 9 && to == 12)
            return 1.22247174187183E-11
        //miles with others
        else if(from == 10 && to == 0)
            return 1609344000.0
        else if(from == 10 && to == 1)
            return 1609344.0
        else if(from == 10 && to == 2)
            return 160934.4
        else if(from == 10 && to == 3)
            return 1609.344
        else if(from == 10 && to == 4)
            return 1.609344
        else if(from == 10 && to == 5)
            return 63360.0
        else if(from == 10 && to == 6)
            return 8093.72918849972
        else if(from == 10 && to == 7)
            return 5280.0
        else if(from == 10 && to == 8)
            return 1760.0
        else if(from == 10 && to == 9)
            return 880.0
        else if(from == 10 && to == 11)
            return 0.868976241900648
        else if(from == 10 && to == 12)
            return 1.07577513284721E-08
        //nautical miles with others
        else if(from == 11 && to == 0)
            return 1852000000.0
        else if(from == 11 && to == 1)
            return 1852000.0
        else if(from == 11 && to == 2)
            return 185200.0
        else if(from == 11 && to == 3)
            return 1852.0
        else if(from == 11 && to == 4)
            return 1.852
        else if(from == 11 && to == 5)
            return 72913.3858267717
        else if(from == 11 && to == 6)
            return 9314.09720799375
        else if(from == 11 && to == 7)
            return 6076.1154855643
        else if(from == 11 && to == 8)
            return 2025.37182852143
        if(from == 11 && to == 9)
            return 1012.68591426072
        if(from == 11 && to == 10)
            return 1.15077944802354
        if(from == 11 && to == 12)
            return 1.23797991357537E-08
        //astronomical units with others
        else if(from == 12 && to == 0)
            return 1.4959855E+17
        else if(from == 12 && to == 1)
            return 149598550000000.0
        else if(from == 12 && to == 2)
            return 14959855000000.0
        else if(from == 12 && to == 3)
            return 149598550000.0
        else if(from == 12 && to == 4)
            return 149598550.0
        else if(from == 12 && to == 5)
            return 5889706692913.39
        else if(from == 12 && to == 6)
            return 752362546908.7
        else if(from == 12 && to == 7)
            return 490808891076.115
        else if(from == 12 && to == 8)
            return 163602963692.038
        else if(from == 12 && to == 9)
            return 81801481846.0192
        else if(from == 12 && to == 10)
            return 92956229.3704764
        else if(from == 12 && to == 11)
            return 80776754.8596112
        else
            return 1.0
    }

    fun detFactorForce(from: Int, to: Int): Double {
        //Newtons with others
        if(from == 0 && to == 1){
            return 0.224808923655339
        }
        //pounds with others
        else if(from == 1 && to == 0){
            return 4.448222
        } else {
            return 1.0
        }
    }

    fun detFactorEnergy(from: Int, to: Int): Double {
        //joules with others
        if(from == 0 && to == 1){
            return 0.001
        } else if(from == 0 && to == 2){
            return 0.238845896627496
        } else if(from == 0 && to == 3){
            return 0.000238845896627496
        } else if(from == 0 && to == 4){
            return 0.000947816987913438
        } else if(from == 0 && to == 5){
            return 0.737562121169656
        } else if(from == 0 && to == 6){
            return 6.24150947960772E+18
        }
        //kilojoules with others
        else if(from == 1 && to == 0){
            return 1000.0
        } else if(from == 1 && to == 2){
            return 238.845896627496
        } else if(from == 1 && to == 3){
            return 0.238845896627496
        } else if(from == 1 && to == 4){
            return 0.947816987913438
        } else if(from == 1 && to == 5){
            return 737.562121169655
        } else if(from == 1 && to == 6){
            return 6.24150947960772E+21
        }
        //calories with others
        else if(from == 2 && to == 0){
            return 4.1868
        } else if(from == 2 && to == 1){
            return 0.0041868
        } else if(from == 2 && to == 3){
            return 0.001
        } else if(from == 2 && to == 4){
            return 0.00396832016499598
        } else if(from == 2 && to == 5){
            return 3.08802508891311
        } else if(from == 2 && to == 6){
            return 2.61319518892216E+19
        }
        //kilocalories with others
        else if(from == 3 && to == 0){
            return 4186.8
        } else if(from == 3 && to == 1){
            return 4.1868
        } else if(from == 3 && to == 2){
            return 1000.0
        } else if(from == 3 && to == 4){
            return 3.96832016499598
        } else if(from == 3 && to == 5){
            return 3088.02508891311
        }
        //British thermal units with others
        else if(from == 4 && to == 0){
            return 1055.056
        } else if(from == 4 && to == 1){
            return 1.055056
        } else if(from == 4 && to == 2){
            return 251.995796312219
        } else if(from == 4 && to == 3){
            return 0.251995796312219
        } else if(from == 4 && to == 5){
            return 778.169341312772
        } else if(from == 4 && to == 6){
            return 6.585142025517E+21
        }
        //foot-pounds with others
        else if(from == 5 && to == 0){
            return 1.355818
        } else if(from == 5 && to == 1){
            return 0.001355818
        } else if(from == 5 && to == 2){
            return 0.323831565873698
        } else if(from == 5 && to == 3){
            return 0.000323831565873698
        } else if(from == 5 && to == 4){
            return 778.169341312772
        } else if(from == 5 && to == 6){
            return 8.46235089962278E+18
        }
        //electron volts with others
        else if(from == 6 && to == 0){
            return 1.60217653E-19
        } else if(from == 6 && to == 1){
            return 1.60217653E-22
        } else if(from == 6 && to == 2){
            return 3.8267328986338E-20
        } else if(from == 6 && to == 3){
            return 3.8267328986338E-23
        } else if(from == 6 && to == 4){
            return 1.5185701327702E-22
        } else if(from == 6 && to == 5){
            return 1.18170471995504E-19
        } else {
            return 1.0
        }
    }

    fun detFactorArea(from: Int, to: Int): Double {
        //area category, square millimeters with others
        if(from == 0 && to == 1){
            return 0.01
        } else if(from == 0 && to == 2){
            return 1 * Math.pow(10.0, -6.0)
        } else if(from == 0 && to == 3){
            return 1 * Math.pow(10.0, -10.0)
        }else if(from == 0 && to == 4){
            return 1 * Math.pow(10.0, -12.0)
        }else if(from == 0 && to == 5){
            return 0.0015500031000062
        }else if(from == 0 && to == 6){
            return 1.07639104167097*Math.pow(10.0, -5.0)
        }else if(from == 0 && to == 7){
            return 1.19599004630108*Math.pow(10.0, -6.0)
        }else if(from == 0 && to == 8){
            return 2.47105381467165*Math.pow(10.0, -10.0)
        }else if(from == 0 && to == 9){
            return 3.86102158542446*Math.pow(10.0, -13.0)
        }
        //area category, square centimeters with others
        else if(from == 1 && to == 0){
            return 100.0
        } else if(from == 1 && to == 2){
            return 0.0001
        } else if(from == 1 && to == 3){
            return 1 * Math.pow(10.0, -8.0)
        }else if(from == 1 && to == 4){
            return 1 * Math.pow(10.0, -10.0)
        }else if(from == 1 && to == 5){
            return 0.15500031000062
        }else if(from == 1 && to == 6){
            return 0.00107639104167097
        }else if(from == 1 && to == 7){
            return 0.000119599004630108
        }else if(from == 1 && to == 8){
            return 2.47105381467165*Math.pow(10.0, -8.0)
        }else if(from == 1 && to == 9){
            return 3.86102158542446*Math.pow(10.0, -11.0)
        }//area category, square meters with others
        else if(from == 2 && to == 0){
            return 1000000.0
        } else if(from == 2 && to == 1){
            return 10000.0
        } else if(from == 2 && to == 3){
            return 1 * 0.0001
        }else if(from == 2 && to == 4){
            return 1 * Math.pow(10.0, -6.0)
        }else if(from == 2 && to == 5){
            return 1550.0031000062
        }else if(from == 2 && to == 6){
            return 10.7639104167097
        }else if(from == 2 && to == 7){
            return 1.19599004630108
        }else if(from == 2 && to == 8){
            return 0.000247105381467165
        }else if(from == 2 && to == 9){
            return 3.86102158542446*Math.pow(10.0, -7.0)
        } //area category, hectares with others
        else if(from == 3 && to == 0){
            return 10000000000.0
        } else if(from == 3 && to == 1){
            return 100000000.0
        } else if(from == 3 && to == 2){
            return 10000.0
        }else if(from == 3 && to == 4){
            return 1 * 0.01
        }else if(from == 3 && to == 5){
            return 15500031.000062
        }else if(from == 3 && to == 6){
            return 107639.104167097
        }else if(from == 3 && to == 7){
            return 11959.9004630108
        }else if(from == 3 && to == 8){
            return 2.47105381467165
        }else if(from == 3 && to == 9){
            return 0.00386102158542446
        } //area category, square kilometers with others
        else if(from == 4 && to == 0){
            return 1000000000000.0
        } else if(from == 4 && to == 1){
            return 10000000000.0
        } else if(from == 4 && to == 2){
            return 1000000.0
        }else if(from == 4 && to == 3){
            return 100.0
        }else if(from == 4 && to == 5){
            return 1550003100.0062
        }else if(from == 4 && to == 6){
            return 10763910.4167097
        }else if(from == 4 && to == 7){
            return 1195990.04630108
        }else if(from == 4 && to == 8){
            return 247.105381467165
        }else if(from == 4 && to == 9){
            return 0.386102158542446
        } //area category, square inches with others
        else if(from == 5 && to == 0){
            return 645.16
        } else if(from == 5 && to == 1){
            return 6.4516
        } else if(from == 5 && to == 2){
            return 0.00064516
        }else if(from == 5 && to == 3){
            return 6.4516*Math.pow(10.0, -8.0)
        }else if(from == 5 && to == 4){
            return 6.4516*Math.pow(10.0, -10.0)
        }else if(from == 5 && to == 6){
            return 0.00694444444444444
        }else if(from == 5 && to == 7){
            return 0.000771604938271605
        }else if(from == 5 && to == 8){
            return 1.59422507907356E-07
        }else if(from == 5 && to == 9){
            return 2.49097668605244E-10
        } //area category, square feet with others
        else if(from == 6 && to == 0){
            return 92903.04
        } else if(from == 6 && to == 1){
            return 929.0304
        } else if(from == 6 && to == 2){
            return 0.09290304
        }else if(from == 6 && to == 3){
            return 9.290304E-06
        }else if(from == 6 && to == 4){
            return 9.290304E-08
        }else if(from == 6 && to == 5){
            return 144.0
        }else if(from == 6 && to == 7){
            return 0.111111111111111
        }else if(from == 6 && to == 8){
            return 2.29568411386593E-05
        }else if(from == 6 && to == 9){
            return 3.58700642791552E-08
        } //area category, square yards with others
        else if(from == 7 && to == 0){
            return 836127.36
        } else if(from == 7 && to == 1){
            return 8361.2736
        } else if(from == 7 && to == 2){
            return 0.83612736
        }else if(from == 7 && to == 3){
            return 8.3612736E-05
        }else if(from == 7 && to == 4){
            return 8.3612736E-07
        }else if(from == 7 && to == 5){
            return 1296.0
        }else if(from == 7 && to == 7){
            return 9.0
        }else if(from == 7 && to == 8){
            return 0.000206611570247934
        }else if(from == 7 && to == 9){
            return 3.22830578512397E-07
        } //area category, acres with others
        else if(from == 8 && to == 0){
            return 4046856422.4
        } else if(from == 8 && to == 1){
            return 40468564.224
        } else if(from == 8 && to == 2){
            return 4046.8564224
        }else if(from == 8 && to == 3){
            return 0.40468564224
        }else if(from == 8 && to == 4){
            return 0.0040468564224
        }else if(from == 8 && to == 5){
            return 6272640.0
        }else if(from == 8 && to == 6){
            return 43560.0
        }else if(from == 8 && to == 8){
            return 4840.0
        }else if(from == 8 && to == 9){
            return 0.0015625
        } //area category, square miles with others
        else if(from == 9 && to == 0){
            return 2589988110336.0
        } else if(from == 9 && to == 1){
            return 25899881103.36
        } else if(from == 9 && to == 2){
            return 2589988.110336
        }else if(from == 9 && to == 3){
            return 258.9988110336
        }else if(from == 9 && to == 4){
            return 2.589988110336
        }else if(from == 9 && to == 5){
            return 4014489600.0
        }else if(from == 9 && to == 6){
            return 27878400.0
        }else if(from == 9 && to == 7){
            return 3097600.0
        }else if(from == 9 && to == 9){
            return 640.0
        } else {
            //same position
            return 1.0
        }
    }

}