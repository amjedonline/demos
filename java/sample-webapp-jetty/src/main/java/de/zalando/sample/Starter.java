package de.zalando.sample;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Starter {
	public static void main(String[] args) throws Exception {
		Server server = new Server(4000);
		ServletContextHandler context = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		context.getInitParams().put("useFileMappedBuffer", "false");
		context.addServlet(new ServletHolder(new CookieCreator()), "/cookie");
		server.start();
		server.join();
	}

}
