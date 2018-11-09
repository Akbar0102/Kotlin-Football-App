package com.trois.android.footballclubapi.teams

import com.trois.android.footballclubapi.model.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}