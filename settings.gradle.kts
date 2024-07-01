pluginManagement {
    repositories {
//        google {
//            content {
//                includeGroupByRegex("com\\.android.*")
//                includeGroupByRegex("com\\.google.*")
//                includeGroupByRegex("androidx.*")
//            }
//        }
//        mavenCentral()
//        gradlePluginPortal()

        maven (
            url =  "https://maven.google.com"
        )
        maven (
            url =  "https://jitpack.io"
        )
        maven (
            url =  "https://maven.fabric.io/public"
        )
        maven (
            url =   "https://jcenter.bintray.com"
        )
        maven (
            url =  "https://mvnrepository.com/"
        )
        maven (
            url =  "https://maven.fabric.io/public"
        )
        maven ( url =  "https://nexus.prod.uci.cu/repository/maven-all/")
        maven (
            url =   "https://repo1.maven.org/maven2/"
        )
        maven ( url =  "https://central.maven.org/maven2/" )
        maven ( url =  "https://nexus.xebialabs.com/nexus/content/repositories/public/" )
        maven (
            url =  "https://repo.maven.apache.org/maven2/"
        )
        maven (
            url =  "https://uk.maven.org/maven2/"
        )
        maven (
            url =   "https://dl.bintray.com/derlin/maven"
        )
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
//        google()
//        mavenCentral()

        maven (
            url =  "https://maven.google.com"
        )
        maven (
            url =  "https://jitpack.io"
        )
        maven (
            url =  "https://maven.fabric.io/public"
        )
        maven (
            url =   "https://jcenter.bintray.com"
        )
        maven (
            url =  "https://mvnrepository.com/"
        )
        maven (
            url =  "https://maven.fabric.io/public"
        )
        maven ( url =  "https://nexus.prod.uci.cu/repository/maven-all/")
        maven (
            url =   "https://repo1.maven.org/maven2/"
        )
        maven ( url =  "https://central.maven.org/maven2/" )
        maven ( url =  "https://nexus.xebialabs.com/nexus/content/repositories/public/" )
        maven (
            url =  "https://repo.maven.apache.org/maven2/"
        )
        maven (
            url =  "https://uk.maven.org/maven2/"
        )
        maven (
            url =   "https://dl.bintray.com/derlin/maven"
        )
    }
}

rootProject.name = "RemesitaDevApp"
include(":app")
 