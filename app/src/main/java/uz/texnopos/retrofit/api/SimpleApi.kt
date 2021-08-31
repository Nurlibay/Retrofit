package uz.texnopos.retrofit.api

import retrofit2.Response
import retrofit2.http.*
import uz.texnopos.retrofit.model.Post

interface SimpleApi {

//    @Headers(
//        "Authorization123456789",
//        "Platform Android"
//    )

    @GET("posts/1")
    suspend fun getPost(
        @Header("Auth") auth: String
    ): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPostByNumber(@Path("postNumber") postNumber: Int): Response<Post>

    @GET("posts")
    suspend fun getPostsByUserId(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>


    @GET("posts")
    suspend fun getCustomPosts(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<Post>>

    @POST("posts")
    suspend fun pushPost(
        @Body post : Post
    ): Response<Post>

    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Response<Post>
}