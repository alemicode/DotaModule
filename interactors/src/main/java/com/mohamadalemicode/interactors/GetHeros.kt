package com.mohamadalemicode.interactors

import com.mohamadalemicode.core.core.domain.DataState
import com.mohamadalemicode.core.core.domain.ProgressBarState
import com.mohamadalemicode.data_source.cache.HeroCache
import com.mohamadalemicode.data_source.network.HeroService
import com.mohamadalemicode.domain.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHeros(

    private val cache: HeroCache,
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

            // insert the netowrk data
            cache.insert(heros)

            val cacheHeros = cache.selectAll()



            emit(
                DataState.Data(
                    data = cacheHeros
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