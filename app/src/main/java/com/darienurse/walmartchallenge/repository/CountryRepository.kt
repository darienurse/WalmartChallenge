package com.darienurse.walmartchallenge.repository

import com.darienurse.walmartchallenge.model.Country
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

class CountryRepository {
    fun getCountries(callback: (List<Country>) -> Unit) {
        val jsonString =
            URL("https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
                .readText()

        val countriesType = object : TypeToken<List<Country>>() {}.type
        val countries = Gson().fromJson<List<Country>>(jsonString, countriesType)

        callback(countries)
    }
}