package joseph.assessment.assignment.presenter.fragment.members

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import joseph.assessment.assignment.R
import joseph.assessment.assignment.data.member.Member
import joseph.assessment.assignment.databinding.MemberViewitemLayoutBinding
import joseph.assessment.assignment.databinding.MembersListFragmentBinding
import org.koin.*;
import org.koin.androidx.viewmodel.ext.android.viewModel

class MembersListFragment : Fragment(R.layout.members_list_fragment) {


    private val binding by lazy {
        MembersListFragmentBinding.inflate(layoutInflater)
    }
    private val viewModel:MembersListViewModel  by viewModel<MembersListViewModel>()
    private val adapter by lazy { MemberListViewAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        buildComponents()
        buildState()

    }

    private fun buildComponents(){
        print("kkkkkkkkkkkkkkkkkkkkkkkkkkkk")
        binding.membersListRv.adapter = adapter
        binding.swipeRefreshWidget.setOnRefreshListener { viewModel.fetchMembers() }
        binding.button.setOnClickListener { viewModel.fetchMembers() }
    }

    private fun buildState(){
        viewModel.uiState.observe(viewLifecycleOwner){
            when(it){
                is  MembersListViewModel.MembersListUIState.Content -> updateUI(it.list as MutableList<Member>)
                is  MembersListViewModel.MembersListUIState.Error -> showDialog(it.message)
            }
        }
        viewModel.fetchMembers()
    }

    fun updateUI(list : MutableList<Member>){
        adapter.setList(list)
        adapter.notifyDataSetChanged()
    }

    fun showDialog(msg:String){

    }




}