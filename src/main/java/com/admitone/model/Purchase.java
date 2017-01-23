package com.admitone.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Entity
@Table(name = "PURCHASE")
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="purchase_id")
    private long purchaseId;

    @Column(name="user_id")
    Long userId;

    @Column(name="show_id")
    private Long showId;

    @Column(name="Number_of_tickets")
    private long numberOfTickets;

    //@OneToOne(fetch=FetchType.LAZY)
    @Column(name="cancellation_id")
    private Long cancellationId;

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public long getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(long numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public Long getCancellationId() {
        return cancellationId;
    }

    public void setCancellationId(Long cancellationId) {
        this.cancellationId = cancellationId;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", userId=" + userId +
                ", showId=" + showId +
                ", numberOfTickets=" + numberOfTickets +
                ", cancellationId=" + cancellationId +
                '}';
    }
}
