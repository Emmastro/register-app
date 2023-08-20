package repositories;

import model.Region;

import java.util.ArrayList;

public interface RepositoryInterface {

    /**
     *
     * @param item
     */
    void add(Region item);

    /**
     *
     * @param id
     * @return
     */
    Region getItem(int id);

    ArrayList<Region> getItems();

    /**
     *
     * @param id
     */
    
    void remove(int id);

    void setItems(ArrayList<Region> items);

    /**
     *
     * @param filename
     */
    
    void store(String filename);

    /**
     *
     * @return
     */
    @Override
    String toString();
    
}
