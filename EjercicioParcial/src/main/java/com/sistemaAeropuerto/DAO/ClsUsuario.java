package com.sistemaAeropuerto.DAO;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sistemaAeropuerto.Conexion.ConexionBd;
import com.sistemaAeropuerto.Entidades.Usuario;

public class ClsUsuario {

	ConexionBd cn = new ConexionBd();
    Connection conexion = cn.RetornarConexion();
	public int id;



	public boolean Login(Usuario usu) {

		boolean resultado = false;
		ArrayList<Usuario> listaUsuariopass = new ArrayList<>();
		System.out.println(usu.getNombre() + usu.getContrasena());
		try {
			CallableStatement call = conexion.prepareCall("Call SP_S_LOGIN(?,?)");
			call.setString("pUsu", usu.getNombre());
			call.setString("pPass", usu.getContrasena());
			ResultSet resul = call.executeQuery();
			while (resul.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombre(resul.getString("Nombre"));
				usuario.setContrasena(resul.getString("Contrasena"));
				usuario.setId(resul.getInt("Id"));
			   
				listaUsuariopass.add(usuario);
			}

			String usuBase = "";
			String passBase = "";

			for (var i : listaUsuariopass) {
				usuBase = i.getNombre();
				passBase = i.getContrasena();
			    id=i.getId();
			}
			
			if (usuBase != null && passBase != null) {
				if (usuBase.equals(usu.getNombre()) && passBase.equals(usu.Contrasena)) {
					resultado = true;
				} else {
					resultado = false;

				}
			}
			conexion.close();

		} catch (Exception e) {
			System.out.println("Error" + e);
		}

		return resultado;

	}

    
}
