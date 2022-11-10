import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrderManager {
    private ArrayList<Order> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public void add(int id, String transactionType, double price, int quantity) {
        Order order = new Order(id, transactionType.toLowerCase(), price, quantity);
        this.orders.add(order);
        printOrders();
    }
    
    public void remove(int id, String transactionType, double price, int quantity) {
        this.orders.remove(new Order(id, transactionType, price, quantity));
        printOrders();
    }

    public void printOrders() {
        double bestPrice = 0;
        System.out.println("---------------------");
        System.out.println("BEST BUY (market buys):");
        bestPrice = this.findBestPrice("buy");
        System.out.println("Price: " + bestPrice + "    Quantity: " + this.totalQuantity(bestPrice, "buy"));

        System.out.println("");
        
        System.out.println("BEST SELL (market sells):");
        bestPrice = this.findBestPrice("sell");
        System.out.println("Price: " + bestPrice + "    Quantity: " + this.totalQuantity(bestPrice, "sell"));
    }

    private int totalQuantity(double bestPrice, String transactionType) {
        ArrayList<Order> orders = getOrders(transactionType);
        orders = orders.stream()
        .filter(s -> s.getPrice() == bestPrice)
        .collect(Collectors.toCollection(ArrayList::new));
        
        int quantity = 0;
        for (Order order:orders) {
            quantity += order.getQuantity();
        }
        return quantity;

    }

    private double findBestPrice(String transactionType) {
        ArrayList<Order> orders = getOrders(transactionType);
        if (orders.isEmpty()) {
            return 0;
        }
        double bestPrice = orders.get(0).getPrice();
        int i = 0;
        while (i < orders.size()) {
            double price = orders.get(i).getPrice();
            if (transactionType.equals("buy")) {
                if (bestPrice < price) {
                    bestPrice = price;
                }
            } else {
                if (bestPrice > price) {
                    bestPrice = price;
                }
            }
            i++;
        }
        return bestPrice;
    }

    private ArrayList<Order> getOrders(String transactionType) {
        ArrayList<Order> orders = this.orders.stream()
        .filter(o -> o.getTransactionType().equals(transactionType))
        .collect(Collectors.toCollection(ArrayList::new));
        return orders;
    }

    
}
