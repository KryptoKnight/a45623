package joseph.assessment.assignment.data.db

import androidx.room.Entity

@Entity
class LikeEntity(val memberId:Int, val update:Boolean,val id:Int)