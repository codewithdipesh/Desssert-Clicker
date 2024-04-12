package com.example.dessertclicker.ui

import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource.dessertList

data class DessertUiState(
    val currentdessertIndex:Int = 0,
    val dessertsold :Int = 0,
    val revenue:Int =0,
    val currentdessertprice: Int = dessertList[currentdessertIndex].price,
    @DrawableRes val currentdesserImage: Int = dessertList[currentdessertIndex].imageId
){}
