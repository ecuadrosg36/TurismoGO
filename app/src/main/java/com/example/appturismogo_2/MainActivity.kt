package com.example.appturismogo_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appturismogo_2.Fragmentos.FragmentChat
import com.example.appturismogo_2.Fragmentos.FragmentCuenta
import com.example.appturismogo_2.Fragmentos.FragmentInicio
import com.example.appturismogo_2.Fragmentos.FragmentMisAnuncios
import com.example.appturismogo_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        verFragmentInicio()
        binding.BottomNV.setOnNavigationItemSelectedListener {
            item-> when (item.itemId){
                R.id.Item_Inicio->{
                    verFragmentInicio()
                    true
                }
                R.id.Item_Chat->{
                    verFragmentChat()
                    true
                }
                R.id.Item_Anuncios->{
                    verFragmentAnuncios()
                    true
                }
                R.id.Item_Cuenta->{
                    verFragmentCuenta()
                    true
                }
            else->{
                false
            }
            }
        }

    }

    private fun verFragmentInicio(){
        binding.TituloRL.text = "Inicio"
        val fragment = FragmentInicio()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id,fragment,"FragmentInicio")
        fragmentTransition.commit()

    }
    private fun verFragmentAnuncios(){
        binding.TituloRL.text = "Anuncios"
        val fragment = FragmentMisAnuncios()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id,fragment,"FragmentAnuncios")
        fragmentTransition.commit()

    }
    private fun verFragmentChat(){
        binding.TituloRL.text = "Chat"
        val fragment = FragmentChat()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id,fragment,"FragmentChat")
        fragmentTransition.commit()

    }
    private fun verFragmentCuenta(){
        binding.TituloRL.text = "Cuenta"
        val fragment = FragmentCuenta()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id,fragment,"FragmentCuenta")
        fragmentTransition.commit()

    }
}

