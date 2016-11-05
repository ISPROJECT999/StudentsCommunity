/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //  chain.doFilter(request, response);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        Authorization auth = (Authorization) req.getSession().getAttribute("auth");
        String url = req.getRequestURI().replace(req.getContextPath() + "/faces/", "");
        String login_page = req.getContextPath() + "/faces/index.xhtml"; 
        String login = "index.xhtml";
      //  System.out.println(url);
        
      if(url.contains("pub")){ 
        chain.doFilter(request, response);
        return;
      }
        
        if (!login.equals(url)) {
            
            if (auth != null && auth.isLogin()) {
               
                 chain.doFilter(request, response);
//                Hashtable p = auth.getPrivileges();
//              
//                
//                
//                if (p.containsKey(url)) {
//                    if ((boolean) p.get(url)) {
//                        chain.doFilter(request, response);
//                    } else {
//                        res.sendRedirect(login_page);
//                    }
//                } else {
//                    res.sendRedirect(login_page);
//                }
            } else {
                res.sendRedirect(login_page);
            }
        } else {
            chain.doFilter(request, response);
        }
    
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
