package com.app.educa.data

import com.app.educa.data.remote.ExhibitorRemoteDataSource
import com.app.educa.model.ExhibitorResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.app.educa.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class ExhibitorRepository @Inject constructor(
    private val exhibitorRemoteDataSource: ExhibitorRemoteDataSource
) {

    suspend fun fetchExhibitors(): Flow<Result<ExhibitorResponse>?> {
        return flow {
            emit(Result.loading())
            val result = exhibitorRemoteDataSource.fetchExhibitors()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}