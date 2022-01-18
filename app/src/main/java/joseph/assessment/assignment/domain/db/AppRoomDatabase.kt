package joseph.assessment.assignment.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import joseph.assessment.assignment.data.db.MemberEntity
import joseph.assessment.assignment.domain.db.dao.MemberProfileDAO

@Database(version = 2,entities = [MemberEntity::class],exportSchema = false)
abstract class AppRoomDatabase :RoomDatabase(){

    abstract fun getMemberDAO() : MemberProfileDAO
}