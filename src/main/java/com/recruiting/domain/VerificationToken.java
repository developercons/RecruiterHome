package com.recruiting.domain;

import com.recruiting.converter.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Martha on 6/25/2017.
 */
@Entity
@Table(name = "verification_token")
public class VerificationToken extends AbstractEntity implements Serializable {

    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;


    // standard constructors, getters and setters
    public VerificationToken() {
    }

    public VerificationToken(String ssn) {
        super(ssn);
    }

    public VerificationToken(String token, User user, LocalDateTime expiryDate, String ssn) {
        super(ssn);
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
