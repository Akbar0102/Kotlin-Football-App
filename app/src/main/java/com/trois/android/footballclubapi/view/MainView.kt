package com.trois.android.footballclubapi.view

import com.trois.android.footballclubapi.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}