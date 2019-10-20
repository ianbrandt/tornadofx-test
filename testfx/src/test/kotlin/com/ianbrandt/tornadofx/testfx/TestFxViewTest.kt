package com.ianbrandt.tornadofx.testfx

import javafx.scene.Scene
import javafx.stage.Stage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxRobot
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start

@ExtendWith(ApplicationExtension::class)
class TestFxViewTest {

	@Start
	fun start(stage: Stage) {
		stage.scene = Scene(TestFxView().root)
		stage.show()
	}

	@Test
	fun `test button text changes`(robot: FxRobot) {
		val buttonQuery = "#${TestFxView.BUTTON_ID}"
		val button = robot.lookup(buttonQuery).queryButton()
		assertThat(button).hasText(TestFxView.INITIAL_BUTTON_TEXT)
		robot.clickOn(button)
		assertThat(button).hasText(TestFxView.CHANGED_BUTTON_TEXT)
	}
}
