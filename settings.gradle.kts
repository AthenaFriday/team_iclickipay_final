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
include(":pet")
include(":delivery")
include(":tinder")
include(":uber")
include(":eat")
