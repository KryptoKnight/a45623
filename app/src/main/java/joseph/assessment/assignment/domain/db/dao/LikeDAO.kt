package joseph.assessment.assignment.domain.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import joseph.assessment.assignment.data.db.LikeEntity


@Dao
interface LikeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateLike(update:LikeEntity)

    @Query("select * from LikeEntity")
    fun getLikes():LiveData<List<LikeEntity>>
}