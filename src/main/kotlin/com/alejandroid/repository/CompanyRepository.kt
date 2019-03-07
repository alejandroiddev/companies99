package com.alejandroid.repository

import com.alejandroid.domain.Company
import io.micronaut.spring.tx.annotation.Transactional

interface CompanyRepository {
    fun save(company: Company): Company
    fun updateDetails(company: Company): Int
    fun updateSharePrice(id: Long, sharePrice: Double ) : Int
    fun findOne(id: Long): Company?
    fun findAll(): List<Company>
}