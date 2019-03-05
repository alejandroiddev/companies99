package com.alejandroid.domain

//{"id":1,"name":"Apple Inc.","ric":"APPL","sharePrice":202.262,"description":"Lorem ipsum is your friend ;)","country":"United States of America"}
//{"id":1,"name":"Apple Inc.","ric":"APPL","sharePrice":218.467}

data class Company(var id: String = "",
                   var name: String = "",
                   var ric: String = "",
                   var sharePrice: Double = 0.0,
                   var description: String = "",
                   var country: String = "")