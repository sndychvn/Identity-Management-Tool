package uim.database;

import java.util.Properties;

public class ConfigPropDB {
	public static final String BACKEND_MODE = "backend.mode";
	public static final String FALLBACK_BACKEND_MODE = "fallback.backend.mode";
	public static final String DB_BACKEND = "db";
	private static Properties properties;

	static {
		init();
	}

	public static Integer getIntProperty(ConfigureKey key) {
	final String valueAsString = getProperty(key);
	return Integer.valueOf(valueAsString);
	}

	private static void init() {
				
	}

	public static String getProperty(ConfigureKey key) {
	return properties.getProperty(key.getKey());
	}

}
