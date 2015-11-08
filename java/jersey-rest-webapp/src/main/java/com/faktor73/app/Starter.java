package com.faktor73.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import com.faktor73.Servlet;

public class Starter {
	public static void main(String[] args) throws Exception {
		Server server = new Server(4000);
		ServletContextHandler context = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		context.getInitParams().put("useFileMappedBuffer", "false");
		
		context.addServlet(new ServletHolder(new Servlet()), "/hello");
		context.addServlet(getJersey2ServletHolder(), "/rest*");

		server.start();
		server.join();
	}

	private static ServletHolder getRestServletHolder() {
		ServletHolder sh = new ServletHolder(ServletContainer.class);
		sh.setInitParameter(
				"com.sun.jersey.config.property.resourceConfigClass",
				"com.sun.jersey.api.core.PackagesResourceConfig");
		sh.setInitParameter("com.sun.jersey.config.property.packages",
				"com.faktor73.services");

		sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature",
				"true");
		return sh;
	}
	
	private static ServletHolder getJersey2ServletHolder() {
		ServletHolder sh = new ServletHolder(ServletContainer.class);
//		sh.setInitParameter(
//				"com.sun.jersey.config.property.resourceConfigClass",
//				"com.sun.jersey.api.core.PackagesResourceConfig");
		sh.setInitParameter("jersey.config.server.provider.packages",
				"com.faktor73.services");

		sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature",
				"true");
		return sh;
	}


}
