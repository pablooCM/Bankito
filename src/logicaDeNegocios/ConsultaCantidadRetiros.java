package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;

public class ConsultaCantidadRetiros implements IConsulta {
		private int numeroCuenta;

		
		public ConsultaCantidadRetiros(int pNumeroCuenta) {
			numeroCuenta= pNumeroCuenta;

		}

		@Override
		public Object consultarBaseDatos() throws SQLException {
			BaseDatos bs= new BaseDatos();
			int saldo =  bs.selectCantidadRetiros(numeroCuenta);
			return saldo;
		}

	}

