apply {
    from("$rootDir/android-library-build.gradle")
}
apply(plugin = "org.jetbrains.kotlin.android")

dependencies {

    "implementation"(project(Modules.core))
    "implementation"(project(Modules.heroDomain))
    "implementation"(project(Modules.heroInteractors))
    "implementation"(SqlDelight.androidDriver)
}