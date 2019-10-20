package com.ianbrandt.tornadofx.koin

import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import tornadofx.*

fun main() {
	launch<KoinApp>()
}

class KoinApp : App(KoinView::class) {
	override fun init() {
		startKoin {
			modules(module {})
		}

		// Does not compile: "Cannot use 'T' as reified type parameter..."
//		FX.dicontainer = object : DIContainer, KoinComponent {
//			override fun <T : Any> getInstance(type: KClass<T>): T {
//				return get(TypeQualifier(type))
//			}
//		}
	}

	override fun stop() {
		stopKoin()
		super.stop()
	}
}

class KoinView : View() {
	override val root = vbox {
		label("Hello, Koin!")
	}
}
