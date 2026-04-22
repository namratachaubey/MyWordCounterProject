package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws IOException {

response.setContentType("text/plain");
response.setHeader("Content-Disposition", "attachment; filename=result.txt");

PrintWriter out = response.getWriter();

out.println("Word Counter Result");
out.println("---------------------");
out.println("Words: " + request.getParameter("words"));
out.println("Characters: " + request.getParameter("characters"));
out.println("Sentences: " + request.getParameter("sentences"));
out.println("Paragraphs: " + request.getParameter("paragraphs"));
out.println("Reading Time: " + request.getParameter("readingTime") + " min");
out.println("Average Word Length: " + request.getParameter("avgWordLength"));
out.println("Longest Word: " + request.getParameter("longest"));
out.println("Shortest Word: " + request.getParameter("shortest"));

out.close();
}
}