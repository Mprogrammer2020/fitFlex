package com.netset.fitness.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.CustomRepetitionsAdapter
import com.netset.fitness.adapters.TimeLineAdapter
import com.netset.fitness.databinding.FragmentWorkoutDetailsDescriptionBinding
import com.netset.fitness.utils.CommonFunction
import com.netset.models.CustomRepetitionsDataItems
import com.netset.models.TimeLineDataItems


class WorkoutDetailsDescriptionFragment : Fragment() {
  private lateinit var binding:FragmentWorkoutDetailsDescriptionBinding
    private var list:ArrayList<TimeLineDataItems> = ArrayList()
    private var customRepetitionsAdapter : CustomRepetitionsAdapter? = null

    private var customRepetitionsList:ArrayList<CustomRepetitionsDataItems> = ArrayList()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentWorkoutDetailsDescriptionBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)
        requireActivity().window.statusBarColor= ContextCompat.getColor(requireContext(),R.color.white)


        binding.workDetailsDescriptionToolbar.fragmentsText.text = ""

        binding.workDetailsDescriptionToolbar.backIcon.setImageResource(R.drawable.close)

        binding.workDetailsDescriptionToolbar.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.saveButton.setOnClickListener {
            CommonFunction.openFragment(
                requireActivity().supportFragmentManager,
                WorkoutScheduleFragment(),
                R.id.dashboardContainerView, true
            )
        }
        timeLineDataShow()
        customRepetitionsDataShow()
    }

    private fun customRepetitionsDataShow() {
        customRepetitionsList.clear()
        customRepetitionsList.add(CustomRepetitionsDataItems("",""))
        customRepetitionsList.add(CustomRepetitionsDataItems("420 Calories Burn","21"))
        customRepetitionsList.add(CustomRepetitionsDataItems("420 Calories Burn","22"))
        customRepetitionsList.add(CustomRepetitionsDataItems("420 Calories Burn","23"))
        customRepetitionsList.add(CustomRepetitionsDataItems("420 Calories Burn","24"))
        customRepetitionsList.add(CustomRepetitionsDataItems("420 Calories Burn","25"))
        customRepetitionsList.add(CustomRepetitionsDataItems("420 Calories Burn","26"))
        customRepetitionsList.add(CustomRepetitionsDataItems("420 Calories Burn","27"))
        customRepetitionsList.add(CustomRepetitionsDataItems("420 Calories Burn","28"))
        customRepetitionsList.add(CustomRepetitionsDataItems("420 Calories Burn","29"))
        customRepetitionsList.add(CustomRepetitionsDataItems("",""))


        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.customRepetitionsRecyclerView)

        binding.customRepetitionsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        customRepetitionsAdapter = CustomRepetitionsAdapter(requireContext(),customRepetitionsList)
        binding.customRepetitionsRecyclerView.adapter = customRepetitionsAdapter




        binding.customRepetitionsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val snapView = snapHelper.findSnapView(layoutManager)
                val snapPosition = snapView?.let { layoutManager.getPosition(it) } ?: -1

                for (i in 0 until layoutManager.itemCount) {
                    val view = layoutManager.findViewByPosition(i)
                    if (view != null) {
                        if (i == snapPosition) {
                            view.alpha = 1.0f
                            view.findViewById<View>(R.id.typeTimeText)?.visibility = View.VISIBLE
                            view.findViewById<View>(R.id.hideView)?.visibility = View.GONE

                            val time  =view.findViewById<TextView>(R.id.timesText)
                            time.textSize=22F

                        } else {
                            view.alpha = 0.5f
                            view.findViewById<View>(R.id.typeTimeText)?.visibility = View.GONE
                            view.findViewById<View>(R.id.hideView)?.visibility = View.VISIBLE
                            val time  =view.findViewById<TextView>(R.id.timesText)
                            time.textSize=19F





                        }
                        if (i == snapPosition + 1) {

                            view.findViewById<View>(R.id.bottomView)?.visibility = View.GONE
                        } else {

                            view.findViewById<View>(R.id.bottomView)?.visibility = View.VISIBLE

                        }
                    }
                }
            }
        })
    }

    private fun timeLineDataShow() {
        list.clear()
        list.add(TimeLineDataItems("01","Spread Your Arms","To make the gestures feel more relaxed, stretch your arms as you start this movement. No bending of hands."))
        list.add(TimeLineDataItems("02","Rest at The Toe","The basis of this movement is jumping. Now, what needs to be considered is that you have to use the tips of your feet"))
        list.add(TimeLineDataItems("03","Adjust Foot Movement","Jumping Jack is not just an ordinary jump. But, you also have to pay close attention to leg movements."))
        list.add(TimeLineDataItems("04","Clapping Both Hands","This cannot be taken lightly. You see, without realizing it, the clapping of your hands helps you to keep your rhythm while doing the Jumping Jack"))
        binding.timelineRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val trainingAdapter = TimeLineAdapter(requireContext(),list)
        binding.timelineRecyclerView.adapter = trainingAdapter
    }
}