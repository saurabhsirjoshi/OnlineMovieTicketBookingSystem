package omtbs.database;
import java.sql.*;

public class MySQLDAO implements AbstractDAO {
	Connection conn;
	
	@Override
	public boolean connectToDB(String dbName, String uName, String pwd) {
		// TODO Auto-generated method stub
		// conn=DriverManager.getConnection(  
		// "jdbc:mysql://localhost:3306/sonoo","root","root");
		return true;
	}

	@Override
	public String selectFromDB(String stmt) {
		// TODO Auto-generated method stub
		String outputTable;
		outputTable = "Outputs required data from MySQL database";
		return outputTable;
	}

	@Override
	public boolean insertIntoDB(String stmt) {
		// TODO Auto-generated method stub
		// returns true if insert successful
		if (stmt.equals("insert into users values(username, DOB, address, email;)")) {
				return true;
		}
		else
				return false;	
	}

	@Override
	public boolean updateInDB(String stmt) {
		// TODO Auto-generated method stub
		// returns true if update successful
		if (stmt.equals("update reservation set seatTaken=1 where movieName=movie and seatNum=seat;")) {
				return true;
		}
		else
				return false;
	}

	@Override
	public boolean deleteFromDB(String stmt) {
		// TODO Auto-generated method stub
		// returns true if delete successful
		if (stmt.equals("delete from reservation where movieName=movie;")) {
				return true;
		}
		else
				return false;
	}

}
