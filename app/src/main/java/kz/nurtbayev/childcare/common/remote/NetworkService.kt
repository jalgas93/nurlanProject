package kz.nurtbayev.childcare.common.remote


import kz.nurtbayev.childcare.content.child.models.AddNewChildResponse
import kz.nurtbayev.childcare.content.child.models.ChildrenResponse
import kz.nurtbayev.childcare.content.personal_informations.models.GetCitiesResponse
import kz.nurtbayev.childcare.content.ui.home.models.CategoriesResponse
import kz.nurtbayev.childcare.content.ui.hospitals.models.HospitalResponse
import kz.nurtbayev.childcare.content.ui.likes.models.ArticleModel
import kz.nurtbayev.childcare.content.ui.likes.models.ArticleResponseModel
import kz.nurtbayev.childcare.sign_in.models.AuthRequest
import kz.nurtbayev.childcare.sign_in.models.AuthResponse
import kz.nurtbayev.childcare.sign_up.models.SignUpRequest
import kz.nurtbayev.childcare.sign_up.models.SignUpResponse
import retrofit2.Response
import retrofit2.http.*


interface NetworkService {

    @POST(EndPoints.SIGN_IN)
    suspend fun signIn(@Body authRequest: AuthRequest): Response<AuthResponse>

    @POST(EndPoints.SIGN_UP)
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<SignUpResponse>

    @GET(EndPoints.GET_CITIES)
    suspend fun getCities(): Response<GetCitiesResponse>

    @GET(EndPoints.GET_ORGANIZATIONS)
    suspend fun getOrganizations(): Response<HospitalResponse>

    @GET(EndPoints.GET_ARTICLES)
    suspend fun getArticles(): Response<ArticleResponseModel>
    @GET(EndPoints.GET_ARTICLES)
    suspend fun getArticlesModel(): Response<ArticleModel>

    @GET(EndPoints.GET_CHILDREN)
    suspend fun getChildren(): Response<ChildrenResponse>

    @FormUrlEncoded
    @POST(EndPoints.POST_CHILDREN)
    @Headers("Accept: Application/JSON")
    suspend fun createChildren(
        @Field("birthDate") birthDate: String,
        @Field("disease") disease: String,
        @Field("gender") gender: String,
        @Field("height") height: Int,
        @Field("id") id: Int,
        @Field("nickname") nickname: String,
        @Field("parentId")parentId: Int,
        @Field("weight") weight: Int
    ): Response<AddNewChildResponse>

    @GET(EndPoints.GET_CATEGORIES)
    suspend fun getCategories(): Response<CategoriesResponse>
}