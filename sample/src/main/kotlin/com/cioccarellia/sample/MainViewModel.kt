package com.cioccarellia.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cioccarellia.lib.ComplexNumber
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.random.Random

class MainViewModel @Inject constructor() : ViewModel() {
    private val _complexFlow = flow {
        while (true) {
            delay(150)
            emit(
                ComplexNumber(Random.nextInt(-100, 100), Random.nextInt(-100, 100))
            )
        }
    }

    val complexFLow = _complexFlow.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        ComplexNumber.origin()
    )
}