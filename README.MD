# SpringBoot-Kotlin-Redis Example

This project is an example of SpringBoot Data Redis by using Kotlin.<br>
기존 Java로 되어있던 프로젝트를 Kotlin으로 변경한 개인 프로젝트 입니다.

# Technologies

* [kotlin 1.3.50](https://kotlinlang.org/)
* [embedded gradle](https://gradle.org/)
* [spring-boot](http://projects.spring.io/spring-boot/)

# Redis library
**build.gradle**

```groovy
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion") // kotlin-spring
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    }
    
    ...

    compile ("org.springframework.boot:spring-boot-starter-data-redis")
    compile ("org.springframework.data:spring-data-redis")
    compile (group = "redis.clients", name = "jedis", version = "2.9.0")
    compile (group = "it.ozimov", name = "embedded-redis", version = "0.7.1")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
```

# How to run
You can test by using curl, URL, Swagger.

**Curl**
```groovy
    curl -X GET --header 'Accept: application/json' 'http://localhost:8081/api/user/userid'
```

**Request URL**
```groovy
    http://localhost:8081/api/user
    http://localhost:8081/api/user/userid
```

**Swagger**
```groovy
    http://localhost:8081/swagger-ui.html
```

<br>
&nbsp;&nbsp;&nbsp; Screenshot
<div>
    <img src="https://user-images.githubusercontent.com/16321663/65635387-2f12a280-e01b-11e9-8339-b55d22fedae2.png" width="75%"></img>
</div>
<br>

# How to run test
The repository contains some test cases to cover both api test and repository test.

    ./gradlew test
