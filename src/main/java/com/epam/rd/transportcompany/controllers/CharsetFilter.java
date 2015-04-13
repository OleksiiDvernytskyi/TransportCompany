/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

/**
 *
 * @author amd
 */
import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {
  // кодировка
  private String encoding;

  public void init(FilterConfig config) throws ServletException {
    // читаем из конфигурации
    encoding = config.getInitParameter("requestEncoding");
    
    if (encoding == null)
      encoding = "UTF-8";
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
      throws IOException, ServletException {
    request.setCharacterEncoding(encoding);
    next.doFilter(request, response);
  }

  public void destroy() {
  }
}