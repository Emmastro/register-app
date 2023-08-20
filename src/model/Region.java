/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emmanuel Murairi
 */
public class Region {
    private final int id;
    private String regionName;
    private List<Candidate> regionCandidates;    

    private static int lastIdAllocated = 0;
    private static final char EOLN='\n';
    private static final String QUOTE="\"";

    public Region() {
        this.id = ++lastIdAllocated;
        this.regionName = "Unknown";
        this.regionCandidates = new ArrayList<>();
    }

    /**
     *
     * @param regionName
     */
    public Region(String regionName) {
        this.id = ++lastIdAllocated;
        this.regionName = regionName;
        this.regionCandidates = new ArrayList<>();          
    }

    /**
     *
     * @param id
     * @param regionName
     */
    public Region(int id, String regionName) {
        this.id = id;
        this.regionName = regionName;
        this.regionCandidates = new ArrayList<>();          
        if (id > Region.lastIdAllocated)
            Region.lastIdAllocated = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public List<Candidate> getRegionCandidates() {
        return regionCandidates;
    }

    public void addCandidateToRegion(Candidate candidate) {
        regionCandidates.add(candidate);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public int compareTo(Region compareRegion){
        int compareId = compareRegion.getId();
        return this.id - compareId;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nRegion Id: " + this.id + " - Region Name: " + this.regionName + " - Candidates: " + this.regionCandidates;
    }

    public String toString(char delimiter){
        //1,"Region1",3
        return Integer.toString(this.id) + delimiter + QUOTE + this.regionName + QUOTE + delimiter + this.regionCandidates.size() + EOLN;
    }
}
