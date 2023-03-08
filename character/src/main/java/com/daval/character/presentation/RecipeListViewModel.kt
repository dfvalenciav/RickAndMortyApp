package com.daval.character.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daval.character.domain.model.CharacterItem
import com.daval.character.domain.usescases.characterItem.FilterRecipesUseCase
import com.daval.character.domain.usescases.characterItem.GetRecipeListUseCase
import com.daval.core.common.Constants
import com.daval.core.common.Resource
import com.daval.core.utils.emptyValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val getRecipeListUseCase: GetRecipeListUseCase,
    private val filterRecipesUseCase: FilterRecipesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CharacterListState())
    val state: State<CharacterListState> = _state

    private val _searchQuery = mutableStateOf(String.emptyValue())
    val searchQuery: State<String> = _searchQuery

    private var searchJob: Job? = null

    private lateinit var recipes: List<CharacterItem>
    private lateinit var recipesFiltered: List<CharacterItem>

    init {
        getRecipeList()
    }

    private fun getRecipeList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getRecipeListUseCase().onEach { result ->
                    configureState(result)
                }
            }.launchIn(this)
        }
    }

    fun searchRecipes(query: String) {
        _searchQuery.value = query

        searchJob?.cancel()

        searchJob = viewModelScope.launch {
            delay(500L)

            withContext(Dispatchers.IO) {
                filterRecipesUseCase(recipes, query.lowercase()).onEach { result ->
                    configureState(result, true)
                }
            }.launchIn(this)
        }
    }

    private fun configureState(result: Resource<List<CharacterItem>>, searchMode: Boolean = false) {
        when (result) {
            is Resource.Success -> {
                if (searchMode) {
                    recipesFiltered = result.data ?: emptyList()
                } else {
                    recipes = result.data ?: emptyList()
                    recipesFiltered = recipes
                }
                _state.value = state.value.copy(
                    isLoading = false,
                    characters = recipesFiltered
                )
            }
            is Resource.Error -> {
                recipes = emptyList()
                recipesFiltered = recipes

                _state.value = state.value.copy(
                    isLoading = false,
                    characters = emptyList(),
                    error = result.message ?: Constants.UNKNOWN_ERROR
                )
            }
            is Resource.Loading -> {
                _state.value = state.value.copy(
                    isLoading = true,
                    characters = emptyList(),
                    error = String.emptyValue()
                )
            }
        }
    }
}