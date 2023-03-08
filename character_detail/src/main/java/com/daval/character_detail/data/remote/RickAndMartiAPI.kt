package com.daval.character_detail.data.remote

import com.daval.character_detail.data.remote.dto.ResponseCharacterDetailDto
import com.daval.core.common.Constants
import retrofit2.http.GET

interface RickAndMartiAPI {
    @GET(Constants.END_POINT_DETAIL_CHARACTERS)
    suspend fun getCharacters(): ResponseCharacterDetailDto
}