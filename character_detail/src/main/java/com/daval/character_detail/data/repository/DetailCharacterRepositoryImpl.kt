package com.daval.character_detail.data.repository

import com.daval.character_detail.data.remote.RickAndMartiAPI
import com.daval.character_detail.data.remote.dto.ResponseCharacterDetailDto
import com.daval.character_detail.domain.repository.DetailCharacterRepository
import javax.inject.Inject

class DetailCharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMartiAPI
) : DetailCharacterRepository {

    override suspend fun getDetailCharacter(): ResponseCharacterDetailDto {
        return api.getCharacters()
    }
}