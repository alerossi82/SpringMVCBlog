import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.crypto.Data;
import org.hibernate.Session;
import DAO.DAOArea;
import DAO.DAOArticolo;
import DAO.DAOArticoloRM;
import DAO.DAOCucina;
import DAO.DAOPrezzo;
import DAO.DAOVoto;
import DAO.SessionManager;
import beans.Area;
import beans.Articolo;
import beans.ArticoloRM;
import beans.Cucina;
import beans.Prezzo;
import beans.Users;
import beans.Voto;
import models.HomeViewModel;
import models.NewEditArticolo;
import models.SidebarViewModel;

public class prova {

	public static void main(String[] args) throws SQLException {
		
		/*DAOArticolo dao= new DAOArticolo();
		Articolo art=dao.select(1035);
		
		Date date = art.getData();
		DateFormat df = new SimpleDateFormat("dd MM yyyy");
		String text = df.format(date);
		System.out.println(text);
		
		Date date1 = null;
		
		try {
			date1= df.parse(text);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		art.setData(date1);
		
		System.out.println(art.getData());*/
		
		//Articolo art = new Articolo();
		//DAOArticolo dao=new DAOArticolo();
		
		
		//DAOArticolo daoArt= new DAOArticolo();
		NewEditArticolo nea = new NewEditArticolo(0);
		List<Cucina> cucine = nea.getListaCucina();
		for (Cucina c: cucine){
			System.out.println(c.getID()+c.getNome());
		}
				
	}
}



