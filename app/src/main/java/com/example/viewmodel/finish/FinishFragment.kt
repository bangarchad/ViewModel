package com.example.viewmodel.finish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentFinishBinding

class FinishFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentFinishBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_finish, container, false)

        var args = FinishFragmentArgs.fromBundle(arguments!!)

        binding.textselesai.text = args.name + " Menang"

        return binding.root
    }
}