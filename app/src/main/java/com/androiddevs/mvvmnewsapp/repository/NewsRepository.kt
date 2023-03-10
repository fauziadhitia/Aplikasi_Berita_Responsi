package com.androiddevs.mvvmnewsapp.repository

import android.app.DownloadManager
import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDao
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article

//class yang digunakan sebagai tempat penyimpanan
class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode:String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber )

    suspend fun searchNews(searchQuery: String, pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)


    //Saved News
    suspend fun upsert (article: Article) = db.getArticleDao().upsert(article)
    fun getSavedNews() = db.getArticleDao().getAllArticles()

    //for Delete from room db saved news
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)


}