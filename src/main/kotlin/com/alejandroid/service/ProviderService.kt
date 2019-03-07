package com.alejandroid.service

import com.alejandroid.domain.Company
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable

@Client("https://dev.ninetynine.com")
interface ProviderService {
    @Get("/testapi/1/companies")
    fun fetchCompanies(): MutableList<Company>

    @Get("/testapi/1/companies/{id}")
    fun fetchOneCompany(id: Long): Company
}