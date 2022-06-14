package com.mohamadalemicode.interactors

import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.core.util.Logger
import com.codingwithmitch.hero_datasource.network.HeroService
import com.codingwithmitch.hero_domain.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHeros(
    private val service: HeroService
) {
    fun execute(): Flow<DataState<List<Hero>>> = flow {
        try {

            emit(
                DataState.Loading(ProgressBarState.Loading)
            )
            val heros = try {
                service.getHeroStats()
            } catch (e: Exception) {
                emit(
                    DataState.Response<List<Hero>>(
                        UIComponent.Dialog(
                            title = "Network Data Error",
                            description = "${e.printStackTrace()}"
                        )
                    )
                )
                listOf()
            }

            emit(
                DataState.Data(
                    data = heros
                )
            )

        } catch (e: Exception) {

            e.printStackTrace()
            emit(
                DataState.Response<List<Hero>>(
                    uiComponent = UIComponent.Dialog(
                        title = "Error",
                        description = e.message ?: "Unknown Error"
                    )
                )
            )
        } finally {

            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }

    }

}