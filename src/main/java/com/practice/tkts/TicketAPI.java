package com.practice.tkts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

import com.practice.tkts.pojo.Ticket;
import com.practice.tkts.pojo.TicketList;

@Component
@Path("/tickets")
public class TicketAPI {

    List<Ticket> ticketList = new  ArrayList<Ticket>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTickets(@QueryParam("X-SSOID") String ssoId,
			@QueryParam("type") String ticketType,
			@QueryParam("status") String ticketStatus)
	{
		if(ssoId == null)
			return(Response.status(Status.BAD_REQUEST).entity("ssoId is not provided").build());
		
		if("".equalsIgnoreCase(ssoId))
			return(Response.status(Status.BAD_REQUEST).entity("ssoId is not provided").build());
		
		TicketList ticketsList = new TicketList();
		ticketsList.setTicketList((List<Ticket>) ticketList);
		return(Response.status(Status.OK).entity(ticketsList).build());
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response logTicket(@QueryParam("X-SSOID") String ssoId,
			Ticket ticket)
	{
		if(ssoId == null)
			return(Response.status(Status.BAD_REQUEST).entity("ssoId is not provided").build());
		
		if("".equalsIgnoreCase(ssoId))
			return(Response.status(Status.BAD_REQUEST).entity("ssoId is not provided").build());
		
		Random random = new Random();
		long ticketId = random.nextLong();
		ticket.setTicketId(ticketId);
		ticketList.add(ticket);
		return(Response.status(Status.CREATED).entity(ticket).
				header("Location", "http://localhost:8080/TicketMgt/tickets/"+ticketId).build());
	}
	
	@GET
	@Path("/{ticketId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTicket(@PathParam("ticketId") long ticketId,
			@QueryParam("X-SSOID") String ssoId)
	{
		if(ssoId == null)
			return(Response.status(Status.BAD_REQUEST).entity("ssoId is not provided").build());
		
		if("".equalsIgnoreCase(ssoId))
			return(Response.status(Status.BAD_REQUEST).entity("ssoId is not provided").build());
		
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
