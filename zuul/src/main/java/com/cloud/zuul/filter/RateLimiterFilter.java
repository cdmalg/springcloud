package com.cloud.zuul.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * 令牌桶算法-----限流
 */
@Component
public class RateLimiterFilter extends ZuulFilter {

  private static final RateLimiter RATE_LIMITER = RateLimiter.create(3);

  @Override
  public String filterType() {
    return PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    return SERVLET_DETECTION_FILTER_ORDER - 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    if (RATE_LIMITER.tryAcquire()) {
      System.out.println("桶还没满");
    } else {
      System.out.println("桶满了");
      throw new RuntimeException("123");
    }
    return null;
  }
}
