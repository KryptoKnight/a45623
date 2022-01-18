package joseph.assessment.assignment.presenter.fragment.members

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import joseph.assessment.assignment.R

class MembersListFragment : Fragment() {

    companion object {
        fun newInstance() = MembersListFragment()
    }

    private lateinit var viewModel: MembersListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.members_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MembersListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}