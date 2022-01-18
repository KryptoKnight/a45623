package joseph.assessment.assignment.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import joseph.assessment.assignment.data.member.Member


@Entity
class MemberEntity(var firstname:String){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}