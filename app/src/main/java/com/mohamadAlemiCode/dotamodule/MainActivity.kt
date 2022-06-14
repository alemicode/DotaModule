package com.mohamadAlemiCode.dotamodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.hero_domain.Hero
import com.mohamadalemicode.interactors.HeroInteractors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : ComponentActivity() {


    lateinit var tv_title: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_title = findViewById(R.id.tv_title)
        val getHeros = HeroInteractors.build().getHeros
        getHeros.execute().onEach { dataState ->
            when (dataState) {
                is DataState.Response -> {

                }
                is DataState.Data -> {
                    dataState.data?.let {
                        for (i in it) {

                            Log.i("gsfdg", "onCreate: fsdafsad ${i.baseAgi}")


                        }
                        }
                    }


                else -> {}
            }

        }.launchIn(CoroutineScope(IO))
    }
}