package com.shlsoft.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shlsoft.newsapp.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile //Volatile - Other threads can immediately see when thread changes this instance
        private var instance: ArticleDatabase? = null
        private val LOCK = Any() //This is for checking only one database instance or not

        //invoke - it will automatically called whenever we create instance of this class
        //For example: val articleDB = ArticleDatabase()
        //invoke function will automatically called
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }
}