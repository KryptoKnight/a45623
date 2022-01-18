package joseph.assessment.assignment.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import joseph.assessment.assignment.domain.db.dao.MemberProfileDAO

@Database(version = 1,entities = [])
abstract class AppRoomDatabase :RoomDatabase(){

    abstract fun getMemberDAO() : MemberProfileDAO
}