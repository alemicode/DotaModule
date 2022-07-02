package com.mohamadalemicode.core.core.domain

sealed class ProgressBarState{
    
    object Loading: ProgressBarState()
    
    object Idle: ProgressBarState()
}