package service;

import model.Issue;
import java.util.Iterator;
import java.util.PriorityQueue;

public class IssueService {

    private final PriorityQueue<Issue> issues = new PriorityQueue<>();

    public void seed() {
        issues.add(new Issue("Cannot register for course", 2));
        issues.add(new Issue("Exam deadline today", 1));
        issues.add(new Issue("Lost student ID card", 5));
        issues.add(new Issue("GPA calculation error", 3));
        issues.add(new Issue("Scholarship documents missing", 2));
    }

    // ✅ ВОТ ЭТОГО У ТЕБЯ НЕ БЫЛО — МЫ ДОБАВИЛИ
    public void addIssue(Issue issue) {
        issues.add(issue);
    }

    public void showMostUrgentIssue() {
        Issue top = issues.peek();
        if (top == null) {
            System.out.println("No issues in queue.");
            return;
        }
        System.out.println("Most urgent issue: " + top);
    }

    public void resolveTopIssue() {
        Issue resolved = issues.poll();
        if (resolved == null) {
            System.out.println("No issues to resolve.");
            return;
        }
        System.out.println("Resolved: " + resolved);
    }

    public void printRemainingWithIterator() {
        Iterator<Issue> it = issues.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}