package daos;

import repositories.Repository;

import java.io.IOException;

public interface DAOInterface {
    Repository load(String fileName);
    void store(String fileName, Repository repository) ;
}
