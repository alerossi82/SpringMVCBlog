import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidatorContext;
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
		
		String path = new File("").getAbsolutePath();
		System.out.println(path);
		
		
	}

}




