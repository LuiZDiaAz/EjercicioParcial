package com.sistemaAeropuerto.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sistemaAeropuerto.Conexion.ConexionBd;
import com.sistemaAeropuerto.Entidades.Consulta;

public class ClsConsulta {
	
	ConexionBd cn = new ConexionBd();
    Connection conexion = cn.RetornarConexion();

		public ArrayList<Consulta> MostrarConsulta() {
			ArrayList<Consulta> lista = new ArrayList<>();
			try {
				CallableStatement st = conexion.prepareCall("SELECT * FROM Consulta");
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Consulta Con = new Consulta();
					Con.setId(rs.getInt("Id"));
					Con.setNombre(rs.getString("Nombre"));
					Con.setApellido(rs.getString("Apellido"));

					lista.add(Con);

				}

			} catch (Exception e) {
				System.out.println(e);
			}
			return lista;
		}

		public void Eliminar(Consulta usu) {
			try {
				CallableStatement consulta = conexion.prepareCall("call SP_D_Consulta (?) ");
				consulta.setInt("pId", usu.getId());
				consulta.execute();
				System.out.println("exito");
				conexion.close();
			} catch (Exception e) {
				System.out.println("error");

			}

		}
	}
