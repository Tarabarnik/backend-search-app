package pavel.kurilyuk.contactssearchbackend;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pavel.kurilyuk.contactssearchbackend.entity.Contact;
import pavel.kurilyuk.contactssearchbackend.service.ContactService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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

    @Test
    void emptyPatternReceive500() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/hello/contacts?nameFilter=");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
    }

    @Test
    void getRequestReturnsJson() throws IOException {
        String jsonMimeType = "application/json";
        Contact vova = new Contact("Vova");
        contactService.add(vova);
        HttpUriRequest request = new HttpGet("http://localhost:8080/hello/contacts?nameFilter="
                + startsWithNumberRegex);

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals(jsonMimeType, mimeType);
    }
}
