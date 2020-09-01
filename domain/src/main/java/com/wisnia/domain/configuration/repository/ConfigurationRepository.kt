package com.wisnia.domain.configuration.repository

import com.wisnia.domain.configuration.model.ConfigurationModel
import io.reactivex.Single

interface ConfigurationRepository {

    fun configuration(): Single<ConfigurationModel>
}
