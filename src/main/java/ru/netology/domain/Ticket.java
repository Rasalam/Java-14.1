package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTimeInMinutes;

    public Ticket(int id, int price, String departureAirport, String arrivalAirport, int travelTimeInMinutes) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.travelTimeInMinutes = travelTimeInMinutes;
    }

    public Ticket() {
    }

    @Override
    public int compareTo(Ticket o) {
        Ticket t = (Ticket) o;
        return price - t.price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getTravelTimeInMinutes() {
        return travelTimeInMinutes;
    }

    public void setTravelTimeInMinutes(int travelTimeInMinutes) {
        this.travelTimeInMinutes = travelTimeInMinutes;
    }


}

