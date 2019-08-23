package com.wisnia.data.configuration.model.image

import com.wisnia.domain.configuration.model.image.PosterSizesModel
import org.amshove.kluent.shouldEqual
import org.junit.Test

class PosterSizesEntityTest {

    @Test
    fun `should map list of poster sizes to domain`() {
        val posterSizesEntity = listOf(
            PosterSizesEntity.w92,
            PosterSizesEntity.w154,
            PosterSizesEntity.w185,
            PosterSizesEntity.w342,
            PosterSizesEntity.w500,
            PosterSizesEntity.w780,
            PosterSizesEntity.original
        )

        val result = posterSizesEntity.toDomain()

        val expected = listOf(
            PosterSizesModel.W92,
            PosterSizesModel.W154,
            PosterSizesModel.W185,
            PosterSizesModel.W342,
            PosterSizesModel.W500,
            PosterSizesModel.W780,
            PosterSizesModel.ORIGINAL
        )

        result shouldEqual expected
    }
}
