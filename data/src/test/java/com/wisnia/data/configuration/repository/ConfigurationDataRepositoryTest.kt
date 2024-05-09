package com.wisnia.data.configuration.repository

import com.wisnia.data.configuration.api.ConfigurationApi
import com.wisnia.data.configuration.model.ConfigurationEntity
import com.wisnia.data.configuration.model.ImagesEntity
import com.wisnia.domain.configuration.model.ConfigurationModel
import io.reactivex.Single
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ConfigurationDataRepositoryTest {

    val configurationApi = mock<ConfigurationApi>()

    val images =
        ImagesEntity("", "", emptyList(), emptyList(), emptyList(), emptyList(), emptyList())
    val configuration = ConfigurationEntity(images, emptyList())

    val tested = ConfigurationDataRepository(configurationApi)

    @Test
    fun `should get configuration`() {
        `when`(configurationApi.configuration()).thenReturn(Single.never())

        tested.configuration()

        verify(configurationApi).configuration()
    }

    @Test
    fun `should get configuration and map it to domain`() {
        `when`(configurationApi.configuration()).thenReturn(Single.just(configuration))

        val result = tested.configuration().blockingGet()

        val expected = ConfigurationModel("", "", emptyList())
        result shouldBeEqualTo expected
    }
}
