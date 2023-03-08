package com.daval.character.data.remote.dto

import com.daval.character.domain.model.CharacterItem
import com.google.gson.annotations.SerializedName

data class CharacterDTO(
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("gender")
    val gender: String
)
fun CharacterDTO.toCharacterItem(): CharacterItem {
    return CharacterItem(
        id,
        gender,
        status,
        name,
        image,
        species
    )
}
