package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Enum.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> orderItem = new ArrayList<>();
	private Client client;
	SimpleDateFormat sdfDaily = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sdfBirthday = new SimpleDateFormat("dd/MM/yyyy");
	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem orderItem) {
		this.orderItem.add(orderItem);
	}

	public void removeItem(OrderItem orderItem) {
		this.orderItem.remove(orderItem);
	}

	public Double total() {
		Double sum = (double) 0;
		for (OrderItem order : orderItem) {
			sum += order.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdfDaily.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + " (" + 
		sdfBirthday.format(client.getBirthDate()) + ") - " +
		client.getEmail() + "\n");
		sb.append("Order Items:" + "\n");
		for(OrderItem c: orderItem) {
			sb.append(c.getProduct().getName() + ", price: ");
			sb.append(c.getProduct().getPrice() + ", quantity: " + c.getQuantity() + ", $" + c.subTotal() + "\n");
		}
		sb.append("Total price: $" + total());
		return sb.toString();
	}
}
