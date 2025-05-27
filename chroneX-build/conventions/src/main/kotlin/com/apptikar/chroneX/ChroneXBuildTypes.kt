package com.apptikar.chroneX

enum class ChroneXBuildTypes(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
    BENCHMARK(".benchmark")
}