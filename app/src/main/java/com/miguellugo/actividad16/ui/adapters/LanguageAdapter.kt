package com.miguellugo.actividad16.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguellugo.actividad16.databinding.ItemListLanguagesBinding
import com.miguellugo.actividad16.model.Language

class LanguageAdapter(private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<LanguageAdapter.MyViewHolder>() {
    private var itemList = emptyList<Language>()

    interface OnItemClickListener {
        fun onLanguageClick(language: Language)
    }

    inner class MyViewHolder(private val binding: ItemListLanguagesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(language: Language) {
            binding.apply {
                tvName.text = language.name
                Glide.with(this.root).load(language.image).into(ivLanguage)
            }
            binding.root.setOnClickListener {
                onItemClickListener.onLanguageClick(language)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemListLanguagesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bindView(currentItem)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setData(itemList: List<Language>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}