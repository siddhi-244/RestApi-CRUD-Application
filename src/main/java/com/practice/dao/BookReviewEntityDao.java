package com.practice.dao;
import com.practice.core.mapper.BookMapper;
import com.practice.core.entity.BookReviewEntity;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import java.util.List;

@RegisterMapper(BookMapper.class)
public interface BookReviewEntityDao {
    @SqlQuery("select * from book")
    @RegisterBeanMapper(BookReviewEntity.class)
    List<BookReviewEntity> getAll();



    @SqlQuery("select * from book where id = :id")
    @RegisterBeanMapper(BookReviewEntity.class)
    BookReviewEntity findById(@Bind("id") String id);

    @SqlUpdate("delete from book where id = :id")
    @RegisterBeanMapper(BookReviewEntity.class)
    void deleteById(@Bind("id") String id);

    @SqlUpdate("update book set book_name = :bookName,book_author=:bookAuthor, price=:price where id = :id")
    @RegisterBeanMapper(BookReviewEntity.class)
    void updateBook(@Bind("id") String id,@Bind("bookName") String bookName,@Bind("bookAuthor") String bookAuthor,@Bind("price") Integer price);

    @SqlUpdate("update book set book_author = :bookAuthor where id = :id")
    @RegisterBeanMapper(BookReviewEntity.class)
    void updateBookAuthor(@Bind("id") String id, @Bind("bookAuthor") String bookAuthor);

    @SqlUpdate("insert into book (id,book_name,book_author,price) values (:id,:bookName,:bookAuthor,:price)")
//    void insert(@BindBean BookReviewEntity bookReviewEntity);
    @RegisterBeanMapper(BookReviewEntity.class)
    int insert(@Bind("id") String id, @Bind("bookName") String bookName, @Bind("bookAuthor") String bookAuthor,@Bind("price") Integer price);

}


