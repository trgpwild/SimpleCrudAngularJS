package org.simple.angularjs.contact.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {
	public void save(T entity);
	public void delete(T entity);
	public T get(Serializable id);
	public List<T> list();
}