package com.mobilewe.wemobile.domain.usecases

import com.mobilewe.wemobile.domain.gateway.local.ILocalConfigurationGateway
import com.mobilewe.wemobile.data.datastore.AuthDatastore
import com.mobilewe.wemobile.domain.gateway.IUserGateway
import kotlinx.coroutines.flow.Flow
import com.mobilewe.wemobile.domain.model.UserAccount

interface IManageAuthenticationUseCase {
    suspend fun createUser(userAccount: UserAccount): Boolean
    suspend fun loginUser(username: String, password: String, keepLoggedIn: Boolean): Boolean
    suspend fun logout()
    suspend fun getAccessToken(): Flow<String>
}

class ManageAuthenticationUseCase(
    private val remoteGateway: IUserGateway,
    private val localGateway: ILocalConfigurationGateway,
    private val validation: IValidationUseCase,
    private val authDataStore: AuthDatastore
) : IManageAuthenticationUseCase {

    override suspend fun createUser(userAccount: UserAccount): Boolean {
        with(userAccount) {
            with(validation) {
                validateFullName(fullName); validateUsername(username); validatePassword(password)
                validateEmail(email); validatePhone(phone); validateAddress(address)
            }
        }
        return remoteGateway.createUser(userAccount).fullName.isNotEmpty()
    }

    override suspend fun loginUser(
        username: String, password: String, keepLoggedIn: Boolean
    ): Boolean {
        validation.validateUsername(username); validation.validatePassword(username)
        val session = remoteGateway.loginUser(username,password)
        localGateway.saveAccessToken(session.accessToken)
        localGateway.saveRefreshToken(session.refreshToken)
        localGateway.saveKeepMeLoggedInFlag(keepLoggedIn)
        authDataStore.saveLoginState(keepLoggedIn)
        return true
    }

    override suspend fun logout() {
        localGateway.removeAccessToken()
        localGateway.removeRefreshToken()
    }

    override suspend fun getAccessToken(): Flow<String> {
        return localGateway.getAccessTokenStream()
    }

}
