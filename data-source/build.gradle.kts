apply {
    from("$rootDir/library-build.gradle")
}


plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id(SqlDelight.plugin)

}

dependencies {
    "implementation"(project(Modules.heroDomain))

    "implementation"(Ktor.core)
    "implementation"(Ktor.clientSerialization)
    "implementation"(Ktor.android)

    "implementation"(SqlDelight.runtime)

}
sqldelight {

    database("HeroDatabase") {

        packageName = "com.mohamadalemicode.data_source.cache"
        sourceFolders = listOf("sqldelight")
    }
}