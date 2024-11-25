package com.mobilewe.wemobile.data.gateway.remote

import com.mobilewe.wemobile.domain.gateway.IUserGateway
import com.mobilewe.wemobile.domain.model.Address
import com.mobilewe.wemobile.domain.model.Session
import com.mobilewe.wemobile.domain.model.User
import com.mobilewe.wemobile.domain.model.UserAccount
import com.mobilewe.wemobile.domain.utils.AuthorizationException
import com.mobilewe.wemobile.domain.utils.GeneralException
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import io.ktor.http.Parameters
import io.ktor.utils.io.InternalAPI
import kotlinx.serialization.json.Json
import com.mobilewe.wemobile.data.remote.mapper.toEntity
import com.mobilewe.wemobile.data.remote.mapper.toSessionEntity
import com.mobilewe.wemobile.data.remote.mapper.toUserRegistrationDto
import com.mobilewe.wemobile.data.remote.response.AddressDto
import com.mobilewe.wemobile.data.remote.response.SessionDto
import com.mobilewe.wemobile.data.remote.response.UserDetailsDto
import com.mobilewe.wemobile.data.remote.response.UserRegistrationDto
import com.mobilewe.wemobile.data.remote.util.ServerResponse
import com.mobilewe.wemobile.data.remote.mapper.toEntity

class UserGateway(client: HttpClient) : BaseGateway(client), IUserGateway {


    @OptIn(InternalAPI::class)
    override suspend fun createUser(account: UserAccount): User {
        return tryToExecute<ServerResponse<UserDetailsDto>> {
            post("/signup") {
                val userRegistrationDto = account.toUserRegistrationDto()
                body = Json.encodeToString(UserRegistrationDto.serializer(), userRegistrationDto)
            }
        }.value?.toEntity()
            ?: throw AuthorizationException.InvalidCredentialsException("Invalid Credential")
    }


    override suspend fun loginUser(username: String, password: String): Session {
        return tryToExecute<ServerResponse<SessionDto>> {
            submitForm(
                url = ("/login"),
                formParameters = Parameters.build {
                    append("username", username)
                    append("password", password)
                }
            ) {
                method = HttpMethod.Post
            }
        }.value?.toSessionEntity()
            ?: throw AuthorizationException.InvalidCredentialsException("Invalid Credential")
    }

    override suspend fun refreshAccessToken(refreshToken: String): Pair<String, String> {
        val result = tryToExecute<ServerResponse<SessionDto>> {
            submitForm {
                url("/refresh-access-token")
            }
        }.value ?: throw Exception()

        return Pair(result.accessToken, result.refreshToken)
    }

    override suspend fun getUserProfile(): User {
        return tryToExecute<ServerResponse<UserDetailsDto>> {
            get("/user")
        }.value?.toEntity()
            ?: throw AuthorizationException.InvalidCredentialsException("Invalid Credential")
    }


    override suspend fun getUserAddresses(): List<Address> {
        val response = tryToExecute<ServerResponse<List<AddressDto>>> {
            get("/user/addresses")
        }
        if (response.isSuccess) {
            return response.value?.map { it.toEntity() }
                ?: throw GeneralException.NotFoundException
        } else {
            // here we can handle different errors by checking response.status.code
            // and also we can use the message sent from the server to pass it throw the exception
            // and show it to user if we want
            if (response.status.code == 404) {
                throw GeneralException.NotFoundException
            } else {
                throw GeneralException.UnknownErrorException
            }
        }
    }



    override suspend fun updateProfile(fullName: String?, phone: String?): User {
        return tryToExecute<ServerResponse<UserDetailsDto>> {
            submitForm(
                url = ("/user/profile"),
                formParameters = Parameters.build {
                    fullName?.let { append("fullName", it) }
                    phone?.let { append("phone", it) }
                }
            ) {
                method = HttpMethod.Put
            }
        }.value?.toEntity()
            ?: throw AuthorizationException.InvalidCredentialsException("Invalid Credential")

    }


}