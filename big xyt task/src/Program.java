
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager om = new OrderManager();

        om.add(1, "buy", 20.0, 100);
        om.add(2, "sell", 25.0, 200);
        om.add(3, "buy", 23.0, 50);
        om.add(4, "buy", 23.0, 70);
        om.remove(3, "buy", 23.0, 50);
        om.add(5, "sell", 28.0, 100);

    }
}
