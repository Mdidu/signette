package com.signette.domains;

import java.util.Date;

public class TripEvent {
    private String id;
    private String title;
    private Date start;
    private Date end;

    public TripEvent() {
    }

    public TripEvent(String id, String title, Date start, Date end) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
