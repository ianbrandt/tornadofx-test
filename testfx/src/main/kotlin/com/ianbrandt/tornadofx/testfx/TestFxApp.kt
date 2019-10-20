package com.ianbrandt.tornadofx.testfx

import tornadofx.*

fun main() {
	launch<TestFxApp>()
}

class TestFxApp : App(TestFxView::class)
