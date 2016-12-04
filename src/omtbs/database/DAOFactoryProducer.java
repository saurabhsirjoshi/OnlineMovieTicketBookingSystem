package omtbs.database;

public class DAOFactoryProducer {
	public static DAOAbstractFactory getFactory(String choice){
		if (choice.equalsIgnoreCase("DBFactory")) {
				return new DAOFactory();
		}
		return null;
	}

}
