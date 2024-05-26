package com.example.turismogo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExcursionAdapter(private val excursionList: List<Excursion>) :
    RecyclerView.Adapter<ExcursionAdapter.ExcursionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcursionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_actividad, parent, false)
        return ExcursionViewHolder(view)
    }
    override fun onBindViewHolder(holder: ExcursionViewHolder, position: Int) {
        val excursion = excursionList[position]
        holder.excursionNameTextView.text = excursion.name
        holder.excursionDateTextView.text = excursion.date
        holder.excursionRatingTextView.text = "Puntuación: ${excursion.rating}"
        holder.excursionCompanyTextView.text = excursion.company
    }
    override fun getItemCount(): Int {
        return excursionList.size
    }
    class ExcursionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val excursionNameTextView: TextView = itemView.findViewById(R.id.excursionNameTextView)
        val excursionDateTextView: TextView = itemView.findViewById(R.id.excursionDateTextView)
        val excursionRatingTextView: TextView = itemView.findViewById(R.id.excursionRatingTextView)
        val excursionCompanyTextView: TextView = itemView.findViewById(R.id.excursionCompanyTextView)
    }
}