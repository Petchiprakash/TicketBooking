package com.example.ticketbooking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val moviesList: ArrayList<Movies>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var mylistener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListner(listener: OnItemClickListener) {
        mylistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v,mylistener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = moviesList[position]
        holder.textTitle.text = currentItem.title
        holder.itemDetail.text = currentItem.titleDescription
        holder.itemImage.setImageResource(currentItem.titleImage)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


    class MyViewHolder(itemView: View,listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.imgItem)
        var textTitle: TextView = itemView.findViewById(R.id.txtTitle)
        var itemDetail: TextView = itemView.findViewById(R.id.tvDescription)
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

}