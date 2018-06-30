package uim.dao;
import java.io.Serializable;
import java.util.List;

import uim.exceptions.UserCreationException;
import uim.exceptions.UserDeletionException;
import uim.exceptions.UserReadException;
import uim.exceptions.UserSearchException;
import uim.exceptions.UserUpdateException;
import uim.inputparameters.InputParameters;

public interface DAO 
{
		
		public <T> void CreateOperation(T entity) throws UserCreationException;

		public <T> void DeleteOperation(T entity) throws UserDeletionException;

		public <T> void UpdateOperation(T entity) throws UserUpdateException;

		public InputParameters getById(Serializable id) throws UserReadException;

		public <T> List<InputParameters> search(T criteria) throws UserSearchException;
}


