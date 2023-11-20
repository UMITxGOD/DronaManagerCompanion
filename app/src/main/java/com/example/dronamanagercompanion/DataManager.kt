package com.example.dronamanagercompanion

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.dronamanagercompanion.models.Player
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Player>()
    var isDataLoaded = mutableStateOf(false)
    fun loadAssetFromFile(context: Context){
        val inputStream = context.assets.open("player_details.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8 )
        val gson = Gson()
        data = gson.fromJson(json,Array<Player>::class.java)
        isDataLoaded.value = true
    }
}