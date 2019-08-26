package com.easyhome.jrconsumer.mvp.ui.adapter

import android.support.v4.app.Fragment
import com.jess.arms.base.delegate.FragmentNavigatorAdapter
import com.easyhome.jrconsumer.mvp.ui.fragment.HomeFragment
import com.easyhome.jrconsumer.mvp.ui.fragment.MessageFragment
import com.easyhome.jrconsumer.mvp.ui.fragment.MyFragment


class HomeFragmentAdapter(val mTabs: Array<String>) : FragmentNavigatorAdapter {


    override fun getTag(index: Int): String = mTabs[index]

    override fun onCreateFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment.newInstance()
            1 -> MessageFragment.newInstance()
            else -> MyFragment.newInstance()
        }
    }


    override fun getCount(): Int = mTabs.count()
}