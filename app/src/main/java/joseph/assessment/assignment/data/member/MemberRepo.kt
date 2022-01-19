package joseph.assessment.assignment.data.member

import androidx.lifecycle.LiveData
import joseph.assessment.assignment.data.member.model.Member

interface MemberRepo {
    suspend fun getMembersRemote():List<Member>?
    suspend fun getMembersLocal():LiveData<List<Member>>
    suspend fun addMembersLocal(vararg members:Member)

}