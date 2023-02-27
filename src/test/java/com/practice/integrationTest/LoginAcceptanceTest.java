package com.practice.integrationTest;

import com.practice.DropwizardJdbiApplication;
import com.practice.DropwizardJdbiConfiguration;
import com.practice.core.entity.BookReviewEntity;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
//import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.UUID;

@ExtendWith(DropwizardExtensionsSupport.class)
public class LoginAcceptanceTest {
    private static DropwizardAppExtension<DropwizardJdbiConfiguration> EXT = new DropwizardAppExtension<>(
            DropwizardJdbiApplication.class,
            ResourceHelpers.resourceFilePath("local_properties.yaml")
    );
    BookReviewEntity bookReviewEntity=new BookReviewEntity(UUID.randomUUID().toString(),"gcfgc","dxdxdc",909);
    @Test
    void loginHandlerRedirectsAfterPost() {
        Client client = EXT.client();
//        Entity<?> entity = Entity.entity(bookReviewEntity, MediaType.APPLICATION_JSON_TYPE);
        Response response = client.target(
                        String.format("http://localhost:%d/books", EXT.getLocalPort()))
                .request()
                .post(Entity.json(bookReviewEntity));
        Assertions.assertThat(response.getStatusInfo().getStatusCode()).isEqualTo(Response.Status.CREATED.getStatusCode());
    }

}
