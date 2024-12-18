package Model;

public class Review {
    private int id;
    private int productId;
    private int userId;
    private int orderId;
    private String note;
    private float numberOfStars;

    public Review() {
    }

    public Review(int id, int productId, int userId, int orderId, String note, float numberOfStars) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.orderId = orderId;
        this.note = note;
        this.numberOfStars = numberOfStars;
    }
    public Review(int productId, int userId, int orderId, String note, float numberOfStars) {
        this.productId = productId;
        this.userId = userId;
        this.orderId = orderId;
        this.note = note;
        this.numberOfStars = numberOfStars;
    }

    public Review(int userId, int orderId, String note, float numberOfStars) {
        this.userId = userId;
        this.orderId = orderId;
        this.note = note;
        this.numberOfStars = numberOfStars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(float numberOfStars) {
        this.numberOfStars = numberOfStars;
    }
}

