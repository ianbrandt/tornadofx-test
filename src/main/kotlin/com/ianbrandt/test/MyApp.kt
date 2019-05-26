package com.ianbrandt.test

import tornadofx.*

fun main() {
	launch<MyApp>()
}

class MyApp : App(MyView::class)
