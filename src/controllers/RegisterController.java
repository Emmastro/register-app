/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import model.Candidate;
import model.Region;
import repositories.Repository;

import java.util.Comparator;
import java.util.logging.Logger;

/**
 *
 * @author mga, Emmanuel Murairi
 */
public class RegisterController {
    private final Repository repository;

    public RegisterController() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nWelcome to the Register Application System");

        char choice = inputHelper.readCharacter("\nDo you want to use an existing repository file? (Y/N)", "YN");
        if (choice == 'Y' || choice == 'y') {
            String repositoryFileName = inputHelper.readString("\nEnter the repository file name: ");
            repository = new Repository(repositoryFileName);
        } else {
            repository = new Repository();
        }
        listRegions();
    }

    /**
     *
     */
    public void run() {
        boolean finished = false;

        do {
            char choice = displayMenu();
            switch (choice) {
                case 'A':
                    addRegion();
                    listRegions();
                    break;
                case 'B':
                    addCandidate();
                    listRegions();
                    break;
                case 'C':
                    listRegionsInNameOrder();
                    break;
                case 'Q':
                    InputHelper inputHelper = new InputHelper();
                    char save = inputHelper.readCharacter("\nDo you want to save the repository file? (Y/N)", "YN");
                    if (save == 'Y' || save == 'y') {
                        String fileName = inputHelper.readString("\nEnter the repository file name: ");
                        repository.store(fileName);
                    }
                    finished = true;

            }
        } while (!finished);
    }

    private char displayMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add Region");
        System.out.print("\tB. Add Candidate");
        System.out.print("\tC. List Regions In Name Order");
        System.out.print("\tQ. Quit\n");
        return inputHelper.readCharacter("Enter choice", "ABCDQ");

    }
    private void addRegion() {
        System.out.format("\033[31m%s\033[0m%n", "Add Region");
        System.out.format("\033[31m%s\033[0m%n", "==========");
        InputHelper inputHelper = new InputHelper();
        String regionName = inputHelper.readString("Enter region name: ");
        Region region = new Region(regionName);
        repository.add(region);
    }

    private void addCandidate() {
        System.out.format("\033[31m%s\033[0m%n", "Add Candidate");
        System.out.format("\033[31m%s\033[0m%n", "=============");
        InputHelper inputHelper = new InputHelper();
        String candidateName = inputHelper.readString("Enter candidate name: ");
        String candidateParty = inputHelper.readString("Enter candidate party: ");
        int regionId = inputHelper.readInt("Enter region id: ");
        Region region = repository.getItem(regionId);
        if (region != null) {
            region.addCandidateToRegion(new Candidate(candidateName, candidateParty));
        }
        else {
            Logger.getLogger(RegisterController.class.getName()).warning("Region not found. Adding candidate failed, please try again");
            System.out.println("");
        }
    }

    private void listRegions() {
        System.out.format("\033[31m%s\033[0m%n", "Regions");
        System.out.format("\033[31m%s\033[0m%n", "=======");
        repository.getItems().forEach(System.out::println);
    }

    private void listRegionsInNameOrder() {
        System.out.format("\033[31m%s\033[0m%n", "Regions");
        System.out.format("\033[31m%s\033[0m%n", "=======");
        repository.getItems().stream().sorted(Comparator.comparing(Region::getRegionName)).forEach(System.out::println);
    }
}
