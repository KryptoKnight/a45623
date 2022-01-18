package joseph.assessment.assignment.domain.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import joseph.assessment.assignment.data.db.MemberEntity


class StringListConverter {
    @TypeConverter
    fun fromString(value: String?): List<String>? {
        val listOfMyClassObject =
            object : TypeToken<List<String>?>() {}.type
        return value?.let {
            Gson().fromJson(
                it,
                listOfMyClassObject
            )
        }
    }

    @TypeConverter
    fun fromList(memberList: List<String>?): String? {
        return memberList?.let { Gson().toJson(it) }
    }
}