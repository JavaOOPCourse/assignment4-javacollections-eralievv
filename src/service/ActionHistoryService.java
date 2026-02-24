package service;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ActionHistoryService {
    private final ArrayDeque<String> actions = new ArrayDeque<>();

    public void seed() {
        actions.clear();
        actions.addLast("Submitted Assignment");
        actions.addLast("Dropped Course");
        actions.addLast("Registered Course");
        actions.addLast("Updated Profile");
    }

    public void undoLastAction() {
        String undone = actions.pollLast();
        if (undone == null) {
            System.out.println("No actions to undo.");
            return;
        }
        System.out.println("Undone action: " + undone);
    }

    public void addAction(String action) {
        actions.addLast(action);
    }

    public void showFirstAndLast() {
        String first = actions.peekFirst();
        String last = actions.peekLast();

        if (first == null || last == null) {
            System.out.println("No actions available.");
            return;
        }
        System.out.println("First action: " + first);
        System.out.println("Last action: " + last);
    }

    public void printAll() {
        System.out.println("All actions (Iterator):");
        Iterator<String> it = actions.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}