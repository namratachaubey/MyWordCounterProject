package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Word;
import util.DBConnection;

public class WordDAO {
	public static void main(String[] args) {
		Word obj = new Word();
		obj.setText("2");
		obj.setWords(2);
		obj.setSentences(3);
		obj.setCharacters(3);
		WordDAO ob = new WordDAO();
		ob.save(obj);
	}
public void save(Word w){

try{
	
Connection con=DBConnection.getConnection();

String sql="insert into worddata(textdata,words,characters,sentences,paragraphs,reading_time,avg_word_length,longest_word,shortest_word) values(?,?,?,?,?,?,?,?,?)";

PreparedStatement ps=con.prepareStatement(sql);

ps.setString(1,w.getText());
ps.setInt(2,w.getWords());
ps.setInt(3,w.getCharacters());
ps.setInt(4,w.getSentences());
ps.setInt(5,w.getParagraphs());
ps.setInt(6,w.getReadingTime());
ps.setDouble(7,w.getAvgWordLength());
ps.setString(8,w.getLongestWord());
ps.setString(9,w.getShortestWord());

ps.executeUpdate();

}catch(Exception e){
e.printStackTrace();
}
}
}