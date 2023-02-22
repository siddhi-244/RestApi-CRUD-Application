package com.practice.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.core.entity.BookReviewEntity;
import com.practice.core.entity.ReviewEntity;
import org.junit.jupiter.api.Test;
import static io.dropwizard.jackson.Jackson.newObjectMapper;
import static org.assertj.core.api.Assertions.assertThat;
public class ReviewTest {
    private static final ObjectMapper MAPPER = newObjectMapper();

    @Test
    void seralizesToJSON() throws Exception {
        final ReviewEntity reviewEntity = new ReviewEntity("bvsgvvggvdgbvvvd",3, "lb@example.com",980);

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(getClass().getResource("/fixtures/Review.json"), ReviewEntity.class));

        assertThat(MAPPER.writeValueAsString(reviewEntity)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        final ReviewEntity reviewEntity = new ReviewEntity("bvsgvvggvdgbvvvd",3, "lb@example.com",980);
        assertThat(MAPPER.readValue(getClass().getResource("/fixtures/Review.json"), ReviewEntity.class))
                .isEqualTo(reviewEntity);
    }
}
