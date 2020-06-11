package dao;

import java.util.List;

/**
 * Classe respons�vel na implementa��o da interface dos m�todos
 * add,update,remove,getAll,getId
 **/
public interface ManipulaDados<T> {

	public void adiciona(T t) throws Exception;

	public void update(T t) throws Exception;

	public void remove(T t) throws Exception;

	public List<T> getAll() throws Exception;

	public T getId(int id) throws Exception;

}
