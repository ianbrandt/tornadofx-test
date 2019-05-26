package com.ianbrandt.test

import tornadofx.*

class MyView : View() {
	override val root = vbox {
		button("Test") {
			id = "test-button"
			action {
				println("TEST ACTION")
			}
		}
	}
}
