package com.mehmetkucuk.newsapp.db

import androidx.room.TypeConverter
import com.mehmetkucuk.newsapp.models.Source

class Convertes {
    @TypeConverter
    fun fromSource (source: Source): String{
        return source.name
    }
    @TypeConverter
    fun toSource (name: String): Source{
        return Source(name, name)
    }
}