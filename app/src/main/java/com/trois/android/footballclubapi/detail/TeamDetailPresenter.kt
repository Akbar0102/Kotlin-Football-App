package com.trois.android.footballclubapi.detail

import com.google.gson.Gson
import com.trois.android.footballclubapi.api.ApiRepository
import com.trois.android.footballclubapi.api.TheSportDBApi
import com.trois.android.footballclubapi.model.TeamResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson){

    fun getTeamDetail(teamId: String){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamDetail(teamId)), TeamResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showTeamDetail(data.teams)
            }
        }
    }
}