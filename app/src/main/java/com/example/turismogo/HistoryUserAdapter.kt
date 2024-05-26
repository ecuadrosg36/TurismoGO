package com.example.turismogo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryUserAdapter(private val excursionList: List<Excursion2>) :
    RecyclerView.Adapter<HistoryUserAdapter.ExcursionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcursionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_actividad2, parent, false)
        return ExcursionViewHolder(view)
    }
    override fun onBindViewHolder(holder: ExcursionViewHolder, position: Int) {
        val excursion = excursionList[position]
        holder.excursionNameTextView.text = excursion.name
        holder.excursionTelephoneTextView.text = excursion.telephone
        holder.excursionDniTextView.text = excursion.dni
        holder.excursionTourTextView.text = excursion.tour
        holder.excursionDateTextView.text = excursion.date
        holder.excursionRatingTextView.text = "Puntuación: ${excursion.rating}"
    }
    override fun getItemCount(): Int {
        return excursionList.size
    }
    class ExcursionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val excursionNameTextView: TextView = itemView.findViewById(R.id.excursionNameTextView)
        val excursionTelephoneTextView: TextView = itemView.findViewById(R.id.excursionTelephoneTextView)
        val excursionDniTextView: TextView = itemView.findViewById(R.id.excursionDniTextView)
        val excursionTourTextView: TextView = itemView.findViewById(R.id.excursionTourTextView)
        val excursionDateTextView: TextView = itemView.findViewById(R.id.excursionDateTextView)
        val excursionRatingTextView: TextView = itemView.findViewById(R.id.excursionRatingTextView)

    }
}