package com.daval.character.presentation

import com.daval.character.domain.model.CharacterItem
import com.daval.core.utils.emptyValue

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<CharacterItem> = emptyList(),
    val error: String = String.emptyValue()
)
