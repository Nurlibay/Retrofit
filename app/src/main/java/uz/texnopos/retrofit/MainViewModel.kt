package uz.texnopos.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import uz.texnopos.retrofit.model.Post
import uz.texnopos.retrofit.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {

    var myResponsePost : MutableLiveData<Response<Post>> = MutableLiveData()
    var myResponseByPostNumber : MutableLiveData<Response<Post>> = MutableLiveData()
    var myResponseByUserId : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    var myCustomPosts : MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost(auth: String){
        viewModelScope.launch {
            val response = repository.getPost(auth)
            myResponsePost.value = response
        }
    }

    fun getPostByNumber(postNumber: Int){
        viewModelScope.launch {
            val response = repository.getPostByNumber(postNumber)
            myResponseByPostNumber.value = response
        }
    }

    fun getPostsByUserId(userId: Int, sort: String, order: String){
        viewModelScope.launch {
            val response = repository.getPostsByUserId(userId, sort, order)
            myResponseByUserId.value = response
        }
    }

    fun getCustomPosts(userId: Int, options: Map<String, String>){
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId, options)
            myCustomPosts.value = response
        }
    }

    fun pushPost(post: Post) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponsePost.value = response
        }
    }

    // userId: Int, id: Int, title: String, body: String

    fun pushPost2(userId: Int, id: Int, title: String, body: String) {
        viewModelScope.launch {
            val response = repository.pushPost2(userId, id, title, body)
            myResponsePost.value = response
        }
    }

}