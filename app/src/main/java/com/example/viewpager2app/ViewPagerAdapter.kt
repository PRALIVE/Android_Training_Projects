package com.example.viewpager2app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


//class ViewPagerAdapter(val list : List<Fragment>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
//    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        //val img = itemView.findViewById(R.id.image) as ImageView
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
//        return ViewPagerViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
////        val currImg = imagelist[position]
////        holder.img.setImageResource(currImg)
//    }
//}

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private val fragmentList: ArrayList<Fragment> = ArrayList()
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }
}