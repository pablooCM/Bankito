package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;

public class ConsultaCantidadRetiros implements IConsulta {
		private int numeroCuenta;

		
		public ConsultaCantidadRetiros(int pNumeroCuenta) {
			numeroCuenta= pNumeroCuenta;

		}

		@Override
		public Object consultarBaseDatos() throws SQLException {
			BaseDatosN bs= new BaseDatosN();
			int saldo =  bs.selectCantidadRetiros(numeroCuenta);
			return saldo;
		}

	}

