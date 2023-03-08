package com.daval.character_detail.presentation

import com.daval.character_detail.domain.model.CharacterDetail
import com.daval.core.utils.emptyValue

data class DetailRecipeState(
    val isLoading: Boolean = false,
    val recipe: CharacterDetail? = null,
    val error: String = String.emptyValue()
)
