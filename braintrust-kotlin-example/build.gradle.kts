plugins {
    id("braintrust.kotlin")
    application
}

dependencies {
    implementation(project(":braintrust-kotlin"))
}

application {
    mainClass = "com.braintrustdata.api.example.MainKt"
}
