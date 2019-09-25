import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val kotlinVersion = "1.3.50"
    val springBootVersion = "2.1.1.RELEASE"

    repositories {
        gradlePluginPortal()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion") // kotlin-spring
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.50"
    id("org.asciidoctor.convert") version "1.5.9.2"
}

apply {
    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("idea")
    plugin("eclipse")
    plugin("application")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
    plugin("org.asciidoctor.gradle.asciidoctor")
}

group = "com.lee"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    compile ("org.springframework.boot:spring-boot-starter-data-redis")
    compile ("org.springframework.data:spring-data-redis")
    compile (group = "redis.clients", name = "jedis", version = "2.9.0")
    compile (group = "it.ozimov", name = "embedded-redis", version = "0.7.1")
    compile (group = "org.springframework", name=  "spring-aop", version = "4.3.18.RELEASE")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile ("io.springfox:springfox-swagger2:2.6.1")
    compile ("io.springfox:springfox-swagger-ui:2.6.1")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("com.fasterxml.jackson.core:jackson-databind:2.9.4")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    compileOnly("org.projectlombok:lombok")

    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile(group = "junit", name = "junit", version = "4.12")
    testCompile(group = "org.assertj", name = "assertj-core", version = "3.12.2")
    testCompile("javax.servlet:javax.servlet-api:3.1.0")

}
