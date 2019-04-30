package connection;

import java.sql.Connection;
import java.sql.DriverManager;

import domain.BankAccountException;

public class OracleConnection {
	private Connection con;

	public OracleConnection() throws BankAccountException {
		try {
			// Load the jdbc driver
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			throw new BankAccountException(e.getMessage());
		}
	}

	public void open() throws BankAccountException {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:ORCL", "demo", "oracle");
			getConnection().setAutoCommit(false);
		} catch (Exception e) {
			throw new BankAccountException(e.getMessage());
		}
	}

	public void close() throws BankAccountException {
		try {
			getConnection().close();
		} catch (Exception e) {
			throw new BankAccountException(e.getMessage());
		}
	}

	public Connection getConnection() {
		return con;
	}

}
