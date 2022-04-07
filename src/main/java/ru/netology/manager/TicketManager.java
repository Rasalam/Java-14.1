package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;


public class TicketManager {

    private TicketRepository repositories = new TicketRepository();

    public TicketManager() {
    }

    public void add(Ticket ticket) {
        repositories.addTicket(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repositories.getAllTicket()) {
            if (ticket.getDepartureAirport().equals(from) & ticket.getArrivalAirport().equals(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                Arrays.sort(tmp);
                result = tmp;
            }
        }
        return result;
    }
}
