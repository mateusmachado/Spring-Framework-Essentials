package com.services;

import java.util.List;

import com.models.Article;

public interface ArticleService {
	List<Article> findAllUserArticles(List<String> userId);
}
