package org.example;

import java.io.*;
import jakarta.annotation.WebServlet;
import javax.servlet.*;


@WebServlet("/coupon")
public class CouponServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("SUPERSALE");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String coupon = request.getParameter("coupon");
        request.setAttribute("discount", "discount for coupon " + coupon + " is 10%");
        request.getRequestDispatcher("response.jsp").forward(request, response);
    }
}
