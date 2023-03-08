package com.daval.character.data.repository

import com.daval.character.data.remote.ResponseCharacterDto
import com.daval.character.data.remote.RickAndMartiAPI
import com.daval.character.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMartiAPI
) : CharacterRepository {

    override suspend fun getCharacters(): ResponseCharacterDto {
        return api.getCharacters()
    }
}