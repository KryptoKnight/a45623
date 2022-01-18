package joseph.assessment.assignment.presenter.fragment.members

import androidx.lifecycle.ViewModel
import joseph.assessment.assignment.data.member.Member

class MembersListViewModel : ViewModel() {
    // TODO: Implement the ViewModel





    public fun fetchMembers(){

    }


    sealed class MembersListUIState{
        data class Update(val list:List<Member>)
        data class Error(val message:String)
    }

}