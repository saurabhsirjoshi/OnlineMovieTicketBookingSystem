package omtbs.database;

public class DAOFactory extends DAOAbstractFactory {

	@Override
	public AbstractDAO getDB(String database) {
		// TODO Auto-generated method stub
		if (database == null) {
			return null;
			}
		if (database.equalsIgnoreCase("oracle")) {
				return (AbstractDAO) new OracleDAO();
		} else if (database.equalsIgnoreCase("mysql")) {
				return (AbstractDAO) new MySQLDAO();
		}
		return null;
	}

}
