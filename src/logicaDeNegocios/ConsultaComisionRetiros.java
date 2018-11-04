package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;

public class ConsultaComisionRetiros implements IConsulta{
		private int numeroCuenta;

		
		public ConsultaComisionRetiros(int pNumeroCuenta) {
			numeroCuenta= pNumeroCuenta;

		}

		@Override
		public Object consultarBaseDatos() throws SQLException {
			BaseDatosN bs= new BaseDatosN();
			double saldo =  bs.selectComisionRetiros(numeroCuenta);
			return saldo;
		}

	}


