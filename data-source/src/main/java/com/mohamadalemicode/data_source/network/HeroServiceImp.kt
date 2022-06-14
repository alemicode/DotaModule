package com.mohamadalemicode.data_source.network

import com.codingwithmitch.hero_datasource.network.EndPoints
import com.codingwithmitch.hero_datasource.network.HeroService
import com.codingwithmitch.hero_domain.Hero
import com.mohamadalemicode.data_source.network.model.HeroDto
import com.mohamadalemicode.data_source.network.model.toHero
import io.ktor.client.*
import io.ktor.client.request.*
import kotlin.text.get

class HeroServiceImp
constructor(
    private val httpClient: HttpClient

) : HeroService {
    override suspend fun getHeroStats(): List<Hero> {

        return httpClient.get<List<HeroDto>> {

            url(EndPoints.HERO_STATS)
        }.map {
            it.toHero()

        }


    }

}