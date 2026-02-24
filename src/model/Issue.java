package model;

public class Issue implements Comparable<Issue> {

    // TODO: declare fields
    private String description;
    private int urgencyLevel; // 1 = most urgent

    // TODO: create constructor
    public Issue(String description, int urgencyLevel) {
        this.description = description;
        this.urgencyLevel = urgencyLevel;
    }

    public String getDescription() {
        return description;
    }

    public int getUrgencyLevel() {
        return urgencyLevel;
    }

    // TODO: implement compareTo()
    @Override
    public int compareTo(Issue other) {
        // TODO: implement priority logic
        return Integer.compare(this.urgencyLevel, other.urgencyLevel);
    }

    // TODO: override toString()
    @Override
    public String toString() {
        return "Issue{urgencyLevel=" + urgencyLevel + ", description='" + description + "'}";
    }
}
