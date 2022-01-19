package joseph.assessment.assignment.domain.api

import joseph.assessment.assignment.data.api.ApiResponse
import joseph.assessment.assignment.data.member.model.Member
import retrofit2.http.GET

interface TandemApi {

    @GET("api/community_1.json")
    suspend fun fetchMemberProfiles(): ApiResponse<List<Member>>

}