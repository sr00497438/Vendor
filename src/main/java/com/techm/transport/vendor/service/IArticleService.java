package com.techm.transport.vendor.service;

import java.util.List;

import com.techm.transport.vendor.entity.Article;

public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(long articleId);
     boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
}
