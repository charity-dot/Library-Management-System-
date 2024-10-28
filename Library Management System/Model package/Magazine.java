//This class extends LibraryItem but does not implement Borrowable
package models;

import java.time.LocalDate;

public class Magazine extends LibraryItem {
    private LocalDate issueDate;

    public Magazine(String id, String title, LocalDate issueDate) {
        super(id, title);
        this.issueDate = issueDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    @Override
    public String getDetails() {
        return super.toString() + ", Issue Date: " + issueDate;
    }

    @Override
    public boolean isAvailable() {
        return true; // Magazines are generally available to read in the library
    }
}