package com.mehmetkucuk.newsapp.repository

import com.mehmetkucuk.newsapp.api.RetrofitInstance
import com.mehmetkucuk.newsapp.db.ArticleDatabase
import com.mehmetkucuk.newsapp.models.Article


class NewsRepository(val db: ArticleDatabase) {
    suspend fun getHeadlines (countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadLines(countryCode, pageNumber)
    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}