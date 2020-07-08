package com.dao;

import java.util.List;

/**
 * CLASSE RESPONSÁVEL NA IMPLEMENTAÇÃO DA INTERFACE DOS MÉTODOS
 * ADD,UPDATE,REMOVE,GETALL,GETID
 **/
public interface ManipulaDados<T> {

	public void adiciona(T t) throws Exception;

	public void update(T t) throws Exception;

	public void remove(T t) throws Exception;

	public List<T> getAll() throws Exception;

	public T getId(int id) throws Exception;

}
