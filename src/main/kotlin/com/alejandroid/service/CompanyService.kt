package com.alejandroid.service

import com.alejandroid.domain.Company
import com.alejandroid.repository.CompanyRepositoryImpl
import io.micronaut.scheduling.annotation.Scheduled
import org.slf4j.LoggerFactory
import java.sql.Timestamp
import javax.inject.Singleton

@Singleton
class CompanyService(private val providerService: ProviderService,
                     private val companyRepository: CompanyRepositoryImpl) {

    @Scheduled(fixedDelay = "20s", initialDelay = "10s")
    fun updateCompanies() {
        log.info("Started updating companies...")
        val i = Timestamp(System.currentTimeMillis())
        log.info(i.toString())
        fetchCompanies()
                .forEach(::saveCompany)
        log.debug("Finished updating companies...")
    }

    private fun saveCompany(company: Company) {
        log.debug("Fetching company with id: {}", company.id)
        var companyResult: Company? = companyRepository.findOne(company.id)
        if (companyResult == null) {
            companyRepository.save(company)
        }
        companyRepository.updateDetails(providerService.fetchOneCompany(company.id))
        //Ceate shareprice
    }

    fun getCompanies(): MutableList<Company> {
        return providerService.fetchCompanies()
    }

    fun findCompany(id: Long): Company {
        return providerService.fetchOneCompany(id)
    }

    private fun fetchCompanies(): MutableList<Company> {
        log.info("Fetching all companies")
        return providerService.fetchCompanies()
    }

    private fun fetchCompanyDetails(id: Long): Company {
        log.info("Fetching details for company {}", id)
        return providerService.fetchOneCompany(id)
    }

    companion object {
        private val log = LoggerFactory.getLogger(CompanyService::class.java)
    }
}