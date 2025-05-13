package com.mwikali.greenhub.ui.theme.models

import com.mwikali.greenhub.ui.theme.Screens.home.Reward
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class RewardViewModel : ViewModel() {
    private val _rewards = MutableStateFlow(
        listOf(
            Reward("Daily Streak Bonus", "Earned for 5-day login streak", 0),
            Reward("Focus Master", "Completed 10 Pomodoro sessions", 100),
            Reward("Zen Badge", "30 minutes of mindfulness", 150),
            Reward("Premium Unlock", "Redeem 1000 points", 1000),
            Reward("Eco Hero Badge", "Completed 10 Pomodoro sessions for eco tasks", 100)
        )
    )

    val rewards: StateFlow<List<Reward>> = _rewards
}
