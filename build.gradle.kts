import org.gradle.api.JavaVersion.*
import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.3.31"
	id("com.github.ben-manes.versions") version "0.21.0"
}

repositories {
	mavenCentral()
	jcenter()
}

dependencies {
	val junitVersion = "5.4.2"

	implementation(kotlin("stdlib"))
	implementation(kotlin("stdlib-jdk8"))
	implementation(kotlin("reflect"))
	implementation("no.tornado:tornadofx:1.7.19")
	testImplementation("org.assertj:assertj-core:3.12.2")
	testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
	testImplementation("io.mockk:mockk:1.9.3")
	testImplementation("org.testfx:testfx-junit5:4.0.15-alpha")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

java {
	sourceCompatibility = VERSION_1_8
	targetCompatibility = VERSION_1_8
}

tasks {

	withType<KotlinCompile> {
		kotlinOptions.jvmTarget = VERSION_1_8.toString()
	}

	withType<Test> {
		useJUnitPlatform()
		testLogging {
			showStandardStreams = true
			events(PASSED, SKIPPED, FAILED, STANDARD_OUT, STANDARD_ERROR)
		}
	}

	getByName<Wrapper>("wrapper") {
		gradleVersion = "5.4.1"
		distributionType = Wrapper.DistributionType.ALL
	}
}
