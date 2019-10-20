import org.gradle.api.JavaVersion.VERSION_1_8
import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.3.50"
	id("com.github.ben-manes.versions") version "0.27.0"
}

allprojects {
	repositories {
		mavenCentral()
		jcenter()
	}
}

subprojects {
	apply(plugin = "kotlin")
	dependencies {
		val junitVersion = "5.5.2"

		implementation(kotlin("stdlib-jdk8"))
		implementation(kotlin("reflect"))
		implementation("no.tornado:tornadofx:1.7.19")
		testImplementation("org.assertj:assertj-core:3.13.2")
		testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
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
	}
}

tasks {
	named<Wrapper>("wrapper") {
		gradleVersion = "5.6.3"
		distributionType = Wrapper.DistributionType.ALL
	}
}
