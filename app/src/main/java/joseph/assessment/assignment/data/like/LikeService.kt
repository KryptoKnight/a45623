package joseph.assessment.assignment.data.like

import joseph.assessment.assignment.data.like.model.Like

interface LikeService {
    fun updateLike(like:Like):Boolean
}