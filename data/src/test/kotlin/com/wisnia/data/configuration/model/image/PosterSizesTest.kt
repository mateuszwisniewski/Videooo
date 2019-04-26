package com.wisnia.data.configuration.model.image

import com.wisnia.domain.configuration.model.image.PosterSizesModel
import org.amshove.kluent.shouldEqual
import org.junit.Test

class PosterSizesTest {

    @Test
    fun `should map list of poster sizes to domain`() {
        val posterSizes = listOf(
            PosterSizes.w92,
            PosterSizes.w154,
            PosterSizes.w185,
            PosterSizes.w342,
            PosterSizes.w500,
            PosterSizes.w780,
            PosterSizes.original
        )

        val result = posterSizes.toDomain()

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
