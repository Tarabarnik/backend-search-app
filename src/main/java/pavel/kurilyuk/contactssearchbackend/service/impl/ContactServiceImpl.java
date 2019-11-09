package pavel.kurilyuk.contactssearchbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pavel.kurilyuk.contactssearchbackend.entity.Contact;
import pavel.kurilyuk.contactssearchbackend.repository.ContactRepository;
import pavel.kurilyuk.contactssearchbackend.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact add(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getByPattern(String pattern) {
        return contactRepository.findByPattern(pattern);
    }
}
