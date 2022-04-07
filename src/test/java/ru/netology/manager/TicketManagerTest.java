package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    public TicketManager manager = new TicketManager();

    public Ticket ticket1 = new Ticket(1, 6000, "DME", "LED", 145);
    public Ticket ticket2 = new Ticket(1, 5900, "DME", "LED", 144);
    public Ticket ticket3 = new Ticket(1, 6000, "DME", "LED", 140);
    public Ticket ticket4 = new Ticket(1, 7000, "SVO", "LED", 140);
    public Ticket ticket5 = new Ticket(1, 6500, "SVO", "LED", 145);
    public Ticket ticket6 = new Ticket(1, 6800, "SVO", "LED", 143);
    public Ticket ticket7 = new Ticket(1, 11000, "DME", "OVB", 255);
    public Ticket ticket8 = new Ticket(1, 13000, "DME", "OVB", 250);
    public Ticket ticket9 = new Ticket(1, 12000, "DME", "OVB", 255);
    public Ticket ticket10 = new Ticket(1, 12500, "SVO", "OVB", 255);
    public Ticket ticket11 = new Ticket(1, 13000, "SVO", "OVB", 250);
    public Ticket ticket12 = new Ticket(1, 8500, "DME", "SGC", 190);

    public void prepareManager() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);
    }


    @Test
    public void shouldReturnDMEtoOVBTest() {
        prepareManager();
        String from = "DME";
        String to = "OVB";
        Ticket[] actual = manager.findAll(from, to);
        Ticket[] expected = new Ticket[]{ticket7, ticket9, ticket8};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnDMEtoLEDTest() {
        prepareManager();
        String from = "DME";
        String to = "LED";
        Ticket[] actual = manager.findAll(from, to);
        Ticket[] expected = new Ticket[]{ticket2, ticket1, ticket3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnDMEtoSGCTest() {
        prepareManager();
        String from = "DME";
        String to = "SGC";
        Ticket[] actual = manager.findAll(from, to);
        Ticket[] expected = new Ticket[]{ticket12};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyForSVOtoSGCTest() {
        prepareManager();
        String from = "SVO";
        String to = "SGC";
        Ticket[] actual = manager.findAll(from, to);
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyForDMEtoNullTest() {
        prepareManager();
        String from = "DME";
        String to = "";
        Ticket[] actual = manager.findAll(from, to);
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyForNullToDMETest() {
        prepareManager();
        String from = "";
        String to = "DME";
        Ticket[] actual = manager.findAll(from, to);
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyForNullToNullTest() {
        prepareManager();
        String from = "";
        String to = "";
        Ticket[] actual = manager.findAll(from, to);
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, actual);
    }
}