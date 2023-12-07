package SingletonPattern;

public class QueueSystemDemo {
    public static void main(String[] args) {
        QueueManager station = QueueManager.getInstance();

        station.serveNextCustomer();
        station.serveNextCustomer();
        station.serveNextCustomer();

        System.out.println("Current queue number: " + station.getCurrentQueueNumber());

        station.resetQueueNumber(5);

        station.serveNextCustomer();
        station.serveNextCustomer();
        station.serveNextCustomer();

        System.out.println("Updated queue number: " + station.getCurrentQueueNumber());
    }
}
