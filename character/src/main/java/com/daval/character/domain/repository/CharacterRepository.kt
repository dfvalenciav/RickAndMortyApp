package com.daval.character.domain.repository

import com.daval.character.data.remote.ResponseCharacterDto

interface CharacterRepository {
    suspend fun getCharacters(): ResponseCharacterDto
}