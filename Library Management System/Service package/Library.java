//This class manages a list of LibraryItem objects and offers various functionalitiespackage services;

import models.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(String id) {
        items.removeIf(item -> item.getId().equals(id));
    }

    public LibraryItem findItemByTitle(String title) {
        return items.stream().filter(item -> item.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    public List<LibraryItem> listItems() {
        return items;
    }
}