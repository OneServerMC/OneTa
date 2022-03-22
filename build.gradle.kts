import org.apache.tools.ant.filters.ReplaceTokens
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm")
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "org.oneserver"

repositories {
    // Maven Central
    mavenCentral()

    // Sonatype
    maven { url = uri("https://oss.sonatype.org/content/groups/public/") }

    // Paper
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }

    // JitPack
    maven { url = uri("https://jitpack.io") }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

application {
    mainClassName = "org.oneserver.oneta.OneTaKt"
}

tasks.withType<ShadowJar> {
    archiveFileName.set("OneTa.jar")
}

tasks.compileKotlin {
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.processResources {
    filteringCharset = "UTF-8"
    from(sourceSets["main"].resources.srcDirs) {
        include("**/*.yml")
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
        filter<ReplaceTokens>("tokens" to mapOf("version" to "0.1.0"))
        filter<ReplaceTokens>("tokens" to mapOf("name" to project.name))
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.hazae41:mc-kutils:master-SNAPSHOT")
    compileOnly("io.github.waterfallmc:waterfall-api:1.18-R0.1-SNAPSHOT")
}