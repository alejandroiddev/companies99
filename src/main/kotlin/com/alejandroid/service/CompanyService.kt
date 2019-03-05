package com.alejandroid.service

import com.alejandroid.domain.Company
import io.reactivex.Maybe
import javax.inject.Singleton

@Singleton
class CompanyService(val providerService: ProviderService) {

    fun getCompanies(): Maybe<List<Company>> {
        return providerService.fetchCompanies().firstElement()
    }

    fun findCompany(id: String): Maybe<Company> {
        return providerService.fetchOneCompany(id).firstElement()
    }

}