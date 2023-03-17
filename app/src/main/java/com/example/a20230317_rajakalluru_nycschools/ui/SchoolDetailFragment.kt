package com.example.a20230317_rajakalluru_nycschools.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a20230317_rajakalluru_nycschools.R
import com.example.a20230317_rajakalluru_nycschools.data.SatScore
import com.example.a20230317_rajakalluru_nycschools.data.School
import com.example.a20230317_rajakalluru_nycschools.databinding.SchoolDetailsFragmentBinding
import com.example.a20230317_rajakalluru_nycschools.viewmodel.SchoolViewModel

class SchoolDetailFragment : Fragment() {
    private var binding: SchoolDetailsFragmentBinding? = null
    private var school: School? = null
    private lateinit var schoolViewModel: SchoolViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SchoolDetailsFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiateView()
    }

    private fun initiateView() {
        binding?.let { it ->
            var selectedSatScore: SatScore? = null
            it.schoolName.text = school?.schoolName
            it.schoolBoro.text = school?.boro
            it.schoolDescription.text = school?.description
            schoolViewModel = ViewModelProvider(this)[SchoolViewModel::class.java]
            var scoreList: List<SatScore>?
            schoolViewModel.getSatScoreList().observe(viewLifecycleOwner) {
                scoreList = it
                if (!scoreList.isNullOrEmpty()) {
                    for (satScore in scoreList!!) {
                        if (school?.dbn == satScore.dbn) {
                            selectedSatScore = satScore
                        }
                    }
                }
                if (selectedSatScore != null) {
                    binding?.lblMath?.text = selectedSatScore!!.mathScore
                    binding?.lblCriticalReading?.text = selectedSatScore!!.criticalReadingScore
                    binding?.lblWriting?.text = selectedSatScore!!.writingScore
                } else {
                    binding?.lblMath?.text = getString(R.string.not_available)
                    binding?.lblCriticalReading?.text = getString(R.string.not_available)
                    binding?.lblWriting?.text = getString(R.string.not_available)
                }
            }
        }
    }

    companion object {
        fun newInstance(
            selectedSchool: School
        ): SchoolDetailFragment {
            return SchoolDetailFragment().apply {
                school = selectedSchool
            }
        }
    }
}
