package com.wisnia.data.configuration.repository

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.wisnia.data.configuration.api.ConfigurationApi
import com.wisnia.data.configuration.model.ConfigurationEntity
import com.wisnia.data.configuration.model.ImagesEntity
import com.wisnia.domain.configuration.model.ConfigurationModel
import io.reactivex.Single
import org.amshove.kluent.mock
import org.amshove.kluent.shouldEqual
import org.junit.Test

class ConfigurationDataRepositoryTest {

    val configurationApi = mock<ConfigurationApi>()

    val images = ImagesEntity("", "", emptyList(), emptyList(), emptyList(), emptyList(), emptyList())
    val configuration = ConfigurationEntity(images, emptyList())

    val tested = ConfigurationDataRepository(configurationApi)

    @Test
    fun `should get configuration`() {
        whenever(configurationApi.configuration()).thenReturn(Single.never())

        tested.configuration()

        verify(configurationApi).configuration()
    }

    @Test
    fun `should get configuration and map it to domain`() {
        whenever(configurationApi.configuration()).thenReturn(Single.just(configuration))

        val result = tested.configuration().blockingGet()

        val expected = ConfigurationModel("", "", emptyList())
        result shouldEqual expected
    }
}
