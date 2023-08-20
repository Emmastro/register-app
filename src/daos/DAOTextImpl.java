package daos;

import model.Candidate;
import model.Region;
import repositories.Repository;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOTextImpl implements DAOInterface{

    static final char DELIMITER = ',';
    @Override
    public Repository load(String fileName) {

        Repository repository = new Repository();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // index 1: regionId, index 2: regionName, index 3: number of candidates
                String[] fields = line.split(Character.toString(DELIMITER));
                int regionId = Integer.parseInt(fields[0]);
                repository.add(new Region(regionId, stripQuotes(fields[1])));
                int numberOfCandidates = Integer.parseInt(fields[2]);
                for (int i=0; i<numberOfCandidates; i++) {
                    // Read candidates
                    line = br.readLine();
                    fields = line.split(Character.toString(DELIMITER));
                    Candidate candidate = new Candidate(stripQuotes(fields[0]), stripQuotes(fields[1]));
                    repository.getItem(regionId).addCandidateToRegion(candidate);
                }
            }
        }
        catch (FileNotFoundException ex) {
            //TODO: ask the user to try again entering the file name
            System.out.println("File not found: " + fileName + ". Creating new file. You can restart the application if you want to try a different filename");
        }
        catch(IOException ex){
            Logger.getLogger(DAOTextImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return repository;
    }

    @Override
    public void store(String fileName, Repository repository) {
        try (PrintWriter output = new PrintWriter(fileName)) {
            for (Region region:repository.getItems()) {
                output.print(region.toString(DELIMITER));
                for (Candidate candidate:region.getRegionCandidates()) {
                    output.print(candidate.toString(DELIMITER));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOTextImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String stripQuotes(String str){
        return str.substring(1, str.length()-1);
    }
}

