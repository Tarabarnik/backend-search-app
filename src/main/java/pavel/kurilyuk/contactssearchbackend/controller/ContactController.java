package pavel.kurilyuk.contactssearchbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pavel.kurilyuk.contactssearchbackend.entity.Contact;
import pavel.kurilyuk.contactssearchbackend.service.ContactService;

@RestController
@RequestMapping("/hello")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> test(@RequestParam(name="nameFilter") String value) {
        List<Contact> found = contactService.getByPattern(value);
        return found;
    }
}
