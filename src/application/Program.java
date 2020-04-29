package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Enum.OrderStatus;
import entities.Product;
public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdfBirthDate = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data: ");
		System.out.print("Name: "); String name = sc.nextLine();
		System.out.print("Email: "); String email = sc.nextLine();
		System.out.print("Birthdate (DD/MM/YYYY) : "); Date moment = sdfBirthDate.parse(sc.next());sc.nextLine();	
		System.out.println("Enter order data: ");
		System.out.print("Status: "); String status = sc.nextLine();
		Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, moment));
		System.out.print("How many items to this order? "); int n = sc.nextInt(); sc.nextLine();
		for(int i = 0; i < n; i++) {
			System.out.printf("Enter #%d item data:\n", i + 1);
			System.out.print("Product name:"); String productName = sc.nextLine();
			System.out.print("Product price:"); Double price = sc.nextDouble();
			System.out.print("Quantity:"); int quantity = sc.nextInt(); sc.nextLine();
			order.addItem(new OrderItem(quantity, price,new Product(productName, price)));
		}
		System.out.println(order.toString());
		sc.close();
	}

}
