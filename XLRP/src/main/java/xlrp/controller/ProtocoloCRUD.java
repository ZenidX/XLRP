package xlrp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import java.io.InputStream;
import java.util.Scanner;


public class ProtocoloCRUD {
	static Connection connection;
	public static void CRUD(String caca) {
		final String url = "jdbc:mysql://localhost:3306/db_xlrp";
		final String user = "root";
		final String pass = "DoomEternal";
		try{
			connection = DriverManager.getConnection(url, user, pass);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(scanQuery());
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i < columnCount; i++) {
				System.out.printf("%10s", rsmd.getColumnName(i).toString());
			}
			int spacing = ((columnCount * 10) - 5);
			String textoFormateado = String.format("%n%" + spacing + "s", " ", " ").replace(' ', '-');
			System.out.println(textoFormateado);
			while (result.next()){
				int id_usuarios=result.getInt("id_usuarios");
				String nombre=result.getString("Nombre");
				int edad=result.getInt("Edad");
				System.out.printf("%10d%10s%10d%n", id_usuarios, nombre, edad);
			}
			result.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	public static String scanQuery() {
		InputStream inputStream =System.in;
		Scanner sc = new Scanner(inputStream);
		System.out.print("QUERY: ");
		return sc.nextLine();
	}
	public String PROTOCOLO_CREATE(){
		String table="db_test";
		String[] variab = {"Argo"  ,"Petardo"};
		String[] values = {"patata","patata" };
		return Create(table,variab,values);
	}
	public String PROTOCOLO_READ(){
		String table="db_test";
		String[] variab = {"Argo"  ,"Petardo"};
		return Read(table, variab);
	}
	public String PROTOCOLO_UPDATE(){
		String table="db_test";
		String[] variab = {"Argo"  ,"Petardo"};
		String[] values = {"patata","patata" };
		String[] convar = {"Argo"  ,"Petardo"};
		String[] conval = {"patata","patata" };
		return Update(table,variab,values,convar,conval);
	}
	public String PROTOCOLO_DELETE(){
		String table="db_test";
		String[] convar = {"Argo"  ,"Petardo"};
		String[] conval = {"patata","patata" };
		return Delete(table,convar,conval);
	}
	public String Create(String table,String[] variab,String[] values){
		String query = "INSERT INTO ";
		query=query+table+" VALUES (";
		for(int a=0;a<variab.length;a++){
			query=query+variab[a]+", ";
		}
		char[] charQuery=query.toCharArray();
		charQuery[charQuery.length-1]=')';
		query=charQuery.toString();
		query=query+" VALUES (";
		for(int a=0;a<values.length;a++) {
			query=query+values[a]+", ";
		}
		charQuery=query.toCharArray();
		charQuery[charQuery.length-1]=')';
		query=charQuery.toString()+";";
		return query;
	}
	public String Read  (String table,String[] variab){
		String query = "SELECT ";
		for(int a=0;a<variab.length;a++){
			query=query+variab[a]+", ";
		}
		char[] charQuery=query.toCharArray();
		charQuery[charQuery.length-1]=' ';
		query=charQuery.toString();
		query=query+" FROM "+table+";";
		return query;
	}
	public String Update(String table,String[] variab,String[] values,String[] convar,String[] conval){
		String query = "UPDATE ";
		query=query+table+" SET ";
		for(int a=0;a<variab.length;a++){
			query=query+variab[a]+"="+values[a]+", ";
		}
		char[] charQuery=query.toCharArray();
		charQuery[charQuery.length-1]=' ';
		query=charQuery.toString()+" WHERE ";
		for(int a=0;a<convar.length;a++){
			query=query+convar[a]+"="+conval[a]+", ";
		}
		charQuery=query.toCharArray();
		charQuery[charQuery.length-1]=';';
		return query;
	}
	public String Delete(String table,String[] convar,String[] conval){
		String query = "DELETE FROM ";
		query=query+table+" WHERE ";
		for(int a=0;a<convar.length;a++){
			query=query+convar[a]+"="+conval[a]+", ";
		}
		char[] charQuery=query.toCharArray();
		charQuery[charQuery.length-1]=';';
		return query;
	}
}