public class Order {

    private int Id;
    private String transactionType;
    private double price;
    private int quantity;
    
    public Order(int id, String transactionType, double price, int quantity) {
        Id = id;
        this.transactionType = transactionType;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    
    public String getTransactionType() {
        return transactionType;
    }

    @Override
        public String toString() {           
            return this.Id + "  " + this.transactionType + "    " + this.price + "  " + this.quantity;
        }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (Id != other.Id)
            return false;
        return true;
    }
}
