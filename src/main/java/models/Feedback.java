package models;

import java.util.LinkedList;

public class Feedback {
    private String id;
    private String message;
    private boolean reviewed;
    private String username;
    private int productId;

    private LinkedList<String> feedbacks;

    public Feedback(String username, int productId, LinkedList<String> feedbacks) {
        this.username = username;
        this.productId = productId;
        this.feedbacks = feedbacks;
    }


    public Feedback(String id, String message, boolean reviewed) {
        this.id = id;
        this.message = message;
        this.reviewed = reviewed;
    }


    public String getUsername() {
        return username;
    }

    public int getProductId() {
        return productId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }

    @Override

    public String toString() {
        return "Feedback from " + username + ": " + feedbacks;
    }
}
