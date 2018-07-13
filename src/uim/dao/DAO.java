package uim.dao;

import java.util.List;

import uim.datamodel.Identity;
import uim.exceptions.UserCreationException;
import uim.exceptions.UserDeletionException;
import uim.exceptions.UserReadException;
import uim.exceptions.UserSearchException;
import uim.exceptions.UserUpdateException;

/**
 * <h3>Description</h3>
 * <p>This interface allows to declare the abstract methods and respective exceptions </p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */

public interface DAO 
{
		
		public void CreateOperation(Identity entity) throws UserCreationException;

		public void DeleteOperation(String userId) throws UserDeletionException;

		public void UpdateOperation(Identity entity) throws UserUpdateException;

		public Identity getById(String id) throws UserReadException;

		public List<Identity> search() throws UserSearchException;
}


