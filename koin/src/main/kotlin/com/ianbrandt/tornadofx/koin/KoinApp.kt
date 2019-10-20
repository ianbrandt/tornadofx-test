package com.ianbrandt.tornadofx.koin

import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import tornadofx.*
import kotlin.reflect.KClass

fun main() {
	launch<KoinApp>()
}

class KoinApp : App(KoinView::class) {
	override fun init() {
		startKoin {
			modules(module {
				single<GreetingService> { HelloKoinGreetingService() }
			})
		}

		FX.dicontainer = object : DIContainer, KoinComponent {
			override fun <T : Any> getInstance(type: KClass<T>): T {
				return getKoin().get(clazz = type, qualifier = null, parameters = null)
			}
		}
	}

	override fun stop() {
		stopKoin()
		super.stop()
	}
}

class KoinView : View() {
	private val greetingService: GreetingService by di()
	override val root = vbox {
		button(greetingService.getGreeting())
	}
}

interface GreetingService {
	fun getGreeting(): String
}

class HelloKoinGreetingService : GreetingService {
	override fun getGreeting(): String {
		return "Hello, Koin!"
	}
}
