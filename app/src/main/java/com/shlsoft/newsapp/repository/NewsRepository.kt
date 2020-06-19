package com.shlsoft.newsapp.repository

import com.shlsoft.newsapp.api.RetrofitInstance
import com.shlsoft.newsapp.db.ArticleDatabase
import com.shlsoft.newsapp.models.Article
import retrofit2.Retrofit

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun insert(article: Article) = db.getArticleDao().insertArticle(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}