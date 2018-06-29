package uim.dao;

import java.io.Serializable;

public interface DAO {
	
	public void CreateOperation(T entity) throws EntityCreationException;

	public void DeleteOperation(T entity) throws EntityDeletionException;

	public void UpdateOperation(T entity) throws EntityUpdateException;

	public Identity getById(Serializable id) throws EntityReadException;

	public List<Identity> search(T criteria) throws EntitySearchException;
}
