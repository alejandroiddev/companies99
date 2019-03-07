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
    fun getCompanies(): MutableHttpResponse<MutableList<Company>>? {
        return  HttpResponse.ok(companyService.getCompanies())
    }

    @Get("/companies/{id}")
    fun findCompanyById(id: Long): MutableHttpResponse<Company> {
        return HttpResponse.ok(companyService.findCompany(id))
    }
}