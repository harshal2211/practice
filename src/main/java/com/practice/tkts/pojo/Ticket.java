package com.practice.tkts.pojo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@SuppressWarnings("restriction")
@XmlRootElement(name = "Ticket")
@XmlAccessorType(XmlAccessType.FIELD)
/*@XmlType(name="Ticket",propOrder={"ticketId",
		"ticketDescription",
		"ticketType",
		"ticketStatus",
		"ticketOwner",
		"ticketSeverity",
		"ticketPriority",
		"customer",
		"equipment"})*/
public class Ticket {

	private long ticketId;
	private String ticketDescription;
	private String ticketType;
	private String ticketStatus;
	private String ticketOwner;
	private String ticketSeverity;
	private String ticketPriority;
	private Customer customer;
	private Equipment equipment;
	
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketDescription() {
		return ticketDescription;
	}
	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getTicketOwner() {
		return ticketOwner;
	}
	public void setTicketOwner(String ticketOwner) {
		this.ticketOwner = ticketOwner;
	}
	public String getTicketSeverity() {
		return ticketSeverity;
	}
	public void setTicketSeverity(String ticketSeverity) {
		this.ticketSeverity = ticketSeverity;
	}
	public String getTicketPriority() {
		return ticketPriority;
	}
	public void setTicketPriority(String ticketPriority) {
		this.ticketPriority = ticketPriority;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
}
