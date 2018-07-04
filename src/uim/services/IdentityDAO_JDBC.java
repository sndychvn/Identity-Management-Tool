package uim.services;

import java.io.Serializable;
import java.util.List;

import uim.exceptions.UserCreationException;
import uim.exceptions.UserDeletionException;
import uim.exceptions.UserReadException;
import uim.exceptions.UserSearchException;
import uim.exceptions.UserUpdateException;
import uim.inputparameters.InputParameters;

public class IdentityDAO_JDBC implements IdentityDAO {

	@Override
	public <T> void CreateUserIdentity(T entity) throws UserCreationException {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void DeleteUserIdentity(T entity) throws UserDeletionException {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void UpdateUserIdentity(T entity) throws UserUpdateException {
		// TODO Auto-generated method stub

	}

	@Override
	public InputParameters getById(Serializable id) throws UserReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<InputParameters> search(T criteria) throws UserSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean healthcheck() {
		// TODO Auto-generated method stub
		return false;
	}

}
