package com.ianbrandt.test

import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Stage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxRobot
import org.testfx.assertions.api.Assertions
import org.testfx.assertions.api.Assertions.*
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
	fun `test button text changes`(robot: FxRobot) {
		val buttonQuery = "#${MyView.BUTTON_ID}"
		val button = robot.lookup(buttonQuery).queryButton()
		assertThat(button).hasText(MyView.INITIAL_BUTTON_TEXT)
		robot.clickOn(button)
		assertThat(button).hasText(MyView.CHANGED_BUTTON_TEXT)
	}
}
