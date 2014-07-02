package com.practice.tkts;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import com.practice.tkts.exception.ErrorBean;


@Provider
public class ContainerFilter implements ContainerRequestFilter,ContainerResponseFilter {

	private static final Logger logger = Logger.getLogger(ContainerFilter.class);
	
	public void filter(ContainerRequestContext reqContext,
			ContainerResponseContext respContext) throws IOException {

		logger.info("In filter");
		
		if(respContext.getStatus()!=200 && respContext.getStatus()!=201)
		{
			
			logger.info("abnormal response");
			
			Response.Status status = Response.Status.fromStatusCode(respContext.getStatus());
			
			if(!respContext.hasEntity()){
				logger.info("unhandled so handle it now");
				
				switch (status) {
				case BAD_REQUEST:
					respContext.setEntity(new ErrorBean(Integer.toString(Response.Status.BAD_REQUEST.getStatusCode()),"Bad request"));
					break;
				case UNAUTHORIZED:
					respContext.setEntity(new ErrorBean(Integer.toString(Response.Status.UNAUTHORIZED.getStatusCode()),"Unauthorized"));
					break;
				case FORBIDDEN:
					respContext.setEntity(new ErrorBean(Integer.toString(Response.Status.FORBIDDEN.getStatusCode()),"ForBidden"));
					break;
				case METHOD_NOT_ALLOWED:
					respContext.setEntity(new ErrorBean(Integer.toString(Response.Status.METHOD_NOT_ALLOWED.getStatusCode()),"Method not allowed"));
					break;
				case NOT_ACCEPTABLE:
					respContext.setEntity(new ErrorBean(Integer.toString(Response.Status.NOT_ACCEPTABLE.getStatusCode()),"Not accepatable"));
					break;
				case UNSUPPORTED_MEDIA_TYPE:
					respContext.setEntity(new ErrorBean(Integer.toString(Response.Status.UNSUPPORTED_MEDIA_TYPE.getStatusCode()),"Unsupported Media Type"));
					break;
				case INTERNAL_SERVER_ERROR:
					respContext.setEntity(new ErrorBean(Integer.toString(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()),"Internal Server error"));	
					break;
				case SERVICE_UNAVAILABLE:
					respContext.setEntity(new ErrorBean(Integer.toString(Response.Status.SERVICE_UNAVAILABLE.getStatusCode()),"Service Unabvailable"));
					break;
				case NOT_FOUND:
					respContext.setEntity(new ErrorBean(Integer.toString(Response.Status.NOT_FOUND.getStatusCode()),"Requested resource was not found"));
					break;
				}
			}
		}
	}

	public void filter(ContainerRequestContext reqContext) throws IOException {

		logger.info("In filter");
		
	
		
	}

}
