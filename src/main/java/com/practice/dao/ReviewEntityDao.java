package com.practice.dao;

import com.practice.core.entity.BookReviewEntity;
import com.practice.core.entity.ReviewEntity;
import com.practice.core.mapper.BookMapper;
import com.practice.core.mapper.ReviewMapper;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

//@RegisterMapper(ReviewMapper.class)
@RegisterMapper(ReviewMapper.class)

public interface ReviewEntityDao {
    @SqlQuery("select * from book_review")
    @RegisterBeanMapper(ReviewEntity.class)
    List<ReviewEntity> getAllReview();

    @SqlQuery("select * from book_review where book_id = :id")
    @RegisterBeanMapper(ReviewEntity.class)
    ReviewEntity findReviewById(@Bind("id") String id);

    @SqlUpdate("insert into book_review (book_id,rating,review,copies_sold) values (:book_id,:rating,:review,:copies_sold)")
    int insertReview(@Bind("book_id") String book_id, @Bind("rating") Integer rating, @Bind("review") String review,@Bind("copies_sold") Integer copies_sold);

    @SqlUpdate("update book_review set review = :review where book_id = :id")
//    @RegisterBeanMapper(BookReviewEntity.class)
    void updateBookReview(@Bind("id") String id,@Bind("review") String review);

    @SqlUpdate("update book_review set rating = :rating where book_id = :id")
//    @RegisterBeanMapper(BookReviewEntity.class)
    void updateBookRating(@Bind("id") String id,@Bind("rating") Integer rating);

    @SqlUpdate("update book_review set copies_sold = :copies_sold where book_id = :id")
//    @RegisterBeanMapper(BookReviewEntity.class)
    void updateCopiesSold(@Bind("id") String id,@Bind("copies_sold") Integer copies_sold);

    @SqlUpdate("delete from book_review where book_id = :id")
//    @RegisterBeanMapper(BookReviewEntity.class)
    void deleteByBookId(@Bind("id") String id);




}
