package uz.texnopos.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.texnopos.retrofit.repository.Repository

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}