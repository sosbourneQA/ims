package com.qa.ims.persistence.dao;

import java.util.List;

public interface LineDao<T> {

	List<T> readAll(Long id);

	T create(T t);

	T update(T t);

	void delete(long line_id);
}
