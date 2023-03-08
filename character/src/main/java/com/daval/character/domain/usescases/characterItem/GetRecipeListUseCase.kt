package com.daval.character.domain.usescases.characterItem

import com.daval.character.data.remote.dto.toCharacterItem
import com.daval.character.domain.model.CharacterItem
import com.daval.character.domain.repository.CharacterRepository
import com.daval.core.common.Constants
import com.daval.core.common.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class GetRecipeListUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    operator fun invoke() : Flow<Resource<List<CharacterItem>>> = flow {

        try {
            emit(Resource.Loading())
            val responseRecipeDto = repository.getCharacters()
            val recipeList = responseRecipeDto.data.map { it.toCharacterItem() }
            delay(2_000)
            emit(Resource.Success(recipeList))
        } catch (e: HttpException) {
            emit(Resource.Error(Constants.GENERIC_ERROR))
        } catch (e: IOException) {
            emit(Resource.Error(Constants.NETWORK_ERROR))
        } catch (e: Exception) {
            emit(Resource.Error(Constants.GENERIC_ERROR))
        }

    }

}