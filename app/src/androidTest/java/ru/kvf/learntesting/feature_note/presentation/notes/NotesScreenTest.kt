package ru.kvf.learntesting.feature_note.presentation.notes

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Rule
import ru.kvf.learntesting.di.AppModule


@HiltAndroidTest
@UninstallModules(AppModule::class)
class NotesScreenTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)
}