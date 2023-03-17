package com.example.a20230317_rajakalluru_nycschools.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a20230317_rajakalluru_nycschools.data.School
import com.example.a20230317_rajakalluru_nycschools.databinding.SchoolListFragmentBinding
import com.example.a20230317_rajakalluru_nycschools.viewmodel.SchoolViewModel

class SchoolListFragment : Fragment() {

    private var binding: SchoolListFragmentBinding? = null
    lateinit var adapter: SchoolListAdapter
    private var schoolListFragmentCallBacks: SchoolListFragmentCallBacks? = null
    private lateinit var schoolListViewModel: SchoolViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SchoolListFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiateView()
    }

    private fun initiateView() {
        binding?.schoolList?.let {
            adapter = SchoolListAdapter(object : SchoolListAdapter.SchoolListAdapterCallback {
                override fun onItemSelected(school: School) {
                    schoolListFragmentCallBacks?.onSelectedSchool(school)
                }

            })

            it.layoutManager = LinearLayoutManager(context)
            val decoration = DividerItemDecoration(
                it.context,
                (it.layoutManager as LinearLayoutManager).orientation
            )
            it.adapter = adapter
            it.addItemDecoration(decoration)

            schoolListViewModel = ViewModelProvider(this)[SchoolViewModel::class.java]
            schoolListViewModel.getSchoolList().observe(viewLifecycleOwner) { schoolList ->
                adapter.submitList(schoolList)
            }
        }
    }

    companion object {
        fun newInstance(callbacks: SchoolListFragmentCallBacks): SchoolListFragment {
            return SchoolListFragment().apply {
                schoolListFragmentCallBacks = callbacks
            }
        }
    }

    interface SchoolListFragmentCallBacks {
        fun onSelectedSchool(school: School)
    }
}
