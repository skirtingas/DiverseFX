import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "2.1.20-Beta2"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "net.starfal"
version = "1.5"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
    compileOnly("de.exlll:configlib-yaml:4.5.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("dev.jorel:commandapi-bukkit-shade:9.7.0")
}
tasks.withType<ShadowJar> {
    relocate("dev.jorel.commandapi", "net.starfal.commandapi")
}

val targetJavaVersion = 17
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}
