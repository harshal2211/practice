package com.practice.tkts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.tkts.exception.MyException;
import com.practice.tkts.pojo.Ticket;
import com.practice.tkts.pojo.TicketList;
import com.practice.tkts.services.MyService;

@Component
@Path("/tickets")
public class TicketAPI {

	Logger logger = Logger.getLogger(TicketAPI.class);
	
	@Autowired
	MyService myService;
	
    List<Ticket> ticketList = new  ArrayList<Ticket>();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getAllTickets(@NotNull @QueryParam("X-SSOID") String ssoId,
			@NotNull @QueryParam("type") String ticketType,
			@NotNull @QueryParam("status") String ticketStatus) throws Exception
	{
		logger.debug("In getAll tickets");
		myService.myMethod();
		TicketList ticketsList = new TicketList();
		ticketsList.setTicketList((List<Ticket>) ticketList);
		return(Response.status(Status.OK).entity(ticketsList).build());
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response logTicket(@NotNull @QueryParam("X-SSOID") String ssoId,
			Ticket ticket)
	{
		
		Random random = new Random();
		long ticketId = random.nextLong();
		ticket.setTicketId(ticketId);
		ticketList.add(ticket);
		return(Response.status(Status.CREATED).entity(ticket).
				header("Location", "http://localhost:8080/TicketMgt/tickets/"+ticketId).build());
	}
	
	
	@GET
	@Path("/{ticketId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getTicket(@NotNull @PathParam("ticketId") long ticketId,
			@NotNull @QueryParam("X-SSOID") String ssoId)
	{
		for(Ticket ticket:ticketList)
		{
			if(ticket.getTicketId()==ticketId)
			{
				return Response.status(Status.OK).entity(ticket).build();
			}
		}
		return Response.status(Status.NOT_FOUND).entity("Ticket was not found").build();
	}
	
}
