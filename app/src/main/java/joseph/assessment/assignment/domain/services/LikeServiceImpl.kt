package joseph.assessment.assignment.domain.services

import joseph.assessment.assignment.data.like.LikeService
import joseph.assessment.assignment.data.like.model.Like
import joseph.assessment.assignment.domain.db.dao.LikeDAO

class LikeServiceImpl(val likeDAO: LikeDAO) : LikeService {

    override fun updateLike(like:Like): Boolean {
        TODO("Not yet implemented")
    }

}