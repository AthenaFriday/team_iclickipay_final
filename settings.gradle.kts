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
include(":chat")
include(":pc_repair")
include(":learn")
include(":handyman")
include(":ibank")
include(":tinder")
include(":uber")
include(":eat")
include(":pet")
include(":delivery")
