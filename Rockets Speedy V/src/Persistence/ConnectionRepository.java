package Persistence;

import Utilities.ConstantUtilities;

public class ConnectionRepository {

	private static ConnectionBBDD connection;

	static ConnectionBBDD getConnection() throws Exception {
		if (connection == null)
			connection = new ConnectionBBDD(ConstantUtilities.USERNAME_BBDD, ConstantUtilities.PASSWORD_BBDD);
		return connection;
	}
}
