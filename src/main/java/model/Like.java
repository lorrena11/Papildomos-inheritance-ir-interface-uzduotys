package model;

public class Like extends Employee {
    private String message;

    public Like(String name, Position position, String message) {
        super(name, position);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
