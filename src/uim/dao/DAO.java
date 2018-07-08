package uim.dao;

import java.util.List;

import uim.datamodel.Identity;
import uim.exceptions.UserCreationException;
import uim.exceptions.UserDeletionException;
import uim.exceptions.UserReadException;
import uim.exceptions.UserSearchException;
import uim.exceptions.UserUpdateException;

public interface DAO 
{
		
		public void CreateOperation(Identity entity) throws UserCreationException;

		public void DeleteOperation(String userId) throws UserDeletionException;

		public void UpdateOperation(Identity entity) throws UserUpdateException;

		public Identity getById(String id) throws UserReadException;

		public List<Identity> search() throws UserSearchException;
}


