package com.faktor73.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.servlet.ServletContainer;

public class IdentityServiceStarter {

	public static void main(String[] args) throws Exception {

		Server server = new Server(9999);
		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/");
		webapp.setWar("/Users/admin/Ent/git/demos/java/jersey-rest-webapp/target/jersey-rest-webapp.war");
		server.setHandler(webapp);
		server.start();
		server.join();
	}

	private void oldWay() throws Exception {
		Server server = new Server(9999);
		ServletContextHandler context = new ServletContextHandler(server, "/",
				ServletContextHandler.SESSIONS);

		ServletHolder sh = new ServletHolder(ServletContainer.class);
		sh.setInitParameter(
				"com.sun.jersey.config.property.resourceConfigClass",
				"com.sun.jersey.api.core.PackagesResourceConfig");
		sh.setInitParameter("com.sun.jersey.config.property.packages",
				"com.faktor73.services");

		sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature",
				"true");
		context.addServlet(sh, "/jersey");
		server.start();
		server.join();
	}
}
