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
		
		public <T> void CreateUserIdentity(T entity) throws UserCreationException;

		public <T> void DeleteUserIdentity(T entity) throws UserDeletionException;

		public <T> void UpdateUserIdentity(T entity) throws UserUpdateException;

		public InputParameters getById(Serializable id) throws UserReadException;

		public <T> List<InputParameters> search(T criteria) throws UserSearchException;
}


