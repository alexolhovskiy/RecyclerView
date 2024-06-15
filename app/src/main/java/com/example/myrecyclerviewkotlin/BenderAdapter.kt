package com.example.myrecyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerviewkotlin.databinding.BenderItemBinding

class BenderAdapter: RecyclerView.Adapter<BenderAdapter.BenderHolder>() {

    val benderList=ArrayList<Bender>()


    class BenderHolder(item: View): RecyclerView.ViewHolder(item){
        val binding=BenderItemBinding.bind(item)
        fun bind(bender:Bender)=with(binding){
            imgView.setImageResource(bender.imgId)
            tvTitle.text=bender.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenderHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.bender_item,parent,false)
        return BenderHolder(view)
    }

    override fun getItemCount(): Int {
        return benderList.size
    }

    override fun onBindViewHolder(holder: BenderHolder, position: Int) {
        holder.bind(benderList[position])
    }

    fun addBender(bender:Bender){
        benderList.add(bender)
        notifyDataSetChanged()
    }
}