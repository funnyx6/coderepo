package com.funnyx.servlet;

import com.funnyx.util.CheckUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/8/10.
 */
@WebServlet(name = "WechatServlet",urlPatterns = "/wx.do")
public class WechatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        //如果验证成功，则表明接入成功
        PrintWriter pw = response.getWriter();
        if (CheckUtil.checkSignature(signature, timestamp, nonce)){
            pw.write(echostr);
            System.out.println("**************************对接成功**************************");
        }
    }
}
