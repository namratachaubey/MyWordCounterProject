<html>
<head>
<title>Result</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
<div class="container">
<h2>Word Counter Result</h2>

<div class="section">
<p class="result-box">Words: ${words}</p>
<p class="result-box">Characters: ${characters}</p>
<p class="result-box">Sentences: ${sentences}</p>
</div>

<hr>
<div class="section">
<p class="result-box">Paragraphs: ${paragraphs}</p>
<p class="result-box">Reading Time: ${readingTime} min</p>
<p class="result-box">Average Word Length: ${avgWordLength}</p>
<p class="result-box">Longest Word: ${longest}</p>
<p class="result-box">Shortest Word: ${shortest}</p>
</div>
<hr>

<div class="section">
<h3>Word Frequency</h3>
<%
java.util.Map<String,Integer> map = (java.util.Map<String,Integer>) request.getAttribute("freqMap");
if(map != null){
    for(java.util.Map.Entry<String,Integer> entry : map.entrySet()){
%>
<div class="result-box">
<%= entry.getKey() %> - <%= entry.getValue() %>
</div>
<%
    }
}
%>
</div>

<hr>

<a class="button" href="download?
words=${words}
&characters=${characters}
&sentences=${sentences}
&paragraphs=${paragraphs}
&readingTime=${readingTime}
&avgWordLength=${avgWordLength}
&longest=${longest}
&shortest=${shortest}">
Download Result
</a>

<br><br>

<a href="index.html">Back</a>
</div>
</body>
</html>