package com.example.viewmodel.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ScoreViewModel: ViewModel() {

    private val _team1Score = MutableLiveData<Int>()
    val team1Score : LiveData<Int>
        get() = _team1Score

    private val _team2Score = MutableLiveData<Int>()
    val team2Score : LiveData<Int>
        get() = _team2Score

    private val _eventFinished = MutableLiveData<Boolean>()
    val eventFinished : LiveData<Boolean>
        get() = _eventFinished


    private val _winnerr = MutableLiveData<String>()
    val winnerr : LiveData<String>
        get() = _winnerr

    private val _teams = MutableLiveData<ArrayList<String>>()
    val teams : LiveData<ArrayList<String>>
        get() = _teams

    val score1String = Transformations.map(team1Score, {score ->
        score.toString()
    })

    val score2String = Transformations.map(team2Score, {score ->
        score.toString()
    })

    init {
        _eventFinished.value = false
        _team1Score.value = 0
        _team2Score.value = 0
        _teams.value = ArrayList<String>()
    }

    fun initTeam(team1: String, team2: String) {
        (_teams.value)?.add(team1)
        (_teams.value)?.add(team2)
    }

    fun updateScore(team: Int) {
        if (team == 1) {
            _team1Score.value = (_team1Score.value)?.plus(1)
            _winnerr.value = (_teams.value)?.get(0)
        }
        else {
            _team2Score.value = (_team2Score.value)?.plus(1)
            _winnerr.value = (_teams.value)?.get(1)
        }
        if ( ((_team1Score.value)!! >= 3) ||
            ((_team2Score.value)!! >= 3) ){
            _eventFinished.value = true
        }
    }

    fun reset(){
        _eventFinished.value = false
    }
}