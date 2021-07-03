package day2;

import java.sql.SQLException;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {		
		ArticleDao dao = new ArticleDao();
		
		ArrayList<Article> list = dao.getArticleList();
		
		
		for(int i = 0; i < list.size(); i++) {
			Article a = list.get(i);
			System.out.println("제목 : " + a.getTitle());
			System.out.println("내용 : " + a.getBody());
		}
		
		
	}

}
