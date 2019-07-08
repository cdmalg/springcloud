package com.cloud.zuul.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class MyFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return false;
  }

  @Override
  public Object run() throws ZuulException {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
//    log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
    Object accessToken = request.getParameter("token");
    if(accessToken == null) {
//      log.warn("token is empty");
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      try {
        ctx.getResponse().getWriter().write("token is empty");
      }catch (Exception e){}

      return null;
    }
//    log.info("ok");
    return null;
  }
}
