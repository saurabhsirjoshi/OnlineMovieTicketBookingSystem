package omtbs.database;

public interface AbstractDAO {
	public boolean connectToDB(String dbName, String uName, String pwd);
	public String selectFromDB(String stmt);
	public boolean insertIntoDB(String stmt);
	public boolean updateInDB(String stmt);
	public boolean deleteFromDB(String stmt);
}
