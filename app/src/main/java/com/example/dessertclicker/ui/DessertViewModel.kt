package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel:ViewModel() {
    private val _dessertuiState = MutableStateFlow(DessertUiState())
    val dessertUiState :StateFlow<DessertUiState> = _dessertuiState.asStateFlow()

    private fun determineDessertIndex (dessertSold:Int):Int {
        var dessertIndex = 0
        for(index in dessertList.indices){
            if(dessertSold >= dessertList[index].startProductionAmount){
                dessertIndex = index
            }
            else{
                break
            }
        }
        return dessertIndex
    }
    fun onDessertClicked(){
        //image//dessertsold//revenue
        _dessertuiState.update {cupcakeuiState->
            val dessertSold = cupcakeuiState.dessertsold + 1
            val nextDessertIndex = determineDessertIndex(dessertSold)
            cupcakeuiState.copy(
                currentdessertIndex = nextDessertIndex,
                revenue = cupcakeuiState.revenue + cupcakeuiState.currentdessertprice,
                dessertsold = dessertSold,
                currentdesserImage = dessertList[nextDessertIndex].imageId,
                currentdessertprice = dessertList[nextDessertIndex].price
            )


        }
    }


}

