package pavel.kurilyuk.contactssearchbackend.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pavel.kurilyuk.contactssearchbackend.entity.Contact;
import pavel.kurilyuk.contactssearchbackend.service.ContactService;

@Component
public class DataInitializer {
    @Autowired
    private ContactService contactService;

    @PostConstruct
    public void initData() {
        saveContacts();
    }

    private void saveContacts() {
        contactService.add(new Contact("Auto"));
        contactService.add(new Contact("Aaron"));
        contactService.add(new Contact("Car"));
        contactService.add(new Contact("Bentley"));
        contactService.add(new Contact(" ASCII"));
        contactService.add(new Contact("auto"));
    }
}
