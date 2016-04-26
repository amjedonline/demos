package de.zalando.sample;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtil {
	
	 private static final String OLD_COOKIE_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";
	    private static final ThreadLocal<DateFormat> OLD_COOKIE_FORMAT = new ThreadLocal<DateFormat>() {
	        @Override
	        protected DateFormat initialValue() {
	            final DateFormat df = new SimpleDateFormat(OLD_COOKIE_PATTERN, Locale.US);
	            df.setTimeZone(TimeZone.getTimeZone("GMT"));
	            return df;
	        }
	    };

	    private static final String ANCIENT_DATE;
	    private static final String TSPECIALS = ",; ";

	    static {
	        ANCIENT_DATE = OLD_COOKIE_FORMAT.get().format(new Date(10000));
	    }
	 public static void addCookie(final HttpServletResponse response, final Cookie cookie, boolean httpOnly) {
	        if (true) {
	            final Cookie c = cookie;

	            final StringBuffer buf = new StringBuffer();

	            // Servlet implementation checks name
	            buf.append(c.getName());
	            buf.append("=");
	            // Servlet implementation does not check anything else

	            maybeQuote2(buf, c.getValue());

	            // Add domain information, if present
	            if (c.getDomain() != null) {
	                buf.append("; Domain=");
	                maybeQuote2(buf, c.getDomain());
	            }

	            // Max-Age=secs ... or use old "Expires" format
	            // TODO RFC2965 Discard
	            if (c.getMaxAge() >= 0) {

	                // IE6, IE7 and possibly other browsers don't understand Max-Age.
	                // They do understand Expires, even with V1 cookies!
	                // Wdy, DD-Mon-YY HH:MM:SS GMT ( Expires Netscape format )
	                buf.append("; Expires=");

	                // To expire immediately we need to set the time in past
	                if (c.getMaxAge() == 0) {
	                    buf.append(ANCIENT_DATE);
	                } else {
	                    OLD_COOKIE_FORMAT.get().format(new Date(System.currentTimeMillis() + (c.getMaxAge() * 1000L)), buf,
	                        new FieldPosition(0));
	                }
	            }

	            // Path=path
	            if (c.getPath() != null) {
	                buf.append("; Path=");
	                maybeQuote2(buf, c.getPath());
	            }

	            // Secure
	            if (c.getSecure()) {
	                buf.append("; Secure");
	            }

	            // HttpOnly
	            if (httpOnly) {
	                buf.append("; HttpOnly");
	            }

	            response.addHeader("Set-Cookie", buf.toString());
	        } else {
	            response.addCookie(cookie);
	        }
	    }

	    /*
	     * stolen from tomcat 6 ServerCookie class:
	     */
	    public static boolean alreadyQuoted(final String value) {
	        if ((value == null) || (value.length() == 0)) {
	            return false;
	        }

	        return ((value.charAt(0) == '\"') && (value.charAt(value.length() - 1) == '\"'));
	    }

	    /*
	     * stolen from tomcat 6 ServerCookie class:
	     */
	    public static int maybeQuote2(final StringBuffer buf, final String value) {
	        if ((value == null) || (value.length() == 0)) {
	            buf.append("\"\"");
	        } else if (containsCTL(value)) {
	            throw new IllegalArgumentException(
	                "Control character in cookie value, consider BASE64 encoding your value");
	        } else if (alreadyQuoted(value)) {
	            buf.append('"');
	            buf.append(escapeDoubleQuotes(value, 1, value.length() - 1));
	            buf.append('"');
	        } else if (!isToken(value)) {
	            buf.append('"');
	            buf.append(escapeDoubleQuotes(value, 0, value.length()));
	            buf.append('"');
	        } else {
	            buf.append(value);
	        }

	        return 0;
	    }
	    
	    /*
	     * stolen from tomcat 6 ServerCookie class:
	     */
	    public static boolean isToken(final String value) {
	        if (value == null) {
	            return true;
	        }

	        final int len = value.length();

	        for (int i = 0; i < len; i++) {
	            final char c = value.charAt(i);

	            if (TSPECIALS.indexOf(c) != -1) {
	                return false;
	            }
	        }

	        return true;
	    }

	    /**
	     * stolen from tomcat 6 ServerCookie class.
	     *
	     * @param   value
	     *
	     * @return
	     */
	    public static boolean containsCTL(final String value) {
	        if (value == null) {
	            return false;
	        }

	        final int len = value.length();
	        for (int i = 0; i < len; i++) {
	            final char c = value.charAt(i);
	            if ((c < 0x20) || (c >= 0x7f)) {
	                if (c == 0x09) {
	                    continue; // allow horizontal tabs
	                }

	                return true;
	            }
	        }

	        return false;
	    }

	    /**
	     * stolen from tomcat 6 ServerCookie class: Escapes any double quotes in the given string.
	     *
	     * @param   s           the input string
	     * @param   beginIndex  start index inclusive
	     * @param   endIndex    exclusive
	     *
	     * @return  The (possibly) escaped string
	     */
	    private static String escapeDoubleQuotes(final String s, final int beginIndex, final int endIndex) {

	        if ((s == null) || (s.length() == 0) || (s.indexOf('"') == -1)) {
	            return s;
	        }

	        final StringBuffer b = new StringBuffer();
	        for (int i = beginIndex; i < endIndex; i++) {
	            final char c = s.charAt(i);
	            if (c == '\\') {
	                b.append(c);

	                // ignore the character after an escape, just append it
	                if (++i >= endIndex) {
	                    throw new IllegalArgumentException("Invalid escape character in cookie value.");
	                }

	                b.append(s.charAt(i));
	            } else if (c == '"') {
	                b.append('\\').append('"');
	            } else {
	                b.append(c);
	            }
	        }

	        return b.toString();
	    }
}
