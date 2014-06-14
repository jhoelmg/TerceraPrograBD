/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.client;

import java.util.Collection;
import java.util.Scanner;
import net.tec.example.queries.Person;
import net.tec.example.queries.PersonQueries;

/**
 *
 * @author AAC
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PersonQueries per = new PersonQueries();
        boolean exit = true;
        Scanner scan = new Scanner(System.in);
        
        while(exit){
            
            System.out.println("*************** MENU ***************");
            System.out.println("1. Insert new person");
            System.out.println("2. Search all persons");
            System.out.println("3. Name and last name to upper case");
            System.out.println("4. Exit");
            System.out.println("************************************");
            
            int option = scan.nextInt();
            
            switch(option){
                case 1:
                    Person newPerson = new Person();
                    System.out.println("ID: ");
                    newPerson.setPersonID(scan.nextInt());
                    System.out.println("Name: ");
                    newPerson.setName(scan.next());
                    System.out.println("Last Name: ");
                    newPerson.setLastname(scan.next());
                    System.out.println("Country: ");
                    newPerson.setCountry(scan.next());
                    System.out.println("Address: ");
                    newPerson.setAddress(scan.next());
                    if(per.insertPerson(newPerson) == -1){
                        System.out.println("----> ERROR <----");
                    }
                    else{
                        System.out.println("----> SUCCESS <----");
                    }
                    break;
                case 2:
                    Collection<Person> personList = per.selectPerson();
                    for(Person p : personList) {
                        System.out.println(p.toString());
                    }
                    break;
                case 3:
                    if(per.toUpperCaseNameAndLastName() == -1){
                        System.out.println("----> ERROR <----");
                    }
                    else{
                        System.out.println("----> SUCCESS <----");
                    }
                    break;
                case 4:
                    exit = false;
                    break;
            }
        }
    }   
}