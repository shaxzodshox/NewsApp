package com.shlsoft.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shlsoft.newsapp.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //if there exists the same data then it will replace previous data
    suspend fun insertArticle(article: Article) : Long //returns the id of inserted data

    @Query("SELECT * FROM articles")
    fun getAllArticles() : LiveData<List<Article>> //It is not suspend fun as it returns LiveData object

    @Delete
    suspend fun deleteArticle(article: Article)
}