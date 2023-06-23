package hostelapp.version6.model;

public class Room {
    private int number;
    private String name;
    private Type type;
    private int floor;
    private double dailyRate;
    private double dimensions;
    private String description;

    public Room() {
    }

    public Room (int number, Type type) {
        this.number = number;
        this.type = type;
    }
    public Room(int number, String name, Type type, int floor, int dailyRate, int dimensions, String description) {
        this.number = number;
        this.name = name;
        this.type = type;
        this.floor = floor;
        this.dailyRate = dailyRate;
        this.dimensions = dimensions;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getDimensions() {
        return dimensions;
    }

    public void setDimensions(double dimensions) {
        this.dimensions = dimensions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", floor=" + floor +
                ", dimensions=" + dimensions +
                ", description='" + description + '\'' +
                '}';
    }
}
