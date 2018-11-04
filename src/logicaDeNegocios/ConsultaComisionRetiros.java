package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;

public class ConsultaComisionRetiros implements IConsulta{
		private int numeroCuenta;

		
		public ConsultaComisionRetiros(int pNumeroCuenta) {
			numeroCuenta= pNumeroCuenta;

		}

		@Override
		public Object consultarBaseDatos() throws SQLException {
			BaseDatos bs= new BaseDatos();
			double saldo =  bs.selectComisionRetiros(numeroCuenta);
			return saldo;
		}

	}


