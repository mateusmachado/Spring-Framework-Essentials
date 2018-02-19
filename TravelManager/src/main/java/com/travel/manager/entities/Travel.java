package com.travel.manager.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Component
@Table(name = "travel")
public class Travel implements Serializable {

    private static final long serialVersionUID = -6888542263201514002L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "local_destination", nullable = false)
    private String localDestination;

    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "departure_date", nullable = false)
    private Date departureDate;

    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "date_return", nullable = true)
    private Date dateReturn;

    @Column(name = "companion", nullable = true)
    private String companion;

    public Travel() {

    }

    public Travel(Long id, String localDestination, Date departureDate, Date dateReturn, String companion) {
        this.id = id;
        this.localDestination = localDestination;
        this.departureDate = departureDate;
        this.dateReturn = dateReturn;
        this.companion = companion;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public String getCompanion() {
        return companion;
    }

    public void setCompanion(String companion) {
        this.companion = companion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalDestination() {
        return localDestination;
    }

    public void setLocalDestination(String localDestination) {
        this.localDestination = localDestination;
    }

    @Override
    public String toString() {
        return "Travel [id=" + id + ", localDestination=" + localDestination + ", departureDate=" + departureDate
                + ", dateReturn=" + dateReturn + ", companion=" + companion + "]";
    }

}