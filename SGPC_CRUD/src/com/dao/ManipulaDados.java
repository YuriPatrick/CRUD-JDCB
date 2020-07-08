package com.dao;

import java.util.List;

/**
 * CLASSE RESPONS�VEL NA IMPLEMENTA��O DA INTERFACE DOS M�TODOS
 * ADD,UPDATE,REMOVE,GETALL,GETID
 **/
public interface ManipulaDados<T> {

	public void adiciona(T t) throws Exception;

	public void update(T t) throws Exception;

	public void remove(T t) throws Exception;

	public List<T> getAll() throws Exception;

	public T getId(int id) throws Exception;

}
