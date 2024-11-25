package com.mobilewe.wemobile.domain.gateway

import com.mobilewe.wemobile.domain.model.Address
import com.mobilewe.wemobile.domain.model.Session
import com.mobilewe.wemobile.domain.model.User
import com.mobilewe.wemobile.domain.model.UserAccount


interface IUserGateway {
    suspend fun createUser(account: UserAccount): User
    suspend fun loginUser(username: String, password: String): Session
    suspend fun refreshAccessToken(refreshToken: String): Pair<String, String>
    suspend fun getUserProfile(): User
    suspend fun getUserAddresses(): List<Address>
    suspend fun updateProfile(fullName: String?, phone: String?): User
}