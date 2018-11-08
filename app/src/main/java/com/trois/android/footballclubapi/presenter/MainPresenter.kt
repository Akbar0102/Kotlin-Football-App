package com.trois.android.footballclubapi.presenter

import com.google.gson.Gson
import com.trois.android.footballclubapi.api.ApiRepository
import com.trois.android.footballclubapi.api.TheSportDBApi
import com.trois.android.footballclubapi.model.TeamResponse
import com.trois.android.footballclubapi.view.MainView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView, private val apiRepository: ApiRepository, private val gson: Gson) {

    fun getTeamList(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeams(league)),
                    TeamResponse::class.java
            )
            uiThread{
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}