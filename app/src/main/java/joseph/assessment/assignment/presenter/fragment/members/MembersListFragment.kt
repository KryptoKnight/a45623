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

class MembersListFragment : Fragment(R.layout.members_list_fragment) {


    val binding by lazy {
        MembersListFragmentBinding.inflate(layoutInflater)
    }
    val viewModel by viewModels<MembersListViewModel>()
    val adapter by lazy { MemberListViewAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildComponents()
        buildState()
    }

    private fun buildComponents(){
        binding.membersListRv.adapter = adapter
    }

    private fun buildState(){
        viewModel.uiState.observe(viewLifecycleOwner){
            when(it){
                is  MembersListViewModel.MembersListUIState.Content -> updateUI(it.list as MutableList<Member>)
                is  MembersListViewModel.MembersListUIState.Error -> showDialog(it.message)
            }
        }
    }

    fun updateUI(list : MutableList<Member>){
        adapter.setList(list)
    }

    fun showDialog(msg:String){

    }


}