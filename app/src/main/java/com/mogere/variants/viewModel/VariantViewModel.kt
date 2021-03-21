package com.mogere.variants.viewModel

import android.view.View
import android.widget.RadioButton
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mogere.variants.Entity.Product
import com.mogere.variants.MainActivity
import com.mogere.variants.R
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
    var variationList : String = variations.toString()


    private var sizes = mutableMapOf<String, Double>()

    init{
        setValues()
    }


    fun setValues(){
        heading.value = product.value?.name
    }

    fun onButtonClicked(){
        sizes.put(variations.value.toString(), price.value.toString().toDouble())
        println(variations.value.toString() + price.value.toString().toDouble())
        variationList += variations.value.toString()

    }

    fun sendVariants(){

        product.value?.size = this.sizes

        viewModelScope.launch{
            try{
                FakeVariantRepo.sendVariants(product.value!!)

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