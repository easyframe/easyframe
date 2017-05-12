package io.github.easyframe.zuul.filters.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author linzhaoming
 */
public class SimpleFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

    //Return the filter type string. Could be "pre", "route"
    @Override
    public String filterType() {
        return "pre";
    }

    // Specify the filter execution order
    @Override
    public int filterOrder() {
        return 1;
    }

    //Should the Filter be executed: always
    public boolean shouldFilter() {
        return true;
    }

    //Filter function
    public Object run() {
        // Zuul filters store request and state in RequestContext. Getting the HttpServletRequest
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        // Before Sending Request, log the HTTP method and URL
        log.info(String.format("linzm- %s request to %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }

}
