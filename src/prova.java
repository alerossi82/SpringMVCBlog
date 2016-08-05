import java.sql.SQLException;
import java.util.List;
import DAO.DAOArea;
import DAO.DAOArticolo;
import DAO.DAOArticoloRM;
import beans.Area;
import beans.Articolo;
import beans.ArticoloRM;
import models.HomeViewModel;

public class prova {

	public static void main(String[] args) {
		
		/*DAOArea dao=new DAOArea();
		List<Area> list=dao.getArea();
		
		for (Area area:list) {
			System.out.println(area.getID());
			System.out.println(area.getNome());
		}*/
		
		//DAOArticolo dao= new DAOArticolo();
		
		/*List<Articolo> list= dao.selectTop(2);
		for (Articolo art:list){
			System.out.println(art.getId());
			System.out.println(art.getRistorante());
			System.out.println(art.getArticolo());
		}*/
		
		/*Articolo art=new Articolo();
		art.setArticolo("My favourite sushi restaurant");
		art.setData("2016-7-31");
		art.setFoto("img18");
		art.setIDArea(1);	
		art.setIDCucina(4);
		art.setIDPrezzo(1);
		art.setIDVoto(5);
		art.setRistorante("Sushi Oishi");
		art.setId(1008);
		
		dao.delete(art);*/
		
		DAOArticoloRM dao = new DAOArticoloRM();
		ArticoloRM artRM = dao.getSingleArticolo(4);
			System.out.println(artRM.getArea().getNome());
		}

	}
	

