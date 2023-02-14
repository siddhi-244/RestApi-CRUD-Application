package com.practice.core.entity;

import com.practice.core.mapper.ReviewMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

//@RegisterMapper(ReviewMapper.class)
public class ReviewEntity {
    private String book_id;
    private Integer rating;
    private String review;
    private Integer copies_sold;

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getCopies_sold() {
        return copies_sold;
    }

    public void setCopies_sold(Integer copies_sold) {
        this.copies_sold = copies_sold;
    }

    public ReviewEntity(){

    }
    public ReviewEntity(String book_id, Integer rating, String review, Integer copies_sold) {
        this.book_id=book_id;
        this.rating=rating;
        this.review=review;
        this.copies_sold=copies_sold;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewEntity)) return false;

        ReviewEntity that = (ReviewEntity) o;

        if (!getBook_id().equals(that.getBook_id())) return false;
        if (!getRating().equals(that.getRating())) return false;
        if (!getReview().equals(that.getReview())) return false;
        if (!getCopies_sold().equals(that.getCopies_sold())) return false;
        return true;
    }
}
