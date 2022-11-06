package com.example.a15daystry.Controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a15daystry.Activity.MainActivity
import com.example.a15daystry.R
import com.example.a15daystry.ViewModel.EntriesItem

class RVSetup(val activity: MainActivity, val Info: ArrayList<EntriesItem>) :
    RecyclerView.Adapter<RVSetup.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.temp, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.text.setText(Info.get(position).description)

    }

    override fun getItemCount(): Int {
        return Info.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var text = itemView.findViewById<TextView>(R.id.Text1)

    }

}