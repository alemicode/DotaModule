package com.mohamadalemicode.interactors

import com.mohamadalemicode.data_source.cache.HeroCache
import com.mohamadalemicode.data_source.network.HeroService
import com.squareup.sqldelight.db.SqlDriver

class HeroInteractors(
    val getHeros: GetHeros
) {
    companion object Factory {
        fun build(sqlDriver: SqlDriver): HeroInteractors {
            val service = HeroService.build()
            val cache = HeroCache.build(sqlDriver)
            return HeroInteractors(
                getHeros = GetHeros(
                    cache = cache,
                    service = service
                )
            )
        }

        val schema: SqlDriver.Schema = HeroCache.schema

        val dbName: String = HeroCache.dbName

    }


}