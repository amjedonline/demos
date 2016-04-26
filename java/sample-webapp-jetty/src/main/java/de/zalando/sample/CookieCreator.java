package de.zalando.sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieCreator extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		listCookies(req, resp);
		
		String name = req.getParameter("name");
		if (name == null || name.equals("")) {
			return;
		}
		resp.getWriter().write("<br/><br/>");
		String command = req.getParameter("command");
		if ("create".equals(command)) {
			resp.getWriter().write("Creating cookie with name:" + name);
			Cookie cookie = new Cookie(name, "1234567890");
			CookiesUtil.addCookie(resp, cookie, false);
		} else if ("delete".equals(command)) {
			resp.getWriter().write("Deleting cookie with name:" + name);
			Cookie cookie = new Cookie(name, "");
			cookie.setMaxAge(0);
			CookiesUtil.addCookie(resp, cookie, false);
		}

	}

	private void listCookies(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0) {
			return;
		}
		for (Cookie c : cookies) {
			response.getWriter().write(
					"<b>" + c.getName() + "</b> ::" + c.getDomain() + "::"
							+ c.getPath() + "::" + c.getMaxAge() + "::"
							+ c.getValue() + "<br/>");

		}
	}
}
