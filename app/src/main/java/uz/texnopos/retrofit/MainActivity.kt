package uz.texnopos.retrofit

import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.texnopos.retrofit.adapter.PostAdapter
import uz.texnopos.retrofit.databinding.ActivityMainBinding
import uz.texnopos.retrofit.model.Post
import uz.texnopos.retrofit.repository.Repository
import android.os.Bundle as Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val postAdapter by lazy { PostAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        //viewModel.getPostsByUserId(3, "id", "desc")
        //val post = Post(7, 7, "Nurlibay", "Koshkinbaev")
        //viewModel.pushPost(post)

        //viewModel.pushPost2(7, 7, "Nurlibay", "DEV")

        viewModel.getPost("123456789 ")

        viewModel.myResponsePost.observe(this, Observer {
            if(it.isSuccessful){
                Log.d("post request", it.body().toString())
                Log.d("post request", it.code().toString())
                Log.d("post request", it.message())
                Log.d("post request", it.headers().toString())
            } else {
                Toast.makeText(this, it.code(), Toast.LENGTH_LONG ).show()
            }
        })

//        viewModel.myResponseByUserId.observe(this, Observer { response ->
//            if(response.isSuccessful) {
//                response.body()?.let {
//                    binding.rvPosts.adapter = postAdapter
//                    postAdapter.models = it
//                }
//            } else {
//                Toast.makeText(this, response.code(), Toast.LENGTH_LONG).show()
//            }
//        })
    }
}