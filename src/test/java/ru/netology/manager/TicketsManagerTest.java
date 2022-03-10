package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketsManager;
import ru.netology.repository.TicketsRepository;

class TicketsManagerTest {
    private TicketsRepository repository = new TicketsRepository();
    private TicketsManager manager = new TicketsManager(repository);

    private Ticket ticket1 = new Ticket(12, 500, "DME", "EGO", 117);
    private Ticket ticket2 = new Ticket(15, 300, "DME", "EGO", 120);
    private Ticket ticket3 = new Ticket(3, 750, "DME", "EGO", 115);
    private Ticket ticket4 = new Ticket(99, 1000, "DME", "LED", 95);
    private Ticket ticket5 = new Ticket(33, 875, "LED", "EGO", 100);

    @Test
    public void shouldFindAllAndSortFromLowestPrice() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] expected = new Ticket[]{ticket2, ticket1, ticket3};
        Ticket[] actual = manager.findAll("DME", "EGO");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothingWithSameDeparture() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("DME", "OGZ");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothingWithSameArrival() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("FRU", "EGO");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllAndSort() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = new Ticket[]{ticket2, ticket1};
        Ticket[] actual = manager.findAll("DME", "EGO");
        assertArrayEquals(expected, actual);
    }

}