pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
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
