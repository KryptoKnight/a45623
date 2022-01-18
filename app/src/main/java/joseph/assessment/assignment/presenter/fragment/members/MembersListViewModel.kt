package joseph.assessment.assignment.presenter.fragment.members

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import joseph.assessment.assignment.data.member.Member
import joseph.assessment.assignment.domain.api.TandemApi
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MembersListViewModel(val api: TandemApi) : ViewModel() {




    private val _uiState = MutableLiveData<MembersListUIState>()
    val uiState: LiveData<MembersListUIState> = _uiState

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        //Timber.e(exception)
        exception.let { _uiState.postValue(MembersListUIState.Error(it.localizedMessage)) }
    }



    public fun fetchMembers(){
        viewModelScope.launch(exceptionHandler) {
            withContext(Dispatchers.IO) {
                val body = api.fetchMemberProfiles()
                body.response?.let { _uiState.postValue(MembersListUIState.Content(it)) }

            }
        }
    }


    sealed class MembersListUIState{
       public data class Content(val list:List<Member>): MembersListUIState()
        data class Error(val message:String):MembersListUIState()
    }

}