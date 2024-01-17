package com.pruebas.kotlinDesdeCero.todoapp

data class Task (val name:String, val category: TaskCategory, var isSelected:Boolean = false)