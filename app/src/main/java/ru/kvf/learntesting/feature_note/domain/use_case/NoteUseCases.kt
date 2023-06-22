package ru.kvf.learntesting.feature_note.domain.use_case

import ru.kvf.learntesting.feature_note.domain.use_case.AddNote
import ru.kvf.learntesting.feature_note.domain.use_case.DeleteNote
import ru.kvf.learntesting.feature_note.domain.use_case.GetNote
import ru.kvf.learntesting.feature_note.domain.use_case.GetNotes

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,
    val getNote: GetNote
)
