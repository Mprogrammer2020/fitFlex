package com.netset.models

data  class PhotoResultDataItems(
    val type:String,
    val childList:ArrayList<NestedPhotoResultDataItems>) {

    data  class  NestedPhotoResultDataItems(val photoImage:Int)

}