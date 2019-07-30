package com.example.reacttest.view

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor() {

    fun showNotes(context: Context) = context.startActivity(ListNoteActivity.callingIntent(context))

    fun showNoteDetail(context: Context, uuid: String) =
        context.startActivity(DetailNoteActivity.callingIntent(context, uuid))

    fun showAddNote(context: Context) = context.startActivity(AddNoteActivity.callingIntent(context))
}