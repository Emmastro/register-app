/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Emmanuel Murairi
 */
public class Candidate {


    private String candidateName;
    private String party;
    private static final char EOLN='\n';
    private static final String QUOTE="\"";
    public Candidate() {
        this.candidateName = "Unknown";
        this.party = "Unknown";
    }

    /**
     *
     * @param candidateName: candidate name for election
     * @param party: party name for election
     */
    public Candidate(String candidateName, String party) {
        this.candidateName = candidateName;
        this.party = party;
    }

    /**
     * @return the candidate
     */
    public String getCandidateName() {
        return this.candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getParty(){
        return this.party;
    }
    public void setParty(String party) {
        this.party = party;
    }

    /**
     *
     * @return: candidate name and party name
     */
    @Override
    public String toString() {
        return "\nCandidate: " + this.candidateName + " - Party: " + this.party;
    }


    public String toString(char delimiter){
        //"Candidate1","Party1"
        return QUOTE + this.candidateName + QUOTE + delimiter + QUOTE + this.party + QUOTE + EOLN;
    }
    
}

