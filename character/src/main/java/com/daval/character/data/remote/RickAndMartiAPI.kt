package com.daval.character.data.remote

import com.daval.core.common.Constants
import retrofit2.http.GET

interface RickAndMartiAPI {
    @GET(Constants.END_POINT_CHARACTERS)
    suspend fun getCharacters(): ResponseCharacterDto
}