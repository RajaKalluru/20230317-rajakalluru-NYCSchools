package com.example.a20230317_rajakalluru_nycschools.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a20230317_rajakalluru_nycschools.data.School
import com.example.a20230317_rajakalluru_nycschools.databinding.AdapterSchoolListBinding

class SchoolListAdapter constructor(
    private val schoolListAdapterCallback: SchoolListAdapterCallback
) : ListAdapter<School, SchoolListAdapter.SchoolListViewHolder>
    (SchoolDiffCallback()) {
    private lateinit var binding: AdapterSchoolListBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolListViewHolder {
        binding = AdapterSchoolListBinding.inflate(LayoutInflater.from(parent.context))
        return SchoolListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SchoolListViewHolder, position: Int) {
        val school = getItem(position)
        binding.showDetailsButton.setOnClickListener {
            schoolListAdapterCallback.onItemSelected(school)
        }
        holder.bind(school)
    }

    private class SchoolDiffCallback : DiffUtil.ItemCallback<School>() {
        override fun areItemsTheSame(oldItem: School, newItem: School): Boolean {
            return oldItem.dbn == newItem.dbn
        }

        override fun areContentsTheSame(oldItem: School, newItem: School): Boolean {
            return oldItem == newItem
        }

    }

    class SchoolListViewHolder(private val binding: AdapterSchoolListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(school: School) {
            with(binding) {
                school.apply {
                    lblSchoolName.text = schoolName
                    lblDbn.text = dbn
                }
            }
        }
    }

    interface SchoolListAdapterCallback {
        fun onItemSelected(school: School)
    }
}
