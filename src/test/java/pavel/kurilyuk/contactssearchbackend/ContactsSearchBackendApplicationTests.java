package pavel.kurilyuk.contactssearchbackend;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pavel.kurilyuk.contactssearchbackend.entity.Contact;
import pavel.kurilyuk.contactssearchbackend.service.ContactService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
class ContactsSearchBackendApplicationTests {
    @Autowired
    private ContactService contactService;
    private static String startsWithNumberRegex = "[0-9]";
    @Test
    void contextLoads() {
    }

    @Test
    void getByPatternOk() {
        Contact contact = new Contact("Contact");
        contactService.add(contact);

        List<Contact> dbResponse = contactService.getByPattern(startsWithNumberRegex);
        assertNotEquals(dbResponse.size(), 0);
    }

    @Test
    void addContactOk() {
        Contact vova = new Contact("Vova");
        Contact dbVova = contactService.add(vova);
        assertEquals(vova.getName(), dbVova.getName());
        assertNotNull(dbVova.getId());
    }
}
