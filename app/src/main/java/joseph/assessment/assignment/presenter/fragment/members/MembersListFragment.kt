package joseph.assessment.assignment.presenter.fragment.members

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import joseph.assessment.assignment.R

class MembersListFragment : Fragment() {


    val viewModel by viewModels<MembersListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.members_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.uiState.observe(viewLifecycleOwner){
             when(it){
               is  MembersListViewModel.MembersListUIState.Content -> updateUI()
               is  MembersListViewModel.MembersListUIState.Error -> showDialog()
             }
        }
    }

    fun updateUI(){

    }

    fun showDialog(){

    }


}