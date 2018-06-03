package com.ianbrandt.test

import tornadofx.*

fun main(args: Array<String>) {
	launch<MyApp>(args)
}

class MyApp : App(MyView::class)

class MyView : View() {
	override val root = vbox {
		label("Hello, World!")
	}
}
