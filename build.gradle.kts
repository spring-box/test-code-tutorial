plugins {
    java
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

allprojects {
    group = "io.springbox"
    version = "0.0.1-SNAPSHOT"

    repositories { mavenCentral() }

    tasks.withType<Test> { useJUnitPlatform() }
}

subprojects {
    apply(plugin = "java")

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.30")
        annotationProcessor("org.projectlombok:lombok:1.18.30")
    }
}
