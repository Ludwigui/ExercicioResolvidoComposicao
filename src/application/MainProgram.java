package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class MainProgram {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.println("Enter client birth: ");
		Date birth = sdf.parse(sc.next());
		System.out.println();
		
		Client client = new Client(name, email, birth);
		
		System.out.println("Enter order data: ");
		System.out.print("Enter order status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order?: ");
		int qt = sc.nextInt();
		
		for(int n=1; n<=qt; n++) {
			System.out.println("Enter #"+ n + "item data: ");
			
			System.out.print("Product name: ");
			sc.nextLine();
			String nameP = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(nameP, productPrice);
			
			System.out.println("Quantity: ");
			int c = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(c, productPrice, product);
			
			order.addItem(orderItem);
			
									}
		
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		
		
		
		
		
		
		
		
		sc.close();

	}

}
