package com.massoftware.ui;

public class FormatJerarquia {

	public String integraFormat = "";
	public String integraPrefijoFormat = "";
	public String integraSufijoFormat = "";

	public String integra = "";
	public String integraPrefijo = "";
	public String integraSufijo = "";
	
	public String jerarquiaFormat = "";
	public String jerarquiaPrefijoFormat = "";
	public String jerarquiaSufijoFormat = "";

	private boolean formatCuentaJerarquia(String cuentaJerarquia) {

		if (cuentaJerarquia != null && cuentaJerarquia.length() == 11) {

			int c = 0;

			String s0 = cuentaJerarquia.charAt(c) + "";
			String s1 = cuentaJerarquia.charAt(++c) + "" + cuentaJerarquia.charAt(++c);
			String s2 = cuentaJerarquia.charAt(++c) + "" + cuentaJerarquia.charAt(++c);
			String s3 = cuentaJerarquia.charAt(++c) + "" + cuentaJerarquia.charAt(++c);
			String s4 = cuentaJerarquia.charAt(++c) + "" + cuentaJerarquia.charAt(++c);
			String s5 = cuentaJerarquia.charAt(++c) + "" + cuentaJerarquia.charAt(++c);

			int p0 = Integer.valueOf(s0);
			int p1 = Integer.valueOf(s1);
			int p2 = Integer.valueOf(s2);
			int p3 = Integer.valueOf(s3);
			int p4 = Integer.valueOf(s4);
			int p5 = Integer.valueOf(s5);

			if (p5 > 0) {

				integraPrefijoFormat = s0 + "." + s1 + "." + s2 + "." + s3 + "." + s4;
				integraSufijoFormat = "." + "00";

				integraPrefijo = s0 + "" + s1 + "" + s2 + "" + s3 + "" + s4;
				integraSufijo = "00";

				jerarquiaPrefijoFormat = s0 + "." + s1 + "." + s2 + "." + s3 + "." + s4;
				jerarquiaSufijoFormat = "." + s5;

			} else if (p4 > 0) {

//				integraPrefijoFormat = s0 + "." + s1 + "." + s2 /*+ "." + s3*/;
//				integraSufijoFormat = "." + "00" + "." + "00" + "." + "00";
//
//				integraPrefijo = s0 + "" + s1 + "" + s2 /*+ "" + s3*/;
//				integraSufijo = "" + "00" + "" + "00" + "" + "00";

				jerarquiaPrefijoFormat = s0 + "." + s1 + "." + s2 + "." + s3;
				jerarquiaSufijoFormat = "." + s4 + "." + s5;
				
				integraPrefijoFormat = jerarquiaPrefijoFormat;
				integraSufijoFormat = "." + "ZZ" + "." + "ZZ";
				
				integraPrefijo = integraPrefijoFormat.replace(".", "");
				integraSufijo = jerarquiaSufijoFormat.replace(".", "");

			} else if (p3 > 0) {

				integraPrefijoFormat = s0 + "." + s1 + "." + s2;
				integraSufijoFormat = "." + "00" + "." + "00" + "." + "00";

				integraPrefijo = s0 + "" + s1 + "" + s2;
				integraSufijo = "" + "00" + "" + "00" + "" + "00";

				jerarquiaPrefijoFormat = s0 + "." + s1 + "." + s2;
				jerarquiaSufijoFormat = "." + s3 + "." + s4 + "." + s5;

			} else if (p2 > 0) {

				integraPrefijoFormat = s0 + "." + s1;
				integraSufijoFormat = "." + "00" + "." + "00" + "." + "00" + "." + "00";

				integraPrefijo = s0 + "" + s1;
				integraSufijo = "" + "00" + "" + "00" + "" + "00" + "" + "00";

				jerarquiaPrefijoFormat = s0 + "." + s1;
				jerarquiaSufijoFormat = "." + s2 + "." + s3 + "." + s4 + "." + s5;

			} else if (p1 > 0) {

				integraPrefijoFormat = s0;
				integraSufijoFormat = "." + "00" + "." + "00" + "." + "00" + "." + "00" + "." + "00";

				integraPrefijo = s0;
				integraSufijo = "" + "00" + "" + "00" + "" + "00" + "" + "00" + "" + "00";

				jerarquiaPrefijoFormat = s0;
				jerarquiaSufijoFormat = "." + s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5;

			} else if (p0 > 0) {

				integraPrefijoFormat = "";
				integraSufijoFormat = "00" + "." + "00" + "." + "00" + "." + "00" + "." + "00" + "." + "00";

				integraPrefijo = "";
				integraSufijo = "00" + "" + "00" + "" + "00" + "" + "00" + "" + "00" + "" + "00";

				jerarquiaPrefijoFormat = "";
				jerarquiaSufijoFormat = s0 + "." + s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5;

			} else {

				integraPrefijoFormat = "";
				integraSufijoFormat = "00" + "." + "00" + "." + "00" + "." + "00" + "." + "00" + "." + "00";

				integraPrefijo = "";
				integraSufijo = "00" + "" + "00" + "" + "00" + "" + "00" + "" + "00" + "" + "00";

				jerarquiaPrefijoFormat = "";
				jerarquiaSufijoFormat = s0 + "." + s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5;
			}

			integraFormat = integraPrefijoFormat + integraSufijoFormat;
			integra = integraPrefijo + integraSufijo;
			jerarquiaFormat = jerarquiaPrefijoFormat + jerarquiaSufijoFormat;

			return true;

		} else if (cuentaJerarquia != null && cuentaJerarquia.length() != 11) {
			return false;
		}
		
		return false;

	}

}
