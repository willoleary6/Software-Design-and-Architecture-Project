package reservation;

public class HotelService {
    private String name;
    private String description;
    private Double price;

    public HotelService(String name, Double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Double getPrice(){
        return price;
    }
}
