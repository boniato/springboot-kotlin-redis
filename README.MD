# SpringBoot-Kotlin-Redis Example

This project is an example of SpringBoot Data Redis by using Kotlin.<br>
기존 Java로 되어있던 프로젝트(https://github.com/boniato/springboot-data-redis) 를 Kotlin으로 변경한 개인 프로젝트 입니다.

# Technologies

* [kotlin 1.3.50](https://kotlinlang.org/)
* [build.gradle.kts](https://gradle.org/)
* [spring-boot 2](http://projects.spring.io/spring-boot/)

#kotlin library
**build.gradle**

```groovy
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion") // kotlin-spring
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    }
```

# How to run
You can test it by using curl, URL, Swagger.

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
