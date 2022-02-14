package com.example.ivan.recyclerviewwithmultipletypes

import androidx.annotation.ColorInt


/**
 * 创建sealed class ：以对应不同结构的json处理
 * 里面的多种数据结构，而每种类型的模式，都是属于DataModel类型
 * 所以sealed class，其实就是class数据的Enum型
 */
sealed class DataModel {
    data class Header(
        @ColorInt val bgColor: Int,
        val title: String
    ) : DataModel()

    data class Family(
        val name: String,
        val relationship: String
    ) : DataModel()

    data class Friend(
        val name: String,
        val gender: String
    ) : DataModel()

    data class Colleague(
        val name: String,
        val organization: String,
        val designation: String
    ) : DataModel()
}
