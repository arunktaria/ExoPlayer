package com.example.exoplayer.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player

class ViewModelsClass : ViewModel() {
 var playervalue1: Boolean=false
var playervalue2: Boolean=false

    val playersValues=PlayersValue()
   private val data=MutableLiveData<PlayersValue>()
    val datatemp:LiveData<PlayersValue>
    get() = data

    fun getPlayerStatus(player1:ExoPlayer,player2:ExoPlayer)
    {
        player1.prepare()
        player2.prepare()


/*
        if (player1.isPlaying==true)
            {

                playersValues.player1=true
                playersValues.player2=false
                data.postValue(playersValues)
                Log.d("TAG", "player 1 is playing in viewmodel")

            }


        if (player2.isPlaying==true)
        {
            playersValues.player1=false
            playersValues.player2=true
            data.postValue(playersValues)
            Log.d("TAG", "player 2 is playing in viewmodel")

        }
*/

    }


}