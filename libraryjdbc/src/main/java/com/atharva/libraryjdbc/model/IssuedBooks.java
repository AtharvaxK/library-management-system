package com.atharva.libraryjdbc.model;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IssuedBooks {
    private int issueId;
    private int bookId;
    private int userId;
    private LocalDateTime issueDate;
    private LocalDateTime returnDate;

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "IssuedBooks{" +
                "issueId=" + issueId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
