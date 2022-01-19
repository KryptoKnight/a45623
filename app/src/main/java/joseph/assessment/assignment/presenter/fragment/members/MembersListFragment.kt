package joseph.assessment.assignment.presenter.fragment.members

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import joseph.assessment.assignment.R
import joseph.assessment.assignment.data.member.model.Member
import joseph.assessment.assignment.databinding.MembersListFragmentBinding
import ke.co.equitybank.oneequity.extensions.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MembersListFragment : Fragment(R.layout.members_list_fragment) {


    private val binding by viewBinding ( MembersListFragmentBinding::bind )
    private val viewModel:MembersListViewModel  by viewModel()
    private val adapter by lazy { MemberListViewAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildComponents()
        buildState()
    }

    override fun onResume() {
        super.onResume()


    }

    private fun buildComponents(){
        binding.apply{
            membersListRv.adapter = adapter
            binding.swipeRefreshWidget.setOnRefreshListener { viewModel.fetchMembers() }
        }
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
        stopSwipe()
    }

    fun showDialog(msg:String){
        Toast.makeText(requireContext(),"$msg",Toast.LENGTH_LONG).show()
        stopSwipe()
    }

    fun stopSwipe(){
        binding.swipeRefreshWidget.isRefreshing = false
    }




}