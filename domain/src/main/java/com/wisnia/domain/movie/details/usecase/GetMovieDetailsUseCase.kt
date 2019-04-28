package com.wisnia.domain.movie.details.usecase

import com.wisnia.domain.configuration.model.image.PosterSizesModel.W780
import com.wisnia.domain.configuration.model.imagePath
import com.wisnia.domain.configuration.repository.ConfigurationRepository
import com.wisnia.domain.movie.details.repository.MovieDetailsRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository,
    private val configurationRepository: ConfigurationRepository
) {

    fun execute(movieId: Int) =
        configurationRepository.configuration()
            .map { configuration -> configuration.imagePath(W780) }
            .flatMap { imagePath -> movieDetailsRepository.movieDetails(movieId, imagePath) }
}