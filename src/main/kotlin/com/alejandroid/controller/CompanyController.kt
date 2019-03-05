package com.alejandroid.controller

import com.alejandroid.domain.Company
import com.alejandroid.service.CompanyService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Maybe

@Controller
class CompanyController(private val companyService: CompanyService) {

    @Get("/companies")
    fun getCompanies(): Maybe<MutableHttpResponse<List<Company>>> {
        return companyService.getCompanies().map { HttpResponse.ok(it) }
    }

    @Get("/companies/{id}")
    fun findCompanyById(id: String): Maybe<MutableHttpResponse<Company>> {
        return companyService.findCompany(id).map { HttpResponse.ok(it) }
    }
}