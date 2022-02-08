package com.example.motivation.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.infra.Constants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter: Int = Constants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        imageAll.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageMorning.setOnClickListener(this)
        btnNewPhrase.setOnClickListener(this)

        mSecurityPreferences = SecurityPreferences(this)
        textName.text = "Olá, ${mSecurityPreferences.getString(Constants.KEY.PERSON_NAME)}!"
        handleNewPhrase()
        setIconColor(2)
    }

    override fun onClick(v: View) {
        val id = v.id

        val listFilter = listOf(R.id.imageAll, R.id.imageHappy, R.id.imageMorning)
        if (id == R.id.btnNewPhrase) {
            handleNewPhrase()

        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleNewPhrase() {
        textPhrase.text = Mock(this).getPhrase(mPhraseFilter)
    }

    private fun handleFilter(id: Int) {

        setIconColor(1)
        setIconColor(3)
        setIconColor(5)

        when (id) {
            R.id.imageAll -> {
                setIconColor(2)
                mPhraseFilter = Constants.PHRASEFILTER.ALL
            }
            R.id.imageHappy -> {
                setIconColor(4)
                mPhraseFilter = Constants.PHRASEFILTER.HAPPY
            }
            R.id.imageMorning -> {
                setIconColor(6)
                mPhraseFilter = Constants.PHRASEFILTER.MORNING
            }
        }
    }

    fun setIconColor(colorId: Int) {
        if (colorId == 1) {
            imageAll.setColorFilter(resources.getColor(R.color.white))
        } else if (colorId == 2) {
            imageAll.setColorFilter(resources.getColor(R.color.black))
        } else if (colorId == 3) {
            imageHappy.setColorFilter(resources.getColor(R.color.white))
        } else if (colorId == 4) {
            imageHappy.setColorFilter(resources.getColor(R.color.black))
        } else if (colorId == 5) {
            imageMorning.setColorFilter(resources.getColor(R.color.white))
        } else if (colorId == 6) {
            imageMorning.setColorFilter(resources.getColor(R.color.black))
        }
    }
}