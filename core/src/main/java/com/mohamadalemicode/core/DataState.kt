package com.mohamadalemicode.core

import android.widget.ProgressBar

sealed class DataState<T> {
    data class Response<T>(
        val uiComponent: UIComponent
    ) : DataState<T>()

    data class Data<T>(
        val data: T? = null,

        ):DataState<T>()

    data class Loading<T>(
        val progressBar:ProgressBarState = ProgressBarState.Idle
    ):DataState<T>()
}