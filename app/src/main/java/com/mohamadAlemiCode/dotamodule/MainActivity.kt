package com.mohamadAlemiCode.dotamodule

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.mohamadalemicode.core.core.domain.DataState
import com.mohamadalemicode.interactors.HeroInteractors
import com.squareup.sqldelight.android.AndroidSqliteDriver
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

        val getHeros = HeroInteractors.build(

            sqlDriver = AndroidSqliteDriver(
                schema = HeroInteractors.schema,
                context = this,
                name = HeroInteractors.dbName

            )
        ).getHeros

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