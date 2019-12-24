package com.example.happy

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FeelingViewModel {
    class FeelingViewModel (application: Application): AndroidViewModel(application){
        private val repository: FeelingRepository
        val allFeelings : LiveData<List<Feeling>>
        init{
            val feelingDao :FeelingDao = FeelingDatabase.getDatabase(application).feelingDao()
            repository = FeelingRepository(feelingDao)
            allFeelings = repository.allFeelings
        }
        fun insertFeeling(feeling: Feeling) = viewModelScope.launch{
            repository.insertFeeling((feeling))
        }
    }
}