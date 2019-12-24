package com.example.happy

import androidx.lifecycle.LiveData
import com.example.happy.Feeling
import com.example.happy.FeelingDao

class FeelingRepository(private val feelingDao: FeelingDao) {
    val allFeelings: LiveData<List<Feeling>> = feelingDao.getAllRecords()
    suspend fun insertFeeling(feeling: Feeling) {
        feelingDao.insertFeeling(feeling)
    }
}