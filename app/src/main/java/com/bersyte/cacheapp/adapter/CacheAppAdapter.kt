package com.bersyte.cacheapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.bersyte.cacheapp.databinding.LayoutAdapterBinding
import com.bersyte.cacheapp.models.CountriesItem

class CacheAppAdapter : Adapter<CacheAppAdapter.CacheAppViewHolder>() {


    inner class CacheAppViewHolder(val binding: LayoutAdapterBinding) :
        ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<CountriesItem>() {
        override fun areItemsTheSame(oldItem: CountriesItem, newItem: CountriesItem): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CountriesItem, newItem: CountriesItem): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var countries: List<CountriesItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CacheAppViewHolder {
        return CacheAppViewHolder(
            LayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CacheAppViewHolder, position: Int) {
        val country = countries[position]

        holder.binding.apply {
            ivFlag.load(country.flag)
            tvName.text = country.name
            tvCapital.text = country.capital
            tvPopulation.text = country.population.toString()
            tvNumericCode.text = country.callingCodes.toString()
        }
    }

    override fun getItemCount() = countries.size

}