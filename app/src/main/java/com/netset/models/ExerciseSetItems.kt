package com.netset.models

data  class ExerciseSetItems(
    val exerciseSets:String,
    val childList:ArrayList<NestedExerciseSetsItems>) {

    data  class  NestedExerciseSetsItems(val exerciseIcon:Int,val exerciseNames:String,val times:String)

}