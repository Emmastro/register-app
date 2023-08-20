/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerapp;

import controllers.RegisterController;

/**
 *
 * @author Emmanuel Murairi
 */
public class RegisterApp {

    public static void run() {        
        System.out.println("Register App\n" + "========\n\n");
        
        RegisterController registerController = new RegisterController();
        registerController.run();
        
        System.out.println("Thank you for using Register App. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RegisterApp registerApp = new RegisterApp();
        registerApp.run();
    }
    
}
