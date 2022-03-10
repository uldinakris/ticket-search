package ru.netology.repository;

import ru.netology.domain.Ticket;
import ru.netology.exeptions.NotFoundException;

public class TicketsRepository {

    private Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];

        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = ticket;

        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Ticket ticket = findById(id);
        if (ticket == null) {
            throw new NotFoundException("Ticket with id: " + id + " not found");
        }

        int length = tickets.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket item : tickets) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        tickets = tmp;
    }

}
