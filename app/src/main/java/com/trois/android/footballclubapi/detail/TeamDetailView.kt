package com.trois.android.footballclubapi.detail

import com.trois.android.footballclubapi.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}