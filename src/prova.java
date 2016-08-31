import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.DAOArea;
import DAO.DAOArticolo;
import DAO.DAOArticoloRM;
import DAO.DAOCucina;
import DAO.DAOPrezzo;
import DAO.DAOVoto;
import beans.Area;
import beans.Articolo;
import beans.ArticoloRM;
import beans.Cucina;
import beans.Prezzo;
import beans.Users;
import beans.Voto;
import models.HomeViewModel;
import models.NewEditArticolo;

public class prova {

	public static void main(String[] args) {
		
		List<String> ListaImg= new ArrayList<String>();
		
		File folder = new File("C:/Users/Ale/workspace/SpringMVCBlog/WebContent/resources/img");
		File[] arrayImg = folder.listFiles();
		for (File f : arrayImg) {
			String fileName=f.getName();
			ListaImg.add(fileName);
		}
		
		for (String s: ListaImg) {
			System.out.println(s);
		}
		
		/*DAOArticolo dao= new DAOArticolo();
		Articolo art=dao.select(4);
		System.out.println(art.getArticolo());*/
	}
}


