package com.alejandroid.repository

import com.alejandroid.domain.Company
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional

import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
open class CompanyRepositoryImpl(
        @param:CurrentSession
        @field:PersistenceContext
        val entityManager: EntityManager
) : CompanyRepository {
    @Transactional
    override fun save(company: Company): Company {
        entityManager.persist(company)
        return company
    }

    @Transactional
    override fun updateDetails(company: Company): Int {
        return entityManager.createQuery("UPDATE Company SET description = :description, country = :country, share_price = :sharePrice where id = :id")
                .setParameter("id", company.id)
                .setParameter("description", company.description)
                .setParameter("country", company.country)
                .setParameter( "sharePrice", company.sharePrice)
                .executeUpdate()
    }

    @Transactional
    override fun updateSharePrice(id: Long, sharePrice: Double): Int {
        return entityManager.createQuery("UPDATE Company SET share_price = :sharePrice where id = :id")
                .setParameter("id", id)
                .setParameter( "sharePrice", sharePrice)
                .executeUpdate()
    }

    @Transactional(readOnly = true)
    override fun findOne(id: Long): Company? = entityManager.find(Company::class.java, id)

    @Transactional(readOnly = true)
    override fun findAll(): List<Company> = entityManager.createQuery("SELECT d FROM company d")
            .resultList as List<Company>

}