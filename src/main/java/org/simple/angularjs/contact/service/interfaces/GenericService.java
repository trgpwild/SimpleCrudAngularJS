package org.simple.angularjs.contact.service.interfaces;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor=Exception.class)
public interface GenericService<T> {
	public void save(T entity);
	public void delete(T entity);
	public T get(Serializable id);
	public List<T> list();
}