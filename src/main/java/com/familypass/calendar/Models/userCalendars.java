package com.familypass.calendar.Models;

public class userCalendars {
	private long userId;
	private long calendarId;
	private String calendarName;
	private String calendarUrl;
	private String accountCalendar;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getCalendarId() {
		return calendarId;
	}
	public void setCalendarId(long calendarId) {
		this.calendarId = calendarId;
	}
	public String getCalendarName() {
		return calendarName;
	}
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}
	public String getCalendarUrl() {
		return calendarUrl;
	}
	public void setCalendarUrl(String calendarUrl) {
		this.calendarUrl = calendarUrl;
	}
	public String getAccountCalendar() {
		return accountCalendar;
	}
	public void setAccountCalendar(String accountCalendar) {
		this.accountCalendar = accountCalendar;
	}
	
	
}
