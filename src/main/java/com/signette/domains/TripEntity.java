package com.signette.domains;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Trip", schema = "public", catalog = "SIGNETTE")
public class TripEntity {
    private int tripId;
    private Date tripStartDate;
    private Date tripEndDate;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "TRIP_SEQ")
    @SequenceGenerator(name = "TRIP_SEQ", sequenceName = "TRIP_SEQ", allocationSize = 1)
    @Column(name = "trip_id", unique = true, nullable = false, precision = 22, scale = 0)
    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    @Basic
    @Column(name = "trip_start_date")
    public Date getTripStartDate() {
        return tripStartDate;
    }

    public void setTripStartDate(Date tripStartDate) {
        this.tripStartDate = tripStartDate;
    }

    @Basic
    @Column(name = "trip_end_date")
    public Date getTripEndDate() {
        return tripEndDate;
    }

    public void setTripEndDate(Date tripEndDate) {
        this.tripEndDate = tripEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripEntity that = (TripEntity) o;
        return tripId == that.tripId && Objects.equals(tripStartDate, that.tripStartDate) && Objects.equals(tripEndDate, that.tripEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripId, tripStartDate, tripEndDate);
    }
}
