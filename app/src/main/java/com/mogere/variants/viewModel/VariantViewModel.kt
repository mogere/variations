package com.mogere.variants.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mogere.variants.Entity.Product
import kotlinx.coroutines.launch


class VariantViewModel: ViewModel() {

    private lateinit var product:Product

    private var _variant = MutableLiveData<List<String>>()

    val variant :LiveData<List<String>>
        get()=_variant



    fun onButtonClicked(){


    }


    fun sendVariants(){

        viewModelScope.launch{
            try{

            }catch(e:Error){

            }
        }
    }

}