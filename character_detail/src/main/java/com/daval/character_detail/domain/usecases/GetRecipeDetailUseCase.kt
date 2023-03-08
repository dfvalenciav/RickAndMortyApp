package com.daval.character_detail.domain.usecases

import com.daval.character_detail.data.remote.dto.toRecipeDetail
import com.daval.character_detail.domain.model.CharacterDetail
import com.daval.character_detail.domain.repository.DetailCharacterRepository
import com.daval.core.common.Constants
import com.daval.core.common.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class GetRecipeDetailUseCase @Inject constructor(
    private val repository: DetailCharacterRepository
) {
    operator fun invoke(): Flow<Resource<CharacterDetail>> = flow {
        try {
            emit(Resource.Loading())
            val responseDetailRecipeDto = repository.getDetailCharacter()
            delay(1_000)
            emit(Resource.Success(responseDetailRecipeDto.data.toRecipeDetail()))
        } catch (e: HttpException) {
            emit(Resource.Error(Constants.GENERIC_ERROR))
        } catch (e: IOException) {
            emit(Resource.Error(Constants.NETWORK_ERROR))
        } catch (e: Exception) {
            emit(Resource.Error(Constants.GENERIC_ERROR))
        }
    }
}