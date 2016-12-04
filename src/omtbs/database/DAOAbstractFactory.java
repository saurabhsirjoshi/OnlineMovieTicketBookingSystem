package omtbs.database;

public abstract class DAOAbstractFactory {
	abstract AbstractDAO getDB(String database);
}
