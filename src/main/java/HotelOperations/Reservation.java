package HotelOperations;

public class Reservation {
    //Variables
    private String roomType;
    private int numberOfNights;
    private boolean weekend;
    //Constructor
    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;
    }
    //Get room type
    public String getRoomType() {
        return roomType;
    }
    //Change room type
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    //Get price per night
    public double getPrice() {
        double price;
        if(roomType.equalsIgnoreCase("King")){
            price = 139.00;
        }else if (roomType.equalsIgnoreCase("double")){
            price = 129.00;
        }else {
            price = 0;
        }
        //Add 10% for weekend
        if (weekend){
            price = price * 1.10;
        }
        return price;
    }
    //Get number of nights
    public int getNumberOfNights() {
        return numberOfNights;
    }
    //Change the number of nights
    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }
    //Check if it's the weekend
    public boolean isWeekend() {
        return weekend;
    }
    //Change weekend status
    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }
    //Calculate reservation total
    public double getReservationTotal(){
        return getPrice() * numberOfNights;
    }
}
