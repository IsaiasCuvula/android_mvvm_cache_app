package com.bersyte.cacheapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.bersyte.cacheapp.R
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

        holder.apply {
            itemView.apply {

                val imageLoader = ImageLoader.Builder(context)
                    .componentRegistry {
                        add(SvgDecoder(context))
                    }.build()
                holder.binding.ivFlag.load(country.flag, imageLoader) {
                    crossfade(true)
                    crossfade(1000)
                }


                binding.apply {
                    country.apply {
                        context.resources.apply {
                            tvName.text =
                                getString(
                                    R.string.country,
                                    name
                                )

                            tvCapital.text =
                                getString(
                                    R.string.capital,
                                    capital
                                )

                            tvPopulation.text =
                                getString(
                                    R.string.population,
                                    population.toString()
                                )

                            tvNumericCode.text = ""
                            // getString(R.string.code,
                            //callingCodes)
                        }
                    }
                }
            }
        }
    }

    override fun getItemCount() = countries.size

}
