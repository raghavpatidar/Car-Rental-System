public class Car {
    private String registationNumber;
    private String make;
    private String model;
    private int year;
    private String color;
    private String price;
    private boolean avaiable;

    public Car(String registrationNumber, String make, String model, int year, String color,
            String price, boolean avaiable) {
        this.registationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.avaiable = avaiable;
    }

    public void setAvaiable(boolean avaiable) {
        this.avaiable = avaiable;
    }

    public boolean getAvaiable() {
        return this.avaiable;
    }

    public String getRegistationNumber() {
        return registationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car : registationNumber: " + registationNumber + ", make: " + make + ", model: " + model + ", year: "
                + year
                + ", color: " + color + ", price: " + price + ", avaiable: " + avaiable;
    }

}
