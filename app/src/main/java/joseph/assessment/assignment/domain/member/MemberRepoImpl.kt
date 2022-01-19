package joseph.assessment.assignment.domain.member

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import joseph.assessment.assignment.data.db.MemberEntity
import joseph.assessment.assignment.data.member.model.Member
import joseph.assessment.assignment.data.member.MemberRepo
import joseph.assessment.assignment.domain.api.TandemApi
import joseph.assessment.assignment.domain.db.dao.MemberProfileDAO

class MemberRepoImpl(val memberProfileDAO: MemberProfileDAO,val api:TandemApi) : MemberRepo {

    override suspend fun getMembersRemote(): List<Member>? {
        return api.fetchMemberProfiles().response
    }

    override suspend fun getMembersLocal(): LiveData<List<Member>> {
        return memberProfileDAO.fetchAllMembers().map { toMemberList(it) }
    }

    override suspend fun addMembersLocal(vararg members:Member) {
        memberProfileDAO.addMembers(*toMemberEntityList(members.toList()).toTypedArray())
    }

    fun toMemberEntityList(list : List<Member>):List<MemberEntity>{
        return list.map { MemberEntity(it.firstName,it.topic,it.pictureUrl,it.natives,it.learns,it.referenceCnt,it.liked) }
    }

    fun toMemberList(list : List<MemberEntity>):List<Member>{
        return list.map { Member(it.firstName,it.topic,it.pictureUrl,it.natives,it.learns,it.referenceCnt,it.liked) }
    }
}