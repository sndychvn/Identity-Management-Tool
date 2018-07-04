package uim.database;

public enum ConfigureKey {
	BACKEND_MODE("backend.mode"),
	FALLBACK_BACKEND_MODE("backend.mode"),
	DB_URL("db.url"),
	DB_USER("db.user"),
	DB_PASSWORD("db.pwd"),
	DB_BACKEND("db"),
	IDENTITY_SEARCH_QUERY("identity.search"),
	IDENTITY_INSERT_QUERY("identity.insert"),
	;

	private String key;
	private ConfigureKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
