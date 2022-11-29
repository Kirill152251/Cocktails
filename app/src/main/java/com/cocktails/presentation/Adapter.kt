package com.cocktails.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
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
            textInstructions.text = cocktail.instructions
            textIngredients.text = cocktail.ingredients
            imageCocktail.load(cocktail.imageUrl) {
                listener(
                    onStart = {
                        holder.binding.progressBarImage.isVisible = true
                    },
                    onSuccess = { _, _ ->
                        holder.binding.progressBarImage.isVisible = false
                    }
                )
            }
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