package com.example.ticketbooking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var title = listOf("Maanaadu","Annaatthe","Master")
    private var details = listOf("Tamil U/A","Tamil U","Tamil U/A")
    private val images = listOf(R.drawable.maanaadu_vp,R.drawable.annaathae,R.drawable.master)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = title[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var textTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.imgItem)
            textTitle = itemView.findViewById(R.id.txtTitle)
            itemDetail = itemView.findViewById(R.id.tvDescription)

            itemView.setOnClickListener{
                val position: Int = adapterPosition
                Toast.makeText(itemView.context,"You have chosen ${title[position]}",Toast.LENGTH_LONG).show()
            }
        }
    }

}