package service;

import java.util.Iterator;
import java.util.LinkedList;

public class AppointmentService {
    private final LinkedList<String> appointments = new LinkedList<>();

    public void seed() {
        appointments.clear();
        appointments.add("10:00 - Advisor meeting (Aibek)");
        appointments.add("11:00 - Advisor meeting (Bektur)");
        appointments.add("12:00 - Advisor meeting (Dinara)");
    }

    public void addUrgentAppointmentAtBeginning(String urgentAppointment) {
        appointments.addFirst(urgentAppointment);
    }

    public void cancelLastAppointment() {
        if (!appointments.isEmpty()) {
            appointments.removeLast();
        }
    }

    public void showFirstAndLast() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments.");
            return;
        }
        System.out.println("First appointment: " + appointments.getFirst());
        System.out.println("Last appointment: " + appointments.getLast());
    }

    public void printAllWithIterator() {
        System.out.println("All appointments (Iterator):");
        Iterator<String> it = appointments.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}