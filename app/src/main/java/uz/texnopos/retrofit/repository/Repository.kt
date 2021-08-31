package uz.texnopos.retrofit.repository

import retrofit2.Response
import uz.texnopos.retrofit.api.RetrofitInstance
import uz.texnopos.retrofit.model.Post

class Repository {

    suspend fun getPost(auth: String): Response<Post> {
       return RetrofitInstance.api.getPost(auth)
    }

    suspend fun getPostByNumber(postNumber: Int): Response<Post> {
        return RetrofitInstance.api.getPostByNumber(postNumber)
    }

    suspend fun getPostsByUserId(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getPostsByUserId(userId, sort, order)
    }

    suspend fun getCustomPosts(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts(userId, options)
    }

    suspend fun pushPost(post: Post) : Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushPost2(userId: Int, id: Int, title: String, body: String): Response<Post> {
        return RetrofitInstance.api.pushPost2(userId, id, title, body)
    }
}