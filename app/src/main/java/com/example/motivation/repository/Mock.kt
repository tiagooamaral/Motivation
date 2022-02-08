package com.example.motivation.repository

import android.content.Context
import com.example.motivation.R
import com.example.motivation.infra.Constants
import java.util.*

data class Phrase(val description: String, val category: Int)

class Mock (context: Context) {

    private val ALL = Constants.PHRASEFILTER.ALL
    private val MORNING = Constants.PHRASEFILTER.MORNING
    private val HAPPY = Constants.PHRASEFILTER.HAPPY

    private val mListPhrases: List<Phrase> = listOf(
        Phrase(context.getString(R.string.phrase1), HAPPY),
        Phrase(context.getString(R.string.phrase2), HAPPY),
        Phrase(context.getString(R.string.phrase3), HAPPY),
        Phrase(context.getString(R.string.phrase4), HAPPY),
        Phrase(context.getString(R.string.phrase5), HAPPY),
        Phrase(context.getString(R.string.phrase6), HAPPY),
        Phrase(context.getString(R.string.phrase7), MORNING),
        Phrase(context.getString(R.string.phrase8), MORNING),
        Phrase(context.getString(R.string.phrase9), MORNING),
        Phrase(context.getString(R.string.phrase10), MORNING),
        Phrase(context.getString(R.string.phrase11), MORNING),
        Phrase(context.getString(R.string.phrase12), MORNING),
        Phrase(context.getString(R.string.phrase13), MORNING)
    )

    fun getPhrase(categoryId: Int): String {
        val filtered = mListPhrases.filter { it.category == categoryId || categoryId == ALL }
        val random = Random().nextInt(filtered.size)

        return filtered[random].description
    }
}