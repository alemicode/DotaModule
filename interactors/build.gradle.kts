apply {
    from("$rootDir/library-build.gradle")
}

dependencies {


    "implementation"(project(Modules.heroDataSource))
    "implementation"(project(Modules.heroDomain))
    "implementation"(project(Modules.heroDomain))
    "implementation"(Kotlinx.coroutinesCore)
    "implementation"(project(Modules.core))


}