package com.example.viewmodel.score

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentScoringBinding

class ScoringFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel
    private lateinit var binding: FragmentScoringBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_scoring, container, false)

        //viewModel
        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        binding.scoreViewModel = viewModel
        binding.setLifecycleOwner(this)



        var args = ScoringFragmentArgs.fromBundle(arguments!!)


        binding.TeamNama1.text = args.team1
        binding.TeamNama2.text = args.team2
        viewModel.initTeam(args.team1, args.team2)

        viewModel.eventFinished.observe(viewLifecycleOwner, Observer { hasFinished ->
            if (hasFinished) {
                viewModel.reset()
                view!!.findNavController()
                    .navigate(
                        ScoringFragmentDirections.actionScoringFragmentToFinishFragment(
                            viewModel.winnerr.value.toString()
                        )
                    )
            }
        })

        return binding.root
    }

}