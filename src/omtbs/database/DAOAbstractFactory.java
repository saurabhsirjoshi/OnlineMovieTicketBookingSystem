package omtbs.database;

public abstract class DAOAbstractFactory {
	public abstract AbstractDAO getDB(String database);
}
