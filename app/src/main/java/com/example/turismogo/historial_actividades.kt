package com.example.turismogo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Excursion(
    val name: String,
    val date: String,
    val rating: String,
    val company: String
)
class historial_actividades : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ExcursionAdapter
    private val excursionList = mutableListOf<Excursion>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_historial_actividades)

        recyclerView = findViewById(R.id.activityRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ExcursionAdapter(excursionList)
        recyclerView.adapter = adapter
        loadExcursionData()

    }
    private fun loadExcursionData() {
        excursionList.add(Excursion("Tour: Chachapoyas día de la madre", "Fecha: 2023-05-25", "Puntuación: 5", "Empresa: Turismo A"))
        excursionList.add(Excursion("Tour: Kuelap día del padre", "Fecha: 2023-05-25", "Puntuación: 4", "Empresa: Turismo A"))
        excursionList.add(Excursion("Tour: Lineas de nazca fiestas patrias", "Fecha: 2023-05-25", "Puntuación: 3", "Empresa: Turismo A"))
        excursionList.add(Excursion("Tour: Machu picchu día del padre", "Fecha: 2023-05-25", "Puntuación: 7", "Empresa: Turismo A"))
        excursionList.add(Excursion("Tour: Ica navidad ", "Fecha: 2023-05-25", "Puntuación: 8", "Empresa: Turismo A"))
        excursionList.add(Excursion("Tour: Callao 28 de julio", "Fecha: 2023-07-28", "Puntuación: 3", "Empresa: Turismo A"))
        adapter.notifyDataSetChanged()
    }
}