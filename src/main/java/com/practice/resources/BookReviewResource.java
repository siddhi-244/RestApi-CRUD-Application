package com.practice.resources;
import com.practice.core.entity.ReviewEntity;
import com.practice.dao.BookReviewEntityDao;
import com.practice.core.entity.BookReviewEntity;
import com.practice.dao.ReviewEntityDao;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/")
//@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class BookReviewResource{
    BookReviewEntityDao bookReviewEntityDAO;
    ReviewEntityDao reviewEntityDao;

    public BookReviewResource(BookReviewEntityDao bookReviewEntityDAO, ReviewEntityDao reviewEntityDao) {
        this.bookReviewEntityDAO = bookReviewEntityDAO;
        this.reviewEntityDao=reviewEntityDao;
    }
    @GET
    @Path("/books")
    public List<BookReviewEntity> getAll() {
        return bookReviewEntityDAO.getAll();
    }
    @GET
    @Path("/books/reviews")
    public List<ReviewEntity> getAllReview(){
        return reviewEntityDao.getAllReview();
    }
    @GET
    @Path("/books/{id}")
    public BookReviewEntity getBook(@PathParam("id") String id){

        return bookReviewEntityDAO.findById(id);
    }

    @GET
    @Path("/books/{id}/reviews")
    public ReviewEntity getReview(@PathParam("id") String id){
        return reviewEntityDao.findReviewById(id);
    }

    //done
    @POST
    @Path("/books")
    public Response add(@Valid BookReviewEntity bookReviewEntity) {
//        bookReviewEntityDAO.insert(bookReviewEntity);
        bookReviewEntity.setId(UUID.randomUUID().toString());
        bookReviewEntityDAO.insert(bookReviewEntity.getId(), bookReviewEntity.getBookName(), bookReviewEntity.getBookAuthor(), bookReviewEntity.getPrice());
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/books/{id}/reviews")
    public Response addReview(@PathParam("id") String id,@Valid ReviewEntity reviewEntity) {
        if(bookReviewEntityDAO.findById(id)==null) return Response.status(Response.Status.NOT_FOUND).build();
        reviewEntityDao.insertReview(id, reviewEntity.getRating(), reviewEntity.getReview(), reviewEntity.getCopies_sold());
        return Response.status(Response.Status.CREATED).build();
    }
    @PUT
    @Path("/books/{id}")
    public Response updateBook(@PathParam("id") String id, @Valid BookReviewEntity bookReviewEntity) {
        if(bookReviewEntityDAO.findById(id)==null) return Response.status(Response.Status.BAD_REQUEST).build();
        bookReviewEntityDAO.updateBook(id,bookReviewEntity.getBookName(),bookReviewEntity.getBookAuthor(),bookReviewEntity.getPrice());
        return Response.status(Response.Status.ACCEPTED).build();
    }
//    @PUT
//    @Path("/books/{id}")
//    public Response updateAuthor(@PathParam("id") String id, @Valid BookReviewEntity bookReviewEntity) {
//        if(bookReviewEntityDAO.findById(id)==null) return Response.status(Response.Status.BAD_REQUEST).build();
//        bookReviewEntityDAO.updateBookAuthor(id,bookReviewEntity.getBookAuthor());
//         return Response.status(Response.Status.ACCEPTED).build();
//    }

    @PUT
    @Path("/books/{id}/reviews")
    public Response updateReview(@PathParam("id") String id, @Valid ReviewEntity reviewEntity ) {
        if(reviewEntityDao.findReviewById(id)==null) return Response.status(Response.Status.BAD_REQUEST).build();
        reviewEntityDao.updateReview(id,reviewEntity.getRating(),reviewEntity.getReview(),reviewEntity.getCopies_sold());
        return Response.status(Response.Status.ACCEPTED).build();
    }
//    @PUT
//    @Path("/reviews/{id}")
//    public Response updateBookRating(@PathParam("id") String id, @QueryParam("rating") Integer rating ) {
////        BookReviewEntity updateEntity = bookReviewEntityDAO.findById(id);
//        if(reviewEntityDao.findReviewById(id)==null) return Response.status(Response.Status.BAD_REQUEST).build();
//        reviewEntityDao.updateBookRating(id,rating);
//        return Response.status(Response.Status.ACCEPTED).build();
//    }
//    @PUT
//    @Path("/reviews/{id}")
//    public Response updateCopiesSold(@PathParam("id") String id, @QueryParam("copies_sold") Integer copies_sold ) {
////        BookReviewEntity updateEntity = bookReviewEntityDAO.findById(id);
//        if(reviewEntityDao.findReviewById(id)==null) return Response.status(Response.Status.BAD_REQUEST).build();
//        reviewEntityDao.updateCopiesSold(id,copies_sold);
//        return Response.status(Response.Status.ACCEPTED).build();
//    }


    //done
    @DELETE
    @Path("/books/{id}")
    public Response delete(@PathParam("id") String id) {
        if(bookReviewEntityDAO.findById(id)==null) return Response.status(Response.Status.NOT_FOUND).build();
        bookReviewEntityDAO.deleteById(id);
        return Response.status(Response.Status.ACCEPTED).build();
    }
    @DELETE
    @Path("/books/{id}/reviews")
    public Response deleteReview(@PathParam("id") String id) {
        if(reviewEntityDao.findReviewById(id)==null) return Response.status(Response.Status.NOT_FOUND).build();
        reviewEntityDao.deleteByBookId(id);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @PATCH
    @Path("/books/{id}/bookName")
    public Response updateBookName(@PathParam("id") String id,@QueryParam("bookName") String bookName){
        if(bookReviewEntityDAO.findById(id)==null) return Response.status(Response.Status.NOT_FOUND).build();
        bookReviewEntityDAO.updateBookName(id,bookName);
        return Response.accepted().build();

    }
    @PATCH
    @Path("/books/{id}/bookAuthor")
    public Response updateBookAuthor(@PathParam("id") String id,@QueryParam("bookAuthor") String bookAuthor){
        if(bookReviewEntityDAO.findById(id)==null) return Response.status(Response.Status.NOT_FOUND).build();
        bookReviewEntityDAO.updateBookAuthor(id,bookAuthor);
        return Response.accepted().build();

    }

    @PATCH
    @Path("/books/{id}/price")
    public Response updateBookPrice(@PathParam("id") String id,@QueryParam("price") Integer price){
        if(bookReviewEntityDAO.findById(id)==null) return Response.status(Response.Status.NOT_FOUND).build();
        bookReviewEntityDAO.updateBookPrice(id,price);
        return Response.accepted().build();

    }

    @PATCH
    @Path("/books/{id}/rating")
    public Response updateRating(@PathParam("id") String id,@QueryParam("rating") Integer rating){
        if(reviewEntityDao.findReviewById(id)==null) return Response.status(Response.Status.NOT_FOUND).build();
        reviewEntityDao.updateBookRating(id,rating);
        return Response.accepted().build();
    }
    @PATCH
    @Path("/books/{id}/copies")
    public Response updateCopies(@PathParam("id") String id,@QueryParam("copies_sold") Integer copies_sold){
        if(reviewEntityDao.findReviewById(id)==null) return Response.status(Response.Status.NOT_FOUND).build();
        reviewEntityDao.updateCopiesSold(id,copies_sold);
        return Response.accepted().build();

    }

    @PATCH
    @Path("/books/{id}/reviews")
    public Response updateReviewText(@PathParam("id") String id,@QueryParam("review") String review){
        if(reviewEntityDao.findReviewById(id)==null) return Response.status(Response.Status.NOT_FOUND).build();
        reviewEntityDao.updateReviewText(id,review);
        return Response.accepted().build();

    }
//
}
