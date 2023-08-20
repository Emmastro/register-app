/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import model.Region;
import repositories.Repository;

import java.util.Comparator;

/**
 *
 * @author mga, Emmanuel Murairi
 */
public class RegisterController_Increment1 {
    private final Repository repository;

    public RegisterController_Increment1() {
        repository = new Repository();
        listRegions();
    }

    /**
     *
     * @param repositoryFileName
     */
    public RegisterController_Increment1(String repositoryFileName){
        repository = new Repository(repositoryFileName);
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
        return inputHelper.readCharacter("Enter choice", "ABCQ");
    }

    private void addRegion() {
        System.out.format("\033[31m%s\033[0m%n", "Add Region");
        System.out.format("\033[31m%s\033[0m%n", "==========");
    }

    private void addCandidate() {
        System.out.format("\033[31m%s\033[0m%n", "Add Candidate");
        System.out.format("\033[31m%s\033[0m%n", "=============");
    }

    private void listRegions() {
        System.out.format("\033[31m%s\033[0m%n", "Regions");
        System.out.format("\033[31m%s\033[0m%n", "=======");
        repository.getItems().forEach(System.out::println);
    }

    private void listRegionsInNameOrder() {
        System.out.format("\033[31m%s\033[0m%n", "Regions");
        System.out.format("\033[31m%s\033[0m%n", "=======");
    }
}
