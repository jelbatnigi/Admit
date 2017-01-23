package com.admitone.model;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Entity
@Table(name="SHOWS")
public class Shows implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="show_id")
    private long showId;

    @Column(name="show_name")
    private String showName;

    @Column(name="category_id")
    private long categoryId;

    @Column(name="show_time")
    private Date showTime;

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "Shows{" +
                "showId=" + showId +
                ", showName='" + showName + '\'' +
                ", categoryId=" + categoryId +
                ", showTime=" + showTime +
                '}';
    }
}
