package pavel.kurilyuk.contactssearchbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pavel.kurilyuk.contactssearchbackend.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT * FROM contacts WHERE contacts.name NOT REGEXP ?1", nativeQuery = true)
    List<Contact> findByPattern(String pattern);
}
