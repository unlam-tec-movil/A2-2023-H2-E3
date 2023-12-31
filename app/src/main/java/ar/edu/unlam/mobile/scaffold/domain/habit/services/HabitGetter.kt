package ar.edu.unlam.mobile.scaffold.domain.habit.services

import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityEnd
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityStart
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow

interface HabitGetter {
    suspend fun updateHabitState(habit: Habit)
    suspend fun getHabit(): Flow<List<Habit>>
    suspend fun insertHabit(habit: Habit)
    suspend fun deleteHabitById(habitId: Long)

    // Activity
    suspend fun insertActivity(activity: Activity)
    suspend fun deleteActivityById(id: Long)
    suspend fun getAllActivities(): Flow<List<Activity>>

    suspend fun updateActivityState(activity: Activity)

    suspend fun insertStart(activityStart: ActivityStart)

    suspend fun selectStartById(id: Long): ActivityStart

    suspend fun insertEnd(activityEnd: ActivityEnd)

    suspend fun selectEndById(id: Long): ActivityEnd
}
