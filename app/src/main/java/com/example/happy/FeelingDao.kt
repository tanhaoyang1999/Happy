package com.example.happy

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FeelingDao {
    @Insert
    suspend fun insertFeeling(feeling: Feeling)

    @Update
    suspend fun updateFeeling(feeling:Feeling)

    @Delete
    suspend fun deleteFeeling(feeeling:Feeling)

    @Query("SELECT * FROM feeling")
    suspend fun getAllRecords(): LiveData<List<Feeling>>

    @Query("SELECT * FROM feeling WHERE id = :search_id")
    suspend fun getOneRecord(search_id:Int): Feeling
}