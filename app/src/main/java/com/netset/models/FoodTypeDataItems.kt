package com.netset.models

class FoodTypeDataItems(val foodType:String,val meal:String,val calories:String,val nestedFoodTypeList:ArrayList<NestedFoodTypeDataItems>) {

    data  class  NestedFoodTypeDataItems(val background:Int,val foodIcon:Int,val foodNames:String,val times:String)

}