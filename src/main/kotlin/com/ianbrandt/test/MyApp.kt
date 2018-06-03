package com.ianbrandt.test

import javafx.application.Application
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import tornadofx.App
import tornadofx.View

fun main(args: Array<String>) {
	Application.launch(MyApp::class.java, *args)
}

class MyApp : App(MyView::class)

class MyView : View() {
	override val root = VBox()

	init {
		root += Button("Press Me")
	}
}
