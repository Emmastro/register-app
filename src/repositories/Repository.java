package repositories;

import java.util.ArrayList;
import java.util.function.Predicate;

import daos.DAOTextImpl;
import model.Region;


public class Repository implements RepositoryInterface {
    private ArrayList<Region> items;

    public Repository() {
        this.items = new ArrayList<>();
    }

    public Repository(ArrayList<Region> items) {
        this.items = items;
    }

    public Repository(String filename) {

        DAOTextImpl dao = new DAOTextImpl();
        this.items = dao.load(filename).getItems();
    }

    @Override
    public ArrayList<Region> getItems() {
        return this.items;
    }

    @Override
    public void setItems(ArrayList<Region> items) {
        this.items = items;
    }

    @Override
    public void add(Region item) {
        this.items.add(item);
    }

    @Override
    public void remove(int id) {
        Predicate<Region> predicate = e->e.getId() == id;
        this.items.removeIf(predicate);
    }

    @Override
    public Region getItem(int id) {
        //TODO: change items to hashmap so we can go straight to the item without looping. complexity would be O(1) instead of O(n)
        for (Region item:this.items) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }

    @Override
    public String toString() {
        return "\nItems: " + this.items;
    }

    @Override
    public void store(String filename) {
        DAOTextImpl dao = new DAOTextImpl();
        dao.store(filename, this);
    }
}
