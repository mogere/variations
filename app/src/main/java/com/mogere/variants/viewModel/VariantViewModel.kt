package com.mogere.variants.viewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mogere.variants.Entity.Product
import com.mogere.variants.MainActivity
import com.mogere.variants.network.VariantsApi
import com.mogere.variants.network.VariantsApiService
import com.mogere.variants.repository.FakeVariantRepo
import kotlinx.coroutines.launch


class VariantViewModel: ViewModel(), Observable {

    private var product : MutableLiveData<Product> = FakeVariantRepo._currentProduct


    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    @Bindable
    val variations = MutableLiveData<String>()

    @Bindable
    val heading = MutableLiveData<String>()

    @Bindable
    val price = MutableLiveData<String>()

    @Bindable
    val variationList = MutableLiveData<String>()


    var mainActivity = MainActivity()
    var variant = MutableLiveData<String>()





    fun setValues(){
        heading.value = product.value?.name
        variant.value = mainActivity.variantEntered
    }
    fun onButtonClicked(){

        variationList.value = variations.value
    }





    fun sendVariants(newProduct: Product){

        viewModelScope.launch{
            try{
                FakeVariantRepo.sendVariants(newProduct)

            }catch(e:Error){

            }
        }
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

}