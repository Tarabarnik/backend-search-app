package pavel.kurilyuk.contactssearchbackend.service;

import java.util.List;

import pavel.kurilyuk.contactssearchbackend.entity.Contact;

public interface ContactService {
    Contact add(Contact contact);

    List<Contact> getByPattern(String pattern);
}
