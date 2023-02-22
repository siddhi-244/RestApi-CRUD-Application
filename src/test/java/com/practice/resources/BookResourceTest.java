package com.practice.resources;

import com.practice.core.entity.BookReviewEntity;
import com.practice.core.entity.ReviewEntity;
import com.practice.dao.BookReviewEntityDao;
import com.practice.dao.ReviewEntityDao;
import com.practice.resources.BookReviewResource;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import javax.ws.rs.core.Response;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(DropwizardExtensionsSupport.class)

public class BookResourceTest {
    private static final BookReviewEntityDao bookReviewEntityDao = mock(BookReviewEntityDao.class);
    private static final ReviewEntityDao reviewEntityDao = mock(ReviewEntityDao.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new BookReviewResource(bookReviewEntityDao,reviewEntityDao))
            .build();
    private BookReviewEntity bookReviewEntity;
    private ReviewEntity reviewEntity;


    @BeforeEach
    void setup() {
        bookReviewEntity = new BookReviewEntity("gfb","vhjbbhb","fgfhgfg",899);
        reviewEntity=new ReviewEntity("gfb",3,"vhjbbhb",90);
//        bookReviewEntity=new BookReviewEntity();
//        bookReviewEntity.setId("gfb");
    }

    @AfterEach
    void tearDown() {
        reset(bookReviewEntityDao,reviewEntityDao);
//        reset(reviewEntityDao);
    }

    @Test
    void getBookSuccess() {
//        when(bookReviewEntityDao.findById("gfb")).thenReturn(Optional.of(bookReviewEntity));

        doReturn(bookReviewEntity).when(bookReviewEntityDao).findById("gfb");
        BookReviewEntity found = EXT.target("/books/gfb").request().get(BookReviewEntity.class);

        assertThat(found.getId()).isEqualTo(bookReviewEntity.getId());
        verify(bookReviewEntityDao).findById("gfb");

    }
    @Test
    void getReviewSuccess() {
//        when(bookReviewEntityDao.findById("gfb")).thenReturn(Optional.of(bookReviewEntity));

        doReturn(reviewEntity).when(reviewEntityDao).findReviewById("gfb");
        ReviewEntity found = EXT.target("/books/gfb/reviews").request().get(ReviewEntity.class);

        assertThat(found.getBook_id()).isEqualTo(reviewEntity.getBook_id());
        verify(reviewEntityDao).findReviewById("gfb");

    }

    @Test
    void getBookNotFound() {
//        when(bookReviewEntityDao.findById("yel")).thenReturn(null);
        doReturn(null).when(bookReviewEntityDao).findById("yel");
        final Response response = EXT.target("/books/yel").request().get();

        assertThat(response.getStatusInfo().getStatusCode()).isEqualTo(Response.Status.NO_CONTENT.getStatusCode());
        verify(bookReviewEntityDao).findById("yel");
    }
    @Test
    void getReviewNotFound() {
//        when(bookReviewEntityDao.findById("yel")).thenReturn(null);
        doReturn(null).when(reviewEntityDao).findReviewById("yel");
        final Response response = EXT.target("/books/yel/reviews").request().get();

        assertThat(response.getStatusInfo().getStatusCode()).isEqualTo(Response.Status.NO_CONTENT.getStatusCode());
        verify(reviewEntityDao).findReviewById("yel");
    }
}
