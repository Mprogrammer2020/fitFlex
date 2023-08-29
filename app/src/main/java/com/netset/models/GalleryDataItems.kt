package com.netset.models

data class GalleryDataItems(val dayMonth:String,val nestedGalleryList:ArrayList<NestedGalleryDataItems>) {

    data  class  NestedGalleryDataItems(val galleryImage:Int)

}