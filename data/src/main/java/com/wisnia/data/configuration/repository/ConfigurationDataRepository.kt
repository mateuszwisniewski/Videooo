package com.wisnia.data.configuration.repository

import com.wisnia.data.configuration.api.ConfigurationApi
import com.wisnia.domain.configuration.model.Configuration
import com.wisnia.domain.configuration.repository.ConfigurationRepository
import io.reactivex.Single

class ConfigurationDataRepository(configurationApi: ConfigurationApi) : ConfigurationRepository {

    override val configuration: Single<Configuration> = configurationApi.configuration
}