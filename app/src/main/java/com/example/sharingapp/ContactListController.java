package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ContactListController {

    private ContactList contactList;


    public ContactListController(ContactList contactList) {
        this.contactList = contactList;
    }

    public void setContact(ArrayList<Contact> contactList) {
        this.contactList.setContacts(contactList);
    }

    public ArrayList<Contact> getContacts() {
        return contactList.getContacts();
    }

    public boolean addContact(Contact contact, Context context) {
        AddContactCommand addContactCommand = new AddContactCommand(contactList, contact, context);
        addContactCommand.execute();
        return addContactCommand.isExecuted();
    }

    public boolean deleteContact(Contact contact, Context context) {
        DeleteContactCommand deleteContactCommand = new DeleteContactCommand(contactList, contact, context);
        deleteContactCommand.execute();
        return deleteContactCommand.isExecuted();
    }

    public boolean editContact(Contact contact, Contact updatedContact, Context context) {
        EditContactCommand editContactCommand = new EditContactCommand(contactList, contact, updatedContact, context);
        editContactCommand.execute();
        return editContactCommand.isExecuted();
    }

    public Contact getContact(int index) {
        return contactList.getContact(index);
    }

    public int getIndex(Contact contact) {
        return contactList.getIndex(contact);
    }

    public int getSize() {
        return contactList.getSize();
    }

    public void loadContacts(Context context) {
        contactList.loadContacts(context);
    }

    public boolean hasContact(Contact contact) {
        return contactList.hasContact(contact);
    }

    public void setContacts(ArrayList<Contact> contactList) {
        this.contactList.setContacts(contactList);
    }


    public Contact getContactByUsername(String username) {
        return contactList.getContactByUsername(username);
    }

    public void saveContacts(Context context) {
        contactList.saveContacts(context);
    }

    public boolean isUsernameAvailable(String username) {
        return contactList.isUsernameAvailable(username);
    }

    public ArrayList<String> getAllUsernames() {
        return contactList.getAllUsernames();
    }

    public void addObserver(Observer observer) {
        contactList.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        contactList.removeObserver(observer);
    }

}
