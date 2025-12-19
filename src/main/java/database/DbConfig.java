package database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbConfig {
	//ha class jithe extends hoyl tithe he sagle automatic yetil
			protected Connection con;
			protected Statement st;
			protected PreparedStatement ps;
			protected ResultSet rs;
			public DbConfig()
			{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cmpevent","root","Saurabh2003");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
}
