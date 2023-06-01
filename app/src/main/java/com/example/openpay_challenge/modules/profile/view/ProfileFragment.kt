package com.example.openpay_challenge.modules.profile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.openpay_challenge.MainActivity
import com.example.openpay_challenge.R
import com.example.openpay_challenge.base.BaseFragment
import com.example.openpay_challenge.databinding.FragmentProfileBinding
import com.example.openpay_challenge.domain.models.Profile
import com.example.openpay_challenge.modules.profile.constants.ProfileConstants.Companion.DEFAULT_PROFILE_URL
import com.example.openpay_challenge.modules.profile.view.adapters.RatedMovieAdapter
import com.example.openpay_challenge.modules.profile.viewModel.ProfileViewModel
import com.example.openpay_challenge.util.Constants
import com.example.openpay_challenge.util.observe
import com.example.openpay_challenge.util.observeEvent
import com.example.openpay_challenge.util.withViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val ratedMoviesAdapter = RatedMovieAdapter()

    override fun initView() {
        super.initView()
        with(binding) {
            rvRatedMovies.apply {
                adapter = ratedMoviesAdapter
                layoutManager =
                    GridLayoutManager(requireContext(), 1, RecyclerView.HORIZONTAL, false)
            }
        }
    }

    override fun getBindingView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentProfileBinding = FragmentProfileBinding.inflate(inflater, container, false)

    private fun showProfile(profile: Profile) {
        with(binding){
            tvUser.text = getString(R.string.welcome_message, USER_PROFILE_NAME)

            Glide
                .with(requireContext())
                .load(DEFAULT_PROFILE_URL)
                .centerCrop()
                .apply(Constants.glideOptions)
                .into(binding.ivProfile)
        }

        ratedMoviesAdapter.submitList(profile.ratedMovies)
    }

    private fun showErrorLoading() {
        (activity as MainActivity).showErrorDialog()
    }

    override fun getViewModel(): ProfileViewModel = withViewModel {
        //i didn't understand where to get the most popular user from and for lack of time i decided to
        // consume a mocki.io service to show any profile and hardcode the profile name with my name
        observe(profileLoaded()) { showProfile(it) }
        observeEvent(errorLoadingProfile()) { showErrorLoading() }
    }

    companion object {
        private const val USER_PROFILE_NAME = "Jonatan"
    }
}