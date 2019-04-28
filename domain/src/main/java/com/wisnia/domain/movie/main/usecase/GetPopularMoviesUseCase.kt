package com.wisnia.domain.movie.main.usecase

import com.wisnia.domain.configuration.model.image.PosterSizesModel.W342
import com.wisnia.domain.configuration.model.imagePath
import com.wisnia.domain.configuration.repository.ConfigurationRepository
import com.wisnia.domain.movie.main.model.MovieModel
import com.wisnia.domain.movie.main.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val configurationRepository: ConfigurationRepository
) {

    fun execute(): Single<MovieModel> =
        configurationRepository.configuration()
            .map { configuration -> configuration.imagePath(W342) }
            .flatMap { imagePath -> movieRepository.popularMovies(imagePath) }
}
