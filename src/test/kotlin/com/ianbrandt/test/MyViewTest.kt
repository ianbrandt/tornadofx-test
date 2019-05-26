package com.ianbrandt.test

import javafx.scene.Scene
import javafx.stage.Stage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start

@ExtendWith(ApplicationExtension::class)
class MyViewTest {

	@Start
	fun start(stage: Stage) {
		stage.scene = Scene(MyView().root)
		stage.show()
	}

	@Test
	fun `test the button`(robot: FxRobot) {
		println("TESTING...")
		robot.clickOn("#test-button")
	}
}
