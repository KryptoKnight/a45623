package joseph.assessment.assignment.domain.services

import joseph.assessment.assignment.data.db.LikeEntity
import joseph.assessment.assignment.data.like.LikeService
import joseph.assessment.assignment.data.like.model.Like
import joseph.assessment.assignment.domain.db.dao.LikeDAO

class LikeServiceImpl(val likeDAO: LikeDAO) : LikeService {

    override fun updateLike(like:Like) {
        likeDAO.updateLike(LikeEntity(like.memberId,like.update,like.id))
    }

    fun fromLikeEntity(likeEntityList:List<LikeEntity>):List<Like>{
        return likeEntityList.map { Like(it.memberId,it.update,it.id) }
    }

    fun fromLike(likeList:List<Like>):List<LikeEntity>{
        return likeList.map { LikeEntity(it.memberId,it.update,it.id) }
    }

}