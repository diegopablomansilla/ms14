package com.massoftware.ui;

public class FormatIntegra {

	public String integraFormat = "";
	public String integraPrefijoFormat = "";
	public String integraSufijoFormat = "";

	public boolean formatCuentaJerarquia(String integra) {

		if (integra != null && integra.length() == 11) {

			int c = 0;

			String s0 = integra.charAt(c) + "";
			String s1 = integra.charAt(++c) + "" + integra.charAt(++c);
			String s2 = integra.charAt(++c) + "" + integra.charAt(++c);
			String s3 = integra.charAt(++c) + "" + integra.charAt(++c);
			String s4 = integra.charAt(++c) + "" + integra.charAt(++c);
			String s5 = integra.charAt(++c) + "" + integra.charAt(++c);

			int p0 = Integer.valueOf(s0);
			int p1 = Integer.valueOf(s1);
			int p2 = Integer.valueOf(s2);
			int p3 = Integer.valueOf(s3);
			int p4 = Integer.valueOf(s4);
			int p5 = Integer.valueOf(s5);

			if (p5 > 0) {

				// error
//				return false;
				
				integraPrefijoFormat = s0 + "+" + s1 + "+" + s2 + "+" + s3 + "+" + s4;
				integraSufijoFormat = "." + s5;

			} else if (p4 > 0) {

				integraPrefijoFormat = s0 + "." + s1 + "." + s2 + "." + s3;
				integraSufijoFormat = "." + s4 + "." + s5;

			} else if (p3 > 0) {

				integraPrefijoFormat = s0 + "." + s1 + "." + s2 ;
				integraSufijoFormat = "." + s3 + "." + s4 + "." + s5;

			} else if (p2 > 0) {

				integraPrefijoFormat = s0 + "." + s1 ;
				integraSufijoFormat = "." + s2  + "." + s3 + "." + s4 + "." + s5;

			} else if (p1 > 0) {

				integraPrefijoFormat = s0 ;
				integraSufijoFormat = "." + s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5;

			} else if (p0 > 0) {

				integraPrefijoFormat = s0;
				integraSufijoFormat = "-" + s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5;

			} else {

				integraPrefijoFormat = "";
				integraSufijoFormat = s0 + "." + s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5;
			}

			integraFormat = integraPrefijoFormat + integraSufijoFormat;

			return true;

		} else if (integra != null && integra.length() != 11) {
			return false;
		}

		return false;

	}

}
