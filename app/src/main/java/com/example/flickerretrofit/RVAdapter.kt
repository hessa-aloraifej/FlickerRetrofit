package com.example.flickerretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter(var list: List<Photo>):  RecyclerView.Adapter<RVAdapter.ItemViewHolder>(){



    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var data = list[position]

        holder.itemView.apply {
       tv.text = "${data.title}"
            Glide.with(holder.itemView.context)
                .load("https://live.staticflickr.com/${data.server}/${data.id}_${data.secret}_s.jpg")
                .into(img)

        }
    }

    override fun getItemCount() = list.size

//    fun update(notes: List<Note>){
//        this.notes = notes
//        notifyDataSetChanged()
//    }

}