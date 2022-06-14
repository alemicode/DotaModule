package com.mohamadalemicode.core

sealed class ProgressBarState {
    object Loading:ProgressBarState()
    object Idle:ProgressBarState()

}