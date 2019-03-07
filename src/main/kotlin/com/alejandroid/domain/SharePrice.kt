package com.alejandroid.domain

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "share_price", indexes = [Index(columnList = "timestamp"), Index(columnList = "company_id")])
data class SharePrice(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,

        @Column(name = "company_id")
        var companyId: String = "",
        var price: Double = 0.0,
        var timestamp: Timestamp = Timestamp(System.currentTimeMillis())
)
