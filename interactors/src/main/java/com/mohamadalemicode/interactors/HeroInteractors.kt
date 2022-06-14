package com.mohamadalemicode.interactors

import com.codingwithmitch.hero_datasource.network.HeroService

class HeroInteractors(
    val getHeros: GetHeros
) {
    companion object Factory {
        fun build(): HeroInteractors {
            val service = HeroService.build()
            return HeroInteractors(
                getHeros = GetHeros(
                    service
                )
            )

        }
    }



}