package start;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import model.Client;
import model.Order;
import model.Product;
import presentation.StartUpPage;

/**
 * clasa de unde pornim interfata grafica si unde au fost facute anumite teste
 */
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {

		ClientBLL clientBLL = new ClientBLL();
		ProductBLL productBLL = new ProductBLL();
		OrderBLL orderBLL = new OrderBLL();


		Client client = new Client();
		Client client1 = new Client(4,"Cigoeanu Vlad","cvlad@yahoo.com","Targu Jiu");
		Product product = new Product(4,"Masina de spalat",8);
		Order order = new Order(3,4,1);


		try {
			//client = clientBLL.findClientById(1);
			//clientBLL.insert(client1);
			//productBLL.insert(product);
			//orderBLL.insert(order);
			//clientBLL.update(client1);
			//productBLL.update(product);
			//orderBLL.update(order);
			//clientBLL.delete(client1);
			//productBLL.delete(product);
			//orderBLL.delete(order);
			//System.out.println(clientBLL.findAll());

			StartUpPage sp = new StartUpPage();
			sp.setVisible(true);


			//ClientDAO cd = new ClientDAO();
			//cd.showInformation(cd.findAll());


		} catch (Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}

		// obtain field-value pairs for object through reflection
		//ReflectionExample.retrieveProperties(client);



	}

}
