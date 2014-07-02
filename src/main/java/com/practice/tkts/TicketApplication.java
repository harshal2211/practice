package com.practice.tkts;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class TicketApplication extends ResourceConfig {

	public TicketApplication()
	{
		register(TicketAPI.class);
		register(JacksonFeature.class);
		register(MoxyXmlFeature.class);
	}
}
