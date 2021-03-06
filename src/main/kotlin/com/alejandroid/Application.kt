package com.alejandroid

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.alejandroid")
                .mainClass(Application.javaClass)
                .start()
    }
}