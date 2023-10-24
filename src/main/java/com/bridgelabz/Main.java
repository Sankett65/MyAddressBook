package com.bridgelabz;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book");
        AddressBook addressBook= new AddressBook();
        AddressBookManager addressBookManager=new AddressBookManager();

        Scanner sc  = new Scanner(System.in);

        while (true) {
            System.out.println("""

                    Option 1 :- To create AddressBook
                    Option 2 :- To add the Contact to AddressBook
                    Option 3 :- To Edit the Contact
                    Option 4 :- To Remove the Contact
                    Option 5 :- To Display AddressBook
                    Option 6 :- To Search Contact through City name or State name
                    Option 7 :- To Exit""");
            System.out.print("Enter the Option: ");
            int option = sc.nextInt();

            if (option==1){
                System.out.print("Enter the name of the new address book: ");
                Scanner scc = new Scanner(System.in);
                String addressBookName = scc.nextLine();
                addressBookManager.createAddressBook(addressBookName);
                System.out.println(addressBookManager.addressBooks);

            }else if (option == 2) {
                addressBookManager.add();
            }
            else if (option == 3) {
                addressBookManager.edit();
            } else if (option == 4) {
                Scanner s = new Scanner(System.in);
                System.out.print("\nEnter Address Book name: ");
                String addressBookName = s.nextLine();
                System.out.print("Enter the First Name of the Contact you want to remove: ");
                String firstName = s.nextLine();
                addressBookManager.removeContact(addressBookName, firstName);
            } else if (option == 5) {
                addressBookManager.listAddressBooks();
                Scanner sc1 = new Scanner(System.in);
                System.out.print("\nEnter the AddressBook Name :- ");
                String str = sc1.nextLine();
                AddressBook addressBook1= new AddressBook(str);

                System.out.println("""
                        1 :- Sorted With First Name
                        2 :- Sorted With City
                        3 :- Sorted With State
                        4 :- Sorted With Zipcode""");
                System.out.print("Enter the Your Option : ");
                int check = sc1.nextInt();
                List <Contact> li =  addressBookManager.getAddressBook(str);
                switch (check) {
                    case 1 -> {
                        li.sort(Comparator.comparing(Contact::getFirstName));
                        li.forEach(System.out::println);
                    }
                    case 2 -> {
                        li.sort(Comparator.comparing(Contact::getCity));
                        li.forEach(System.out::println);
                    }
                    case 3 -> {
                        li.sort(Comparator.comparing(Contact::getState));
                        li.forEach(System.out::println);
                    }
                    case 4 -> {
                        li.sort(Comparator.comparing(Contact::getZipcode));
                        li.forEach(System.out::println);
                    }
                }

            } else if (option==6) {
                addressBookManager.searchContact();

            } else if (option==7) {
                addressBookManager.listAddressBooks();
                System.exit(0);
            }
        }



    }
}



