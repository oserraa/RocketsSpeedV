package Persistence;
import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domain.Record;
import Utilities.InvalidParamException;

public class RecordRepository {

	public static void storeRecord(Record record) throws Exception {
		try {
			ConnectionBBDD connection = ConnectionRepository.getConnection();

			String sql = "Insert into RECORDS (ROCKET, TIME, CIRCUIT) values (?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.clearParameters();
			pst.setString(1, record.getRocket());
			pst.setInt(2, record.getTime());
			pst.setString(3, record.getCircuit());

			if (pst.executeUpdate() != 1) {
				throw new InvalidParamException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParamException();
		}
	}

	public static Record getRecord(String circuitname) throws Exception {
		// si fossin més d'un, getAllpictures (getallrecords) retornaria una llista
		ConnectionBBDD connection = ConnectionRepository.getConnection();
		try {
			String sql = "SELECT * FROM RECORDS WHERE CIRCUIT=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.clearParameters();
			//canviar a 3
			preparedStatement.setString(1, circuitname);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {// mes d'un, while rs.next

				String rocket = rs.getString("ROCKET");
				int time = rs.getInt("TIME");
				String circuit = rs.getString("CIRCUIT");
				return new Record(rocket, time, circuit);

			}
			throw new Exception("NOT FOUND");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParamException();
		}
	}

	public static void updateRecord(Record record) throws Exception {
		ConnectionBBDD connection = ConnectionRepository.getConnection();
		try {
			String sql = "UPDATE RECORDS SET ROCKET=?, TIME=? WHERE CIRCUIT=?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.clearParameters();
			pst.setString(1, record.getRocket());
			pst.setInt(2, record.getTime());
			pst.setString(3, record.getCircuit());

			if (pst.executeUpdate() != 1) {
				throw new Exception();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParameterException();

		}
	}

}

