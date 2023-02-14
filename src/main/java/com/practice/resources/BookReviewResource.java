package com.practice.resources;
import com.practice.core.entity.ReviewEntity;
import com.practice.dao.BookReviewEntityDao;
import com.practice.core.entity.BookReviewEntity;
import com.practice.dao.ReviewEntityDao;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/book")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class BookReviewResource{
    BookReviewEntityDao bookReviewEntityDAO;
    ReviewEntityDao reviewEntityDao;

    public BookReviewResource(BookReviewEntityDao bookReviewEntityDAO, ReviewEntityDao reviewEntityDao) {
        this.bookReviewEntityDAO = bookReviewEntityDAO;
        this.reviewEntityDao=reviewEntityDao;
    }
    @GET
    @Path("/AllBooks")
    public List<BookReviewEntity> getAll() {
        return bookReviewEntityDAO.getAll();
    }
    @GET
    @Path("/bookDetails")
    public List<ReviewEntity> getAllReview(){
        return reviewEntityDao.getAllReview();
    }
    @GET
    @Path("/{id}")
    public BookReviewEntity getBook(@PathParam("id") String id){
        return bookReviewEntityDAO.findById(id);
    }

    @GET
    @Path("/bookDetail/{id}")
    public ReviewEntity getReview(@PathParam("id") String id){
        return reviewEntityDao.findReviewById(id);
    }

    //done
    @POST
    @Path("/addbook")
    public BookReviewEntity add(@Valid BookReviewEntity bookReviewEntity) {
//        bookReviewEntityDAO.insert(bookReviewEntity);
        bookReviewEntity.setId(UUID.randomUUID().toString());
        bookReviewEntityDAO.insert(bookReviewEntity.getId(), bookReviewEntity.getBookName(), bookReviewEntity.getBookAuthor(), bookReviewEntity.getPrice());
        return bookReviewEntity;
    }

    @POST
    @Path("/addbookReview/{id}")
    public ReviewEntity addReview(@PathParam("id") String id,@Valid ReviewEntity reviewEntity) {
//        bookReviewEntityDAO.insert(bookReviewEntity);
        reviewEntityDao.insertReview(id, reviewEntity.getRating(), reviewEntity.getReview(), reviewEntity.getCopies_sold());
        return reviewEntityDao.findReviewById(id);
    }
    @PUT
    @Path("/updateBookName/{id}")
    public BookReviewEntity updateBook(@PathParam("id") String id, @Valid BookReviewEntity bookReviewEntity) {
//        BookReviewEntity updateEntity = bookReviewEntityDAO.findById(id);
        bookReviewEntityDAO.updateBookName(id,bookReviewEntity.getBookName());
        return bookReviewEntityDAO.findById(id);
    }
    @PUT
    @Path("/updateBookAuthor/{id}")
    public BookReviewEntity updateAuthor(@PathParam("id") String id, @Valid BookReviewEntity bookReviewEntity) {
        bookReviewEntityDAO.updateBookAuthor(id,bookReviewEntity.getBookAuthor());
        return bookReviewEntityDAO.findById(id);
    }

    @PUT
    @Path("/updateBookReview/{id}/{review}")
    public ReviewEntity updateBookReview(@PathParam("id") String id, @PathParam("review") String review ) {
//        BookReviewEntity updateEntity = bookReviewEntityDAO.findById(id);
        reviewEntityDao.updateBookReview(id,review);
        return reviewEntityDao.findReviewById(id);
    }
    @PUT
    @Path("/updateBookRating/{id}/{rating}")
    public ReviewEntity updateBookRating(@PathParam("id") String id, @PathParam("rating") Integer rating ) {
//        BookReviewEntity updateEntity = bookReviewEntityDAO.findById(id);
        reviewEntityDao.updateBookRating(id,rating);
        return reviewEntityDao.findReviewById(id);
    }
    @PUT
    @Path("/updateCopiesSold/{id}/{copies_sold}")
    public ReviewEntity updateCopiesSold(@PathParam("id") String id, @PathParam("copies_sold") Integer copies_sold ) {
//        BookReviewEntity updateEntity = bookReviewEntityDAO.findById(id);
        reviewEntityDao.updateCopiesSold(id,copies_sold);
        return reviewEntityDao.findReviewById(id);
    }


    //done
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        bookReviewEntityDAO.deleteById(id);
    }
    @DELETE
    @Path("/deleteReview/{id}")
    public void deleteReview(@PathParam("id") String id) {

        reviewEntityDao.deleteByBookId(id);
    }
}
