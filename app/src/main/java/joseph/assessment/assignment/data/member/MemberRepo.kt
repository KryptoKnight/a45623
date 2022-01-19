package joseph.assessment.assignment.data.member

interface MemberRepo {
    fun getMembersRemote():List<Member>
    fun getMembersLocal():List<Member>
    fun addMembersLocal()

}