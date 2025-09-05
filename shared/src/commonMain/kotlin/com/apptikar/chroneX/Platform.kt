package com.apptikar.chroneX

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

