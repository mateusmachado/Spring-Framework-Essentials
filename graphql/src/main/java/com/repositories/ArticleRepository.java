package com.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.models.Article;

public interface ArticleRepository extends PagingAndSortingRepository<Article, ObjectId> {
	List<Article> findByIdIn(List<String> ids);
}
