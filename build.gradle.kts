import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "dev.mrshawn"
version = "1.0.0"
extra["apiVersion"] = "1.21"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://repo.aikar.co/content/groups/aikar/")
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compileOnly("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT")
    implementation("dev.mrshawn:Mlib:0.0.204")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.processResources {
    filesMatching("plugin.yml") {
        expand(mapOf("version" to version, "apiVersion" to project.extra["apiVersion"]))
    }
}

tasks.withType<ShadowJar> {
    archiveFileName.set("${project.name}-${project.version}.jar")
    mergeServiceFiles()
    relocate("dev.mrshawn.mlib", "${project.group}.shade.mlib")
    relocate("kotlin", "${project.group}.shade.kotlin")
}
