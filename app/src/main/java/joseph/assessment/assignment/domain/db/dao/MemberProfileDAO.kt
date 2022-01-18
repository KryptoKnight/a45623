package joseph.assessment.assignment.domain.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import joseph.assessment.assignment.data.db.MemberEntity
import joseph.assessment.assignment.data.member.Member

@Dao
interface MemberProfileDAO{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMembers(vararg members:MemberEntity)

    @Query("Select * from MemberEntity")
    fun fetchAllMembers() : LiveData<List<MemberEntity>>
}
