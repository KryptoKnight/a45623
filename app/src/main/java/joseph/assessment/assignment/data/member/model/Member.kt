package joseph.assessment.assignment.data.member.model

open class Member(
    val firstName:String,
    val topic:String,
    val pictureUrl:String,
    val natives:List<String>,
    val learns:List<String>,
    val referenceCnt:Int,
    val liked:Boolean = false
    )