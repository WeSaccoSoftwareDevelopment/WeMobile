package com.mobilewe.wemobile.domain.repo


import kotlinx.coroutines.flow.Flow

interface ThemeRepository {
    val themeStream: Flow<Int>
    suspend fun setTheme(themeValue: Int)

}