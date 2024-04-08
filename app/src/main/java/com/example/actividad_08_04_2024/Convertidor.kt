package com.example.actividad_08_04_2024

class Convertidor {

    var meter : Int = 0
    var feet : Double = 0.0
    var inch : Double = 0.0
    var yard : Double = 0.0

    fun calculateFeet(){
        if(this.meter > 0){
            this.feet = this.meter * 3.28084
        }
    }
    fun calculateYard(){
        if(this.meter > 0){
            this.yard = this.meter * 1.09361
        }
    }
    fun calculateInch(){
        if(this.meter > 0){
            this.inch = this.meter * 39.3701
        }
    }
}