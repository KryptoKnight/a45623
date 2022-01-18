package joseph.assessment.assignment.data.db

import androidx.room.Entity
import joseph.assessment.assignment.data.member.Member

@Entity
class MemberEntity(val firstname:String) : Member(firstname) {
}