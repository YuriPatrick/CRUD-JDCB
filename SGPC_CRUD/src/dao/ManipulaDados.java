package dao;

import java.util.List;

/**
 * Classe responsável na implementação da interface dos métodos
 * add,update,remove,getAll,getId
 **/
public interface ManipulaDados<T> {

	public void adiciona(T t) throws Exception;

	public void update(T t) throws Exception;

	public void remove(T t) throws Exception;

	public List<T> getAll() throws Exception;

	public T getId(int id) throws Exception;

}
