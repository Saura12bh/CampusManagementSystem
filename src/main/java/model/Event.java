package model;

import java.util.*;
import lombok.Data;

@Data
public class Event {
	private int eid;
	private String name;
	private Date edate;
	private String venue;
	private int capacity;
	private int registered;
	private int available;
	public Event(int eid, String name, Date edate, String venue, int capacity) {
        this.eid = eid;
        this.name = name;
        this.edate = edate;
        this.venue = venue;
        this.capacity = capacity;
    }

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public int getEid() {
		return eid;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getRegistered() {
		return registered;
	}
	public void setRegistered(int registered) {
		this.registered = registered;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}

}
