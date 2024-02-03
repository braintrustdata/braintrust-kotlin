plugins {
    id("braintrust.kotlin")
    id("braintrust.publish")
}

dependencies {
    api(project(":braintrust-kotlin-client-okhttp"))
}
