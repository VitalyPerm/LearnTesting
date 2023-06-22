package ru.kvf.learntesting.feature_note.domain.use_case

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import ru.kvf.learntesting.feature_note.data.repository.FakeNoteRepository
import ru.kvf.learntesting.feature_note.domain.model.InvalidNoteException
import ru.kvf.learntesting.feature_note.domain.model.Note

class AddNoteTest {

    private lateinit var addNote: AddNote
    private lateinit var getNotes: GetNotes
    private lateinit var fakeRepository: FakeNoteRepository

    @Before
    fun setUp() {
        fakeRepository = FakeNoteRepository()
        addNote = AddNote(fakeRepository)
        getNotes = GetNotes(fakeRepository)
    }

    @Test
    fun `Empty title throws exception`() {
        val note = Note(
            id = 0,
            title = "",
            content = "world",
            timestamp = 123,
            color = 321
        )

        assertThrows(
            "The title of the note can't be empty.",
            InvalidNoteException::class.java
        ) {
            runBlocking {
                addNote(note)
            }
        }
    }

    @Test
    fun `Empty content throws exception`() {
        val note = Note(
            id = 0,
            title = "hello",
            content = "",
            timestamp = 123,
            color = 321
        )

        assertThrows(
            "The content of the note can't be empty.",
            InvalidNoteException::class.java
        ) {
            runBlocking {
                addNote(note)
            }
        }
    }

    @Test
    fun `Correct note added success`(): Unit = runBlocking {
        val note = Note(
            id = 321,
            title = "hello",
            content = "world",
            timestamp = 123,
            color = 321
        )

        addNote(note)

        val allNotes = getNotes().first()

        val noteFromDb = allNotes.find { it.id == note.id }

        assertThat(note == noteFromDb)
    }



}