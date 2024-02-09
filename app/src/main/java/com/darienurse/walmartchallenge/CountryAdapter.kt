package com.darienurse.walmartchallenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.darienurse.walmartchallenge.model.Country

class CountryAdapter :
    ListAdapter<Country, CountryAdapter.CountryViewHolder>(CountryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country)
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val countryNameTextView: TextView = itemView.findViewById(R.id.countryNameTextView)
        private val countryCodeTextView: TextView = itemView.findViewById(R.id.countryCodeTextView)
        private val capitalTextView: TextView = itemView.findViewById(R.id.capitalTextView)

        fun bind(country: Country) {
            countryNameTextView.text =
                itemView.resources.getString(R.string.country_name, country.name, country.region)
            countryCodeTextView.text = country.code
            capitalTextView.text = country.capital
        }
    }

    class CountryDiffCallback : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }
    }
}