package com.qa.ims.services;

import java.util.List;

public interface LineServices<T> {

	public List<T> readAll(Long id);

	T create(T t);

	T update(T t);

	void delete(Long order_id, Long item_id);

}
