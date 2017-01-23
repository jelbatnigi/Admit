package com.admitone.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Entity
@Table(name="CANCELLATION")
public class Cancellation implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="cancellation_id")
    private long cancelationId;

    @Column(name="user_id")
    private long userId;

    @Column(name="show_id")
    private long showId;

    @Column(name="number_of_tickets")
    private long numberOfTickets;

    @Column(name="exchange_id")
    private Long exchangeId;

    public long getCancelationId() {
        return cancelationId;
    }

    public void setCancelationId(long cancelationId) {
        this.cancelationId = cancelationId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public long getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(long numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public Long getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
    }

    @Override
    public String toString() {
        return "Cancellation{" +
                "cancelationId=" + cancelationId +
                ", userId=" + userId +
                ", showId=" + showId +
                ", numberOfTickets=" + numberOfTickets +
                ", exchangeId=" + exchangeId +
                '}';
    }
}
