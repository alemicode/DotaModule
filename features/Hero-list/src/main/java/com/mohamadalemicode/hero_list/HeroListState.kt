package com.mohamadalemicode.hero_list

import android.widget.ProgressBar
import com.mohamadalemicode.core.core.domain.ProgressBarState
import com.mohamadalemicode.domain.Hero

data class HeroListState(

    val progressBaseState: ProgressBarState = ProgressBarState.Idle,
    val heroes: List<Hero> = listOf()
)
