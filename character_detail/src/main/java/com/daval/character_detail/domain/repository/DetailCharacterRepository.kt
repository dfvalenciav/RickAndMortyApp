package com.daval.character_detail.domain.repository

import com.daval.character_detail.data.remote.dto.ResponseCharacterDetailDto

interface DetailCharacterRepository {

    suspend fun getDetailCharacter(): ResponseCharacterDetailDto
}