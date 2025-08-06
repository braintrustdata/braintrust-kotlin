plugins {
    id("braintrust.kotlin")
    application
}

dependencies {
    implementation(project(":braintrust-kotlin"))
}

application {
    // Use `./gradlew :braintrust-kotlin-example:run` to run `Main`
    // Use `./gradlew :braintrust-kotlin-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.braintrustdata.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}ExampleKt"
        else
            "MainKt"
    }"
}
