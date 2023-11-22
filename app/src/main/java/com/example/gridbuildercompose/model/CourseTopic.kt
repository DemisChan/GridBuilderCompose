package com.example.gridbuildercompose.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CourseTopic(
    @StringRes val topicName: Int,
    val count: Int,
    @DrawableRes val imageRes: Int
 )
