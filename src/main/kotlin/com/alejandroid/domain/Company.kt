package com.alejandroid.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Company(
        @Id
        var id: Long = 0,

        var name: String = "",
        var ric: String = "",
        @Column(name = "share_price")
        var sharePrice: Double = 0.0,
        var description: String = "",
        var country: String = ""
)