package com.practice.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.core.entity.BookReviewEntity;
import org.junit.jupiter.api.Test;
import static io.dropwizard.jackson.Jackson.newObjectMapper;
import static org.assertj.core.api.Assertions.assertThat;
public class BookTest {
    private static final ObjectMapper MAPPER = newObjectMapper();

    @Test
    void seralizesToJSON() throws Exception {
        final BookReviewEntity bookReviewEntity = new BookReviewEntity("bvsgvvggvdgbvvvd","Luther Blissett", "lb@example.com",980);

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(getClass().getResource("/fixtures/Book.json"), BookReviewEntity.class));

        assertThat(MAPPER.writeValueAsString(bookReviewEntity)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        final BookReviewEntity bookReviewEntity = new BookReviewEntity("bvsgvvggvdgbvvvd","Luther Blissett", "lb@example.com",980);
        assertThat(MAPPER.readValue(getClass().getResource("/fixtures/Book.json"), BookReviewEntity.class))
                .isEqualTo(bookReviewEntity);
    }
}
