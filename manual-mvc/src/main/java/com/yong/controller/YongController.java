package com.yong.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.io.*;


public class YongController extends HttpServlet{

   private Map<String, CommandHandler> map;
   
   public YongController() {
   
   map = new HashMap<String, CommandHandler>();
   
   }
   
   @Override
   public void init() throws ServletException {
      
      String filePath =this.getServletContext().getRealPath("/WEB-INF/yongCommand.properties");
      
      Properties pr = new Properties();
      
      try {
      FileInputStream fis = new FileInputStream(filePath);
      pr.load(fis);// 키 밸류 추출 완료
      fis.close();
      
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      Iterator keys = pr.keySet().iterator();
      
      while(keys.hasNext()) {
         String key=(String)keys.next();

         String value = pr.getProperty(key);

         try {
            Class originClass = Class.forName(value);
            CommandHandler temp =(CommandHandler) originClass.newInstance();

            map.put(key, temp);
         } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      userProcess(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      userProcess(req, resp);
   }
   
   protected void userProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      //실질 코드
      //1.요청 받기
      // String type = req.getParameter("type");
	  String urlCmd = req.getRequestURI();

	  if (urlCmd.indexOf(req.getContextPath()) == 0) {
		  urlCmd = urlCmd.substring(req.getContextPath().length());
	  }
      
	  //2.요청 분석
      // CommandHandler cmd = map.get(type); //animal 역할
      CommandHandler cmd = map.get(urlCmd);
	  
      String gopage = cmd.process(req, resp);
      //5. 전가 하기
      RequestDispatcher rd =req.getRequestDispatcher(gopage);
      rd.forward(req, resp);
   }
}
