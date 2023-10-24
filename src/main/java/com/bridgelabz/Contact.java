package com.bridgelabz;

import java.util.*;
import java.util.function.Predicate;

public class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zipcode;
    String phoneNo;
    String email;


    public Contact(String firstName, String lastName, String address, String city, String state, String zipcode, String phoneNo, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String  getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setPhoneNo(String  phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", phoneNo=" + phoneNo +
                ", email='" + email + '\'' +
                '}';
    }
}

class AddressBook{
    String name;
    List<Contact> list ;

    public AddressBook(String name) {
        this.name=name;
        this.list=new ArrayList<>();
    }


    public AddressBook(String name, List<Contact> list) {
        this.name = name;
        this.list = list;
    }

    public AddressBook() {}


    public void addContact(){
        Scanner fn = new Scanner(System.in);
        System.out.print("\nEnter First Name: ");
        String s1 = fn.nextLine();
        Predicate<Contact> p = contact -> (contact.getFirstName().equals(s1));
        for (Contact c : list){
            if (p.test(c)){
                System.out.println("Contact of Same name is allready Exits");
                return;
            }
        }
        Scanner ln = new Scanner(System.in);
        System.out.print("Enter Last Name: ");
        String s2 = ln.nextLine();
        Scanner add = new Scanner(System.in);
        System.out.print("Enter Address: ");
        String s3 = add.nextLine();
        Scanner ci = new Scanner(System.in);
        System.out.print("Enter City: ");
        String s4 = ci.nextLine();
        Scanner st = new Scanner(System.in);
        System.out.print("Enter State: ");
        String s5 = st.nextLine();
        Scanner zi = new Scanner(System.in);
        System.out.print("Enter Zipcode: ");
        String s6 = zi.nextLine();
        Scanner pn = new Scanner(System.in);
        System.out.print("Enter Phone Number: ");
        String s7 = pn.nextLine();
        Scanner em = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String s8 = em.nextLine();


        Contact c = new Contact(s1, s2, s3, s4, s5, s6, s7, s8);

        this.list.add(c);
    }

}

class AddressBookManager {
    Map<String, List<Contact>> addressBooks;

    public AddressBookManager() {
        this.addressBooks = new HashMap<>();
    }

    public void add() {
        Scanner s = new Scanner(System.in);
        System.out.print("\nEnter Address Book name: ");
        String addressBookName = s.nextLine();
        if (!addressBooks.containsKey(addressBookName)){
            System.out.println("Invalid there no AddressBook of such name");
            return;
        }else {
            List<Contact> contacts = addressBooks.get(addressBookName);
            AddressBook addressBook = new AddressBook(addressBookName, contacts);
            addressBook.addContact();
        }
        System.out.println("!!! Contact is Added !!!");
    }

    public void createAddressBook(String name) {
        if (!addressBooks.containsKey(name)) {
            AddressBook addressBook = new AddressBook(name);
            addressBooks.put(name, addressBook.list);
            System.out.println("Address book created successfully.");
        } else {
            System.out.println("An address book with this name already exists.");
        }
    }

    public List<Contact> getAddressBook(String name) {
        return addressBooks.get(name);
    }

    public void listAddressBooks() {
        System.out.println("Available Address Books:");
        for (String name : addressBooks.keySet()) {
            System.out.println("- " + name);
        }
    }

    public void edit(){
        Scanner scc = new Scanner(System.in);
        System.out.print("Enter the name of the Addressbook: ");
        String adressBookName123= scc.nextLine();

        System.out.print("Enter the first Name for which you have to do changes: ");
        String fname= scc.nextLine();

        Scanner sci = new Scanner(System.in);
        System.out.println("""

                Enter the thing which you want to change
                Option 1 :- To edit LastName
                Option 2 :- To edit PhoneNumber
                Option 3 :- To edit Address
                Option 4 :- To edit City
                Option 5 :- To edit State
                Option 6 :- To edit Zipcode
                Option 7 :- To edit Email""");
        int check = sci.nextInt();
        Scanner scci = new Scanner(System.in);

        System.out.print("Enter what you want to save:- ");
        String str = scci.nextLine();

        for (Map.Entry<String,List<Contact>> entry : addressBooks.entrySet()){
            if (entry.getKey().equals(adressBookName123)){

                for (Contact contact : getAddressBook(adressBookName123)) {
                    if (contact.getFirstName().equals(fname)) {
                        switch (check) {
                            case 1 ->contact.setLastName(str);
                            case 2 ->contact.setPhoneNo(str);
                            case 3 -> contact.setAddress(str);
                            case 4 -> contact.setCity(str);
                            case 5 -> contact.setState(str);
                            case 6 -> contact.setZipcode(str);
                            case 7 ->contact.setEmail(str);
                        }
                    }
                }
            }
        }
        System.out.println(addressBooks);
    }

    public void removeContact(String addressBookName, String firstName) {
        if (addressBooks.containsKey(addressBookName)) {
            List<Contact> list = addressBooks.get(addressBookName);
            for (Contact contact : list) {
                if (contact.getFirstName().equals(firstName)) {
                    list.remove(contact);
                    System.out.println("Contact is Removed ");
                }
            }
        }else {
            System.out.println("Invalid Name of AddressBook");
        }
    }


    public void searchContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the AddressBook Name: ");
        String name = sc.nextLine();
        System.out.print("Enter the City Name or State Name :- ");
        String str = sc.nextLine();
        int count;

        List<Contact> contacts = addressBooks.get(name);
        AddressBook addressBook = new AddressBook(name, contacts);

        addressBook.list.stream().filter(contact -> (contact.getCity().equals(str)) || (contact.getState().equals(str))).forEach(contact -> System.out.println(contact.getFirstName()));
        count = (int) addressBook.list.stream().filter(contact -> (contact.getCity().equals(str))).count();

        System.out.println(count + " Contact having the Same City or State");
    }

}







