package com.cocktails.presentation.di

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cocktails.databinding.RandomCocktailBinding
import com.cocktails.domain.Cocktail

class Adapter : ListAdapter<Cocktail, Adapter.ViewHolder>(ItemCallback) {

    class ViewHolder(val binding: RandomCocktailBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RandomCocktailBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cocktail = getItem(position)
        holder.binding.apply {
            textCategory.text = cocktail.category
            textAlcoholic.text = cocktail.alcoholic
            textCocktail.text = cocktail.name
            textGlass.text = cocktail.glass
            textTitleInstructions.text = cocktail.instructions
        }
    }

    object ItemCallback : DiffUtil.ItemCallback<Cocktail>() {
        override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem.name == newItem.name
        }

    }
}