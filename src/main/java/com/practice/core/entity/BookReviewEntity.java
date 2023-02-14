package com.practice.core.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.core.mapper.BookMapper;
import org.jdbi.v3.core.mapper.reflect.ColumnName;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.constraints.NotNull;

@RegisterMapper(BookMapper.class)
public class BookReviewEntity {
//        @ColumnName("ID")
        @NotNull
        @JsonProperty
        private String id;

//        @ColumnName("BOOK")
        @NotNull
        @JsonProperty
        private String bookName;
        @NotNull
        @JsonProperty
        @ColumnName("author")
        private String bookAuthor;
        @NotNull
        @JsonProperty
//        @ColumnName("PRICE")
        private Integer price;
        public BookReviewEntity() {
                // Jackson deserialization
        }

        public BookReviewEntity(String id, String bookName, String bookAuthor, Integer price) {
                this.id=id;
                this.bookName=bookName;
                this.bookAuthor=bookAuthor;
                this.price=price;
        }
        //        @Column(name = "review")

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getBookName() {
                return bookName;
        }

        public void setBookName(String bookName) {
                this.bookName = bookName;
        }

        public String getBookAuthor() {
                return bookAuthor;
        }

        public void setBookAuthor(String bookAuthor) {
                this.bookAuthor = bookAuthor;
        }

        public Integer getPrice() {
                return price;
        }

        public void setPrice(Integer price) {
                this.price = price;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof BookReviewEntity)) return false;

                BookReviewEntity that = (BookReviewEntity) o;

                if (!getId().equals(that.getId())) return false;
                if (!getBookName().equals(that.getBookName())) return false;
                if (!getBookAuthor().equals(that.getBookAuthor())) return false;
                if (!getPrice().equals(that.getPrice())) return false;
                return true;
        }
}
