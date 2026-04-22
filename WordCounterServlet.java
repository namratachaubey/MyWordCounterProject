package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.WordDAO;
import model.Word;

@WebServlet("/count")

public class WordCounterServlet extends HttpServlet {
protected void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{

String text=request.getParameter("text");

// Validation
if(text == null || text.trim().isEmpty()){
    request.setAttribute("error","Please enter text!");
    request.getRequestDispatcher("index.html").forward(request,response);
    return;
}

// Basic counts
int words=text.trim().split("\\s+").length;
int characters=text.length();
int sentences=text.split("[.!?]+").length;

// Paragraphs
int paragraphs = text.split("\\n+").length;

// Reading time
int readingTime = (words / 200) + 1;

// Word array
String[] wordArray = text.trim().split("\\s+");

// Average word length
int totalLength = 0;
for(String w1 : wordArray){
    totalLength += w1.length();
}
double avgWordLength = (double) totalLength / wordArray.length;

// Longest & shortest
String longest = "";
String shortest = wordArray[0];

for(String w1 : wordArray){
    if(w1.length() > longest.length()) longest = w1;
    if(w1.length() < shortest.length()) shortest = w1;
}

// Frequency map
java.util.Map<String,Integer> freq = new java.util.HashMap<>();

for(String w1 : wordArray){
    w1 = w1.toLowerCase();
    freq.put(w1, freq.getOrDefault(w1, 0) + 1);
}

// Save in DB
Word w=new Word();
w.setText(text);
w.setWords(words);
w.setCharacters(characters);
w.setSentences(sentences);
w.setParagraphs(paragraphs);
w.setReadingTime(readingTime);
w.setAvgWordLength(avgWordLength);
w.setLongestWord(longest);
w.setShortestWord(shortest);
WordDAO dao=new WordDAO();
dao.save(w);

// Send data to JSP
request.setAttribute("words",words);
request.setAttribute("characters",characters);
request.setAttribute("sentences",sentences);
request.setAttribute("paragraphs",paragraphs);
request.setAttribute("readingTime",readingTime);
request.setAttribute("avgWordLength",avgWordLength);
request.setAttribute("longest",longest);
request.setAttribute("shortest",shortest);
request.setAttribute("freqMap",freq);

request.getRequestDispatcher("result.jsp").forward(request,response);
}
}