package com.wisnia.data.configuration.repository

import com.wisnia.data.configuration.api.ConfigurationApi
import com.wisnia.data.configuration.model.toDomain
import com.wisnia.domain.configuration.model.ConfigurationModel
import com.wisnia.domain.configuration.repository.ConfigurationRepository
import io.reactivex.Single

class ConfigurationDataRepository(val configurationApi: ConfigurationApi) : ConfigurationRepository {

    override fun configuration(): Single<ConfigurationModel> =
        configurationApi.configuration()
            .map { configuration -> configuration.toDomain() }
}
