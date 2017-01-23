package com.admitone.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Entity
@Table(name="EXCHANGE")
public class Exchange implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="exchange_id")
    private long exchangeId;

    @Column(name="user_id")
    private long userId;

    @Column(name="from_show_id")
    private long fromShowId;

    @Column(name="to_show_id")
    private long toShowId;

    @Column(name="Number_of_tickets")
    private long numberOfTickets;

    public long getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(long exchangeId) {
        this.exchangeId = exchangeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getfromShowId() {
        return fromShowId;
    }

    public void setFromShowId(long fromShowId) {
        this.fromShowId = fromShowId;
    }

    public long getToShowId() {
        return toShowId;
    }

    public void setToShowId(long toShowId) {
        this.toShowId = toShowId;
    }

    public long getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(long numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "exchangeId=" + exchangeId +
                ", userId=" + userId +
                ", fromShowId=" + fromShowId +
                ", toShowId=" + toShowId +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }
}
