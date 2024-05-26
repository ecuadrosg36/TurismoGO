package com.example.turismogo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Excursion2(
    val name: String,
    val telephone: String,
    val dni: String,
    val tour: String,
    val date: String,
    val rating: String

)
class historial_usuarios : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HistoryUserAdapter
    private val excursionList2 = mutableListOf<Excursion2>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_historial_usuarios)

        recyclerView = findViewById(R.id.activityRecyclerView2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HistoryUserAdapter(excursionList2)
        recyclerView.adapter = adapter
        loadExcursionData()
    }
    private fun loadExcursionData() {
        excursionList2.add(Excursion2("Nombre: jesus","Telefono: 984883137","Dni: 7777777","Tour: chachapoyas","Fecha: 24/08/24","Puntuación: 4"))
        excursionList2.add(Excursion2("Nombre: miguel","Telefono: 984883137","Dni: 7777777","Tour: chachapoyas","Fecha: 24/08/24","Puntuación: 4"))
        excursionList2.add(Excursion2("Nombre: juan","Telefono: 984883137","Dni: 7777777","Tour: chachapoyas","Fecha: 24/08/24","Puntuación: 4"))
        excursionList2.add(Excursion2("Nombre: jean","Telefono: 984883137","Dni: 7777777","Tour: chachapoyas","Fecha: 24/08/24","Puntuación: 4"))
        excursionList2.add(Excursion2("Nombre: jilmar","Telefono: 984883137","Dni: 7777777","Tour: chachapoyas","Fecha: 24/08/24","Puntuación: 4"))
    }
}