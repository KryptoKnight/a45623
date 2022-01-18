package joseph.assessment.assignment.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import joseph.assessment.assignment.data.member.Member


@Entity
class MemberEntity(
    val firstName: String,
    val topic: String,
    val pictureUrl: String,
    val natives: List<String>,
    val learns: List<String>,
    val referenceCnt: Int,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)