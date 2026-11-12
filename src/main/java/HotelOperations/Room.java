package HotelOperations;

public class Room {
    //Variables
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    //Constructor
    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }
    //Get number of beds
    public int getNumberOfBeds() {
        return numberOfBeds;
    }
    //Get room price
    public double getPrice() {
        return price;
    }
    //Check if room is occupied
    public boolean isOccupied() {
        return occupied;
    }
    //Check if room is dirty
    public boolean isDirty(){
        return dirty;
    }
    //Check if room is available
    public boolean isAvailable() {
        if(!occupied && !dirty) {
            return true;
        }else{
            return false;
        }
    }
    //Check the guest into the room
    public void checkIn(){
        if(isAvailable()){
            occupied = true;
            dirty= true;
            System.out.println("Guest checked in.");
        } else {
            System.out.println("Room is not available");
        }
    }
    //Check a guest out of the room
    public void checkOut(){
        if(occupied){
            occupied = false;
            System.out.println("Guest checked out.");
        }else{
            System.out.println("Room is  not  occupied");
        }
    }
    //Clean the room
    public void cleanRoom(){
        if(!occupied){
            dirty = false;
            System.out.println("Room has been cleaned.");
        }else{
            System.out.println("Cannot clean an occupied room.");
        }
    }

}
