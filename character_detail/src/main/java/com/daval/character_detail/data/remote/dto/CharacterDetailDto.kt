package com.daval.character_detail.data.remote.dto

import com.daval.character_detail.domain.model.CharacterDetail
import com.google.gson.annotations.SerializedName

data class CharacterDetailDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)

fun CharacterDetailDto.toRecipeDetail() = CharacterDetail(
    id,
    title,
    status,
    image,
    name,
    gender,
    type
)
