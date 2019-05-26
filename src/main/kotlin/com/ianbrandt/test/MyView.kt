package com.ianbrandt.test

import tornadofx.*

class MyView : View() {
	companion object {
		const val BUTTON_ID = "test-button"
		const val INITIAL_BUTTON_TEXT = "Test"
		const val CHANGED_BUTTON_TEXT = "Success"
	}
	override val root = vbox {
		button(INITIAL_BUTTON_TEXT) {
			id = BUTTON_ID
			action {
				text = CHANGED_BUTTON_TEXT
			}
		}
	}
}
