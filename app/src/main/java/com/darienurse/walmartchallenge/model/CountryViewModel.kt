package com.darienurse.walmartchallenge.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darienurse.walmartchallenge.repository.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {
    private val repository = CountryRepository()
    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCountries { countries ->
                _countries.postValue(countries)
            }
        }
    }
}