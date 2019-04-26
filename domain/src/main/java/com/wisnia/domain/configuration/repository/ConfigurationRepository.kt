package com.wisnia.domain.configuration.repository

import com.wisnia.domain.configuration.model.Configuration
import io.reactivex.Single

interface ConfigurationRepository {

    val configuration: Single<Configuration>
}