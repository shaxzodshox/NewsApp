package com.shlsoft.newsapp.db

import androidx.room.TypeConverter
import com.shlsoft.newsapp.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: com.shlsoft.newsapp.models.Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): com.shlsoft.newsapp.models.Source {
        return Source(name, name)
    }
}