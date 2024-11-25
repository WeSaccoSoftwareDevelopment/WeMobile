package com.mobilewe.wemobile.data.gateway.fake


import com.mobilewe.wemobile.domain.gateway.IUserGateway
import com.mobilewe.wemobile.domain.model.*
import com.mobilewe.wemobile.domain.utils.Resource


class FakeIUserGateway : IUserGateway {
    override suspend fun createUser(userAccount: UserAccount): User {
        TODO("Not yet implemented")
    }

    override suspend fun loginUser(username: String, password: String): Session {
        TODO("Not yet implemented")
    }



    override suspend fun refreshAccessToken(refreshToken: String): Pair<String, String> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserProfile(): User {
        TODO("Not yet implemented")
    }

    override suspend fun getUserAddresses(): List<Address> {
        TODO("Not yet implemented")
    }

    override suspend fun updateProfile(fullName: String?, phone: String?): User {
        TODO("Not yet implemented")
    }



}
