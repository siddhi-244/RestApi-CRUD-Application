package com.practice.core.mapper;

import com.practice.core.entity.BookReviewEntity;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements ResultSetMapper<BookReviewEntity>
{
    public BookReviewEntity map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
    {
        return new BookReviewEntity(resultSet.getString("id"), resultSet.getString("book"),resultSet.getString("author"), resultSet.getInt("price"));
//        BookReviewEntity book = new BookReviewEntity();
//        book.setId(resultSet.getString("id"));
//        book.setBookName(resultSet.getString("bookName"));
//        book.setBookAuthor(resultSet.getString("bookAuthor"));
//        book.setPrice(resultSet.getInt("price"));
//        return book;

    }
}
