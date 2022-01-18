package joseph.assessment.assignment.presenter.fragment.members

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import joseph.assessment.assignment.data.member.Member
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MembersListViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        //Timber.e(exception)

    }



    public fun fetchMembers(){
        viewModelScope.launch(exceptionHandler) {
            withContext(Dispatchers.IO) {

            }
        }
    }


    sealed class MembersListUIState{
        data class Update(val list:List<Member>)
        data class Error(val message:String)
    }

}