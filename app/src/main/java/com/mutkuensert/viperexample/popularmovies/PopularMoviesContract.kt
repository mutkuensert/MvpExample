package com.mutkuensert.viperexample.popularmovies

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.github.michaelbull.result.Result
import kotlinx.serialization.Serializable

interface PopularMoviesContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showMovies(movies: List<Movie>)
    }

    interface Presenter {
        fun onCreateView(view: View, fragment: Fragment)

        fun unbind()

        fun onClickMovie(id: Int)
    }

    interface Interactor {
        suspend fun getMovies(): Result<List<Movie>, Exception>
    }

    interface Router {
        @Serializable
        object PopularMoviesRoute

        fun navigateToMovieDetail(navController: NavController, id: Int)
    }
}