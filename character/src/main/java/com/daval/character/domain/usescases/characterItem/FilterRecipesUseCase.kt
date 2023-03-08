package com.daval.character.domain.usescases.characterItem

import com.daval.character.domain.model.CharacterItem
import com.daval.core.common.Constants
import com.daval.core.common.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FilterRecipesUseCase @Inject constructor() {

    operator fun invoke(characters: List<CharacterItem>, query: String) : Flow<Resource<List<CharacterItem>>> = flow {
        try {
            emit(Resource.Loading())
            val charactersFiltered = characters.filter {
                ( it.species.lowercase().contains(query) || it.name.lowercase().contains(query))
            }
            delay(2_000)
            emit(Resource.Success(charactersFiltered))
        } catch (e: Exception) {
            emit(Resource.Error(Constants.GENERIC_ERROR))
        }
    }

}