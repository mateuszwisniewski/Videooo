package com.wisnia.data.configuration.model

import com.wisnia.data.configuration.model.image.PosterSizes
import com.wisnia.domain.configuration.model.ConfigurationModel
import com.wisnia.domain.configuration.model.image.PosterSizesModel
import org.amshove.kluent.shouldEqual
import org.junit.Test

class ConfigurationTest {

    val images = Images("", "", emptyList(), emptyList(), emptyList(), emptyList(), emptyList())
    val configuration = Configuration(images, emptyList())

    @Test
    fun `should map configuration to domain`() {
        val images = images.copy(baseUrl = "baseUrl", secureBaseUrl = "secureBaseUrl", posterSizes = listOf(PosterSizes.original))
        val configuration = configuration.copy(images = images)

        val result = configuration.toDomain()

        val expected = ConfigurationModel("baseUrl", "secureBaseUrl", listOf(PosterSizesModel.ORIGINAL))
        result shouldEqual expected
    }
}