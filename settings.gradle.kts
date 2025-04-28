pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()         // <-- required for Kotlin Compose Plugin!
        gradlePluginPortal()   // <-- required for Kotlin Compose Plugin!
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "IclickIpay"
include(":app")
include(":chatCarlos")
include(":pcRepairCarlos")
include(":learnSimadri")
include(":handymanSimardri")
include(":ibankJack")
include(":petDonna")
include(":deliveryDonna")
include(":tinderJerome")
include(":uberJerome")
include(":eatJack")
