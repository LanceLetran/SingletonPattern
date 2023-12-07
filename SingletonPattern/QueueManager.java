package SingletonPattern;

public class QueueManager {
    private static volatile QueueManager instance;
    private int currentQueueNumber;

    private QueueManager() {
        this.currentQueueNumber = 1;
    }

    public static QueueManager getInstance() {
        if (instance == null) {
            synchronized (QueueManager.class) {
                if (instance == null) {
                    instance = new QueueManager();
                }
            }
        }
        return instance;
    }

    public void resetQueueNumber(int newQueueNumber) {
        if (isValidQueueNumber(newQueueNumber)) {
            currentQueueNumber = newQueueNumber;
            log("Queue number reset to: " + newQueueNumber);
        } else {
            log("Invalid queue number. Reset not performed.");
        }
    }

    public void serveNextCustomer() {
        log("Serving customer with queue number: " + currentQueueNumber);
        currentQueueNumber++;
    }

    public int getCurrentQueueNumber() {
        return currentQueueNumber;
    }

    private boolean isValidQueueNumber(int queueNumber) {
        return queueNumber >= 1;
    }

    private void log(String message) {
        System.out.println(message);
    }
}
