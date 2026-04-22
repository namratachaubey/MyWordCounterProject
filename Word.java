package model;

public class Word {

private String text;
private int words;
private int characters;
private int sentences;
private int paragraphs;
private int readingTime;
private double avgWordLength;
private String longestWord;
private String shortestWord;

public String getText() {
return text;
}

public void setText(String text) {
this.text = text;
}

public int getWords() {
return words;
}

public void setWords(int words) {
this.words = words;
}

public int getCharacters() {
return characters;
}

public void setCharacters(int characters) {
this.characters = characters;
}

public int getSentences() {
return sentences;
}

public void setSentences(int sentences) {
this.sentences = sentences;
}

public int getParagraphs() { return paragraphs; }
public void setParagraphs(int paragraphs) { this.paragraphs = paragraphs; }

public int getReadingTime() { return readingTime; }
public void setReadingTime(int readingTime) { this.readingTime = readingTime; }

public double getAvgWordLength() { return avgWordLength; }
public void setAvgWordLength(double avgWordLength) { this.avgWordLength = avgWordLength; }

public String getLongestWord() { return longestWord; }
public void setLongestWord(String longestWord) { this.longestWord = longestWord; }

public String getShortestWord() { return shortestWord; }
public void setShortestWord(String shortestWord) { this.shortestWord = shortestWord; }
}