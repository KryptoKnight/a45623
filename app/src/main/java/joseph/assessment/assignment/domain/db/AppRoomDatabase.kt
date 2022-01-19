package joseph.assessment.assignment.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import joseph.assessment.assignment.data.db.MemberEntity
import joseph.assessment.assignment.domain.db.converters.StringListConverter
import joseph.assessment.assignment.domain.db.dao.LikeDAO
import joseph.assessment.assignment.domain.db.dao.MemberProfileDAO

@Database(version = 4,entities = [MemberEntity::class],exportSchema = false)
@TypeConverters(StringListConverter::class)
abstract class AppRoomDatabase :RoomDatabase(){

    abstract fun getMemberDAO() : MemberProfileDAO

    abstract fun getLikeDAO() : LikeDAO
}