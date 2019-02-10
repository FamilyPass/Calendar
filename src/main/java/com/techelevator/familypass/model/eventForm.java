package com.techelevator.familypass.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class eventForm {
	private long userId;
	private long eventId;
	private long calendarId;
	private String eventTitle;
	private Date eventStartDate;
	private Date eventEndDate;
	private Time eventLocation;
	private String eventDescription;
	private String eventGuest;
	private Timestamp eventNotification;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	public long getCalendarId() {
		return calendarId;
	}
	public void setCalendarId(long calendarId) {
		this.calendarId = calendarId;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public Date getEventStartDate() {
		return eventStartDate;
	}
	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	public Date getEventEndDate() {
		return eventEndDate;
	}
	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}
	public Time getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(Time eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventGuest() {
		return eventGuest;
	}
	public void setEventGuest(String eventGuest) {
		this.eventGuest = eventGuest;
	}
	public Timestamp getEventNotification() {
		return eventNotification;
	}
	public void setEventNotification(Timestamp eventNotification) {
		this.eventNotification = eventNotification;
	}
		
	}

