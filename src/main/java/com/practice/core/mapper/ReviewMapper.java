package com.practice.core.mapper;
import com.practice.core.entity.ReviewEntity;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewMapper implements ResultSetMapper<ReviewEntity>
{
    public ReviewEntity map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
    {
        return new ReviewEntity(resultSet.getString("book_id"), resultSet.getInt("rating"),resultSet.getString("review"), resultSet.getInt("copies_sold"));

    }
}
