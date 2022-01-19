package joseph.assessment.assignment.domain.member

import joseph.assessment.assignment.data.member.Member
import joseph.assessment.assignment.data.member.MemberRepo
import joseph.assessment.assignment.domain.api.TandemApi
import joseph.assessment.assignment.domain.db.dao.MemberProfileDAO

class MemberRepoImpl(val memberProfileDAO: MemberProfileDAO,val api:TandemApi) : MemberRepo {
    override fun getMembersRemote(): List<Member> {
        TODO("Not yet implemented")
    }

    override fun getMembersLocal(): List<Member> {
        TODO("Not yet implemented")
    }

    override fun addMembersLocal() {
        TODO("Not yet implemented")
    }
}