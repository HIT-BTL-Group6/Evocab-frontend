package com.example.evocab.ui.classroom

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evocab.databinding.FragmentClassroomBinding
import com.example.evocab.model.Classroom
import com.example.evocab.ui.profile.ProfileAdapter
import com.example.sourcebase.base.BaseFragment

class ClassroomFragment : BaseFragment<FragmentClassroomBinding>(FragmentClassroomBinding::inflate) {

    private val classroomAdapter by lazy {
        ListClassAdapter{{} }
    }

    override val viewModel: ClassroomViewModel
        get() = ViewModelProvider(this)[ClassroomViewModel::class.java]

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {
    }

    override fun handleEvent() {
    }

    override fun bindData() {
        val v1: Classroom = Classroom(1, "mother", "sdsdfs",true)
        val v2: Classroom = Classroom(2, "father", "sdsdfs",true)
        val v3: Classroom = Classroom(3, "sister", "sdsdfs",true)
        val v4: Classroom = Classroom(1, "mother", "sdsdfs",true)
        val v5: Classroom = Classroom(2, "father", "sdsdfs",true)
        val v6: Classroom = Classroom(3, "sister", "sdsdfs",true)
        val v7: Classroom = Classroom(2, "father", "sdsdfs",true)
        val v8: Classroom = Classroom(3, "sister", "sdsdfs",true)
        val v9: Classroom = Classroom(1, "mother", "sdsdfs",true)

        val classrooms= listOf(v1, v2, v3,v4,v5,v6,v7,v8,v9)
        classroomAdapter.submitList(classrooms)
        binding.rcvMessages.layoutManager = LinearLayoutManager(context)
        binding.rcvMessages.adapter = classroomAdapter
    }

}