package com.mobilewe.wemobile.domain.usecases

import com.mobilewe.wemobile.domain.utils.AuthorizationException
import com.mobilewe.wemobile.domain.utils.PayBillException


interface IValidationUseCase {
    @Throws(AuthorizationException.InvalidUsernameException::class)
    fun validateUsername(username: String)

    @Throws(AuthorizationException.InvalidPasswordException::class)
    fun validatePassword(password: String)

    @Throws(AuthorizationException.InvalidFullNameException::class)
    fun validateFullName(fullName: String)

    @Throws(AuthorizationException.InvalidEmailException::class)
    fun validateEmail(email: String)

    @Throws(AuthorizationException.InvalidAddressException::class)
    fun validateAddress(address: String)

    @Throws(AuthorizationException.InvalidPhoneException::class)
    fun validatePhone(phone: String, currency: String? = null)

    @Throws(PayBillException.InvalidBusinessNumber::class)
    fun validateBusinessNumber(businessNumber: String?=null)

    @Throws(PayBillException.InvalidAccountNumber::class)
    fun validateAccountNumber(accountNumber: String? = null)


}

class ValidationUseCaseUseCase : IValidationUseCase {
    override fun validateUsername(username: String) {
        if (username.isEmpty() || "[a-zA-Z0-9_]+".toRegex().matches(username).not()) {
            throw AuthorizationException.InvalidUsernameException
        }
    }

    override fun validatePassword(password: String) {
        if (password.isEmpty() || password.length < 8) {
            throw AuthorizationException.InvalidPasswordException
        }
    }

    override fun validateFullName(fullName: String) {
        if (fullNameRegex.matches(fullName).not()) {
            throw AuthorizationException.InvalidFullNameException
        }
    }

    override fun validateEmail(email: String) {
        if (emailRegex.matches(email).not()) {
            throw AuthorizationException.InvalidEmailException
        }
    }

    override fun validateAddress(address: String) {
        // todo: add address validation regex like this one: ^[A-Za-z0-9\s.,-]+$
        if (address.isBlank()) {
            throw AuthorizationException.InvalidAddressException
        }
    }

    override fun validatePhone(phone: String, currency: String?) {
        if (currency == null) {
            phoneRegexMap.values.any { it.matches(phone) }.takeIf { it }
                ?: throw AuthorizationException.InvalidPhoneException
        } else {
            val phoneRegex = getPhoneRegex(currency)
            if (phone.matches(phoneRegex).not()) {
                throw AuthorizationException.InvalidPhoneException
            }
        }
    }

    override fun validateBusinessNumber(businessNumber: String?) {
        if (businessNumber.isNullOrBlank()){
            throw PayBillException.InvalidBusinessNumber
        }
    }

    override fun validateAccountNumber(accountNumber: String?) {
        if (accountNumber.isNullOrBlank()){
            throw PayBillException.InvalidAccountNumber
        }
    }


    private fun getPhoneRegex(currency: String): Regex {
        return phoneRegexMap[currency] ?: "^\\+1\\d{10}$".toRegex()
    }

    private companion object {
        val fullNameRegex = "^[\\p{L}'-]+(?: [\\p{L}'-]+)*\$".toRegex()
        val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$".toRegex()
        val phoneRegexMap = mapOf(
            "ke" to "^\\+254\\d{10}$".toRegex(),
            "IQD" to "^\\+964\\d{10}$".toRegex(),
            "SYP" to "^\\+963\\d{9}$".toRegex(),
            "ILS" to "^\\+972([59])\\d{8}$".toRegex(),
            "US" to "^\\+1\\d{10}$".toRegex()
        )
    }
}
