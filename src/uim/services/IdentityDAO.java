package uim.services;

import uim.dao.DAO;

public interface IdentityDAO extends DAO {

	boolean healthcheck();
}
