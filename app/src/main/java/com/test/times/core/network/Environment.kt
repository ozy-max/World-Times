package com.test.times.core.network

import javax.inject.Inject

private const val BASE_URL = "timeapi.io"

class Environment @Inject constructor(
    val baseAddress: String,
    val isSslEnabled: Boolean
) {
    companion object {

        private val DEBUG = Environment(
            baseAddress = BASE_URL,
            isSslEnabled = true,
        )

        fun getBuildVariantEnvironment() = DEBUG
    }

    val restAddress: String = "${if (isSslEnabled) "https" else "http"}://$baseAddress/api/"
}