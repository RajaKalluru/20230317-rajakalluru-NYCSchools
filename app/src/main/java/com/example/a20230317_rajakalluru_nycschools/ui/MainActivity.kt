package com.example.a20230317_rajakalluru_nycschools.ui

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.a20230317_rajakalluru_nycschools.R
import com.example.a20230317_rajakalluru_nycschools.data.School

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(R.id.left_container, SchoolListFragment.newInstance(object :
            SchoolListFragment.SchoolListFragmentCallBacks {
            override fun onSelectedSchool(school: School) {
                displaySchoolDetails(school)
            }
        }))
    }

    private fun loadFragment(@IdRes fragmentContainer: Int, nextFragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val current = manager.findFragmentById(fragmentContainer)
        if (current == null) {
            transaction.add(fragmentContainer, nextFragment)
        } else {
            transaction.replace(fragmentContainer, nextFragment)
            transaction.addToBackStack(null)
        }
        if (!this.isDestroyed) {
            transaction.commit()
        }
    }

    private fun displaySchoolDetails(school: School) {
        loadFragment(R.id.right_container, SchoolDetailFragment.newInstance(school))
    }
}
