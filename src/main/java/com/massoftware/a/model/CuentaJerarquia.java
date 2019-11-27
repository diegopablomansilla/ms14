package com.massoftware.a.model;

public class CuentaJerarquia {

	public String integra;
	public String cuentaJerarquia;
	public String integraCompute;

	public char[] chars;

	public String s0 = "_";
	public String s1 = "__";
	public String s2 = "__";
	public String s3 = "__";
	public String s4 = "__";
	public String s5 = "__";

	public String sI0 = "_";
	public String sI1 = "__";
	public String sI2 = "__";
	public String sI3 = "__";
	public String sI4 = "__";
	public String sI5 = "__";

	public Integer p0;
	public Integer p1;
	public Integer p2;
	public Integer p3;
	public Integer p4;
	public Integer p5;

	public String format;
	public String formatPositionsufix;
	public String formatPrefix;
	public String formatSufix;
	public String formatPrefixSufix;

	public String formatIntegra;
	public String formatIntegraPrefix;
	public String formatIntegraSufix;
	public String formatIntegraPrefixSufix;

	public boolean isLength11;

	public boolean isNullError;
	public boolean isEmptyError;
	public boolean isLengthMayor11Error;
	public boolean isLengthMinor11Error;
	public boolean isCharsNotNumberError;
	public boolean isValueError;
	public boolean isIntegraEqualsError;

	public boolean p0NumberError;
	public boolean p1NumberError;
	public boolean p2NumberError;
	public boolean p3NumberError;
	public boolean p4NumberError;
	public boolean p5NumberError;

	public boolean c0NumberError;
	public boolean c1NumberError;
	public boolean c2NumberError;
	public boolean c3NumberError;
	public boolean c4NumberError;
	public boolean c5NumberError;
	public boolean c6NumberError;
	public boolean c7NumberError;
	public boolean c8NumberError;
	public boolean c9NumberError;
	public boolean c10NumberError;

	public boolean p0ValueError;
	public boolean p1ValueError;
	public boolean p2ValueError;
	public boolean p3ValueError;
	public boolean p4ValueError;
	public boolean p5ValueError;

	public boolean p0ValueSufix;
	public boolean p1ValueSufix;
	public boolean p2ValueSufix;
	public boolean p3ValueSufix;
	public boolean p4ValueSufix;
	public boolean p5ValueSufix;

	public CuentaJerarquia(String cuentaJerarquiaArg, String integraArg) {

		cuentaJerarquia = cuentaJerarquiaArg;
		integra = integraArg;

		// formato válido ########### (#.##.##.##.##.##), es decir todos los # son [0-9]
		// validar que todos los pares padres tengan un numero mayor a 0
		// entonces recorremos de izquierda a derecha
		// en cuanto encuentre un 00, el resto de pares tienen que ser 00 si o si
		// si no es asi es un error
		// Nota: el primer numero no debe ser 0

		isNullError = cuentaJerarquiaArg == null;

		cuentaJerarquiaArg = isNullError ? "" : cuentaJerarquiaArg.trim();

		isEmptyError = cuentaJerarquiaArg.length() == 0;
		isLength11 = cuentaJerarquiaArg.length() == 11;
		isLengthMinor11Error = cuentaJerarquiaArg.length() < 11;
		isLengthMayor11Error = cuentaJerarquiaArg.length() > 11;
		chars = cuentaJerarquiaArg.toCharArray();

		if (isNullError || isEmptyError) {
			p0NumberError = true;
			p1NumberError = true;
			p2NumberError = true;
			p3NumberError = true;
			p4NumberError = true;
			p5NumberError = true;
		}

		for (int i = 0; i < chars.length; i++) {

			char c = chars[i];

			if ((c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7'
					|| c == '8' || c == '9') == false) {

				isCharsNotNumberError = true;

				if (i == 0) {
					p0NumberError = true;
				} else if (i == 1 || i == 2) {
					p1NumberError = true;
				} else if (i == 3 || i == 4) {
					p2NumberError = true;
				} else if (i == 5 || i == 6) {
					p3NumberError = true;
				} else if (i == 7 || i == 8) {
					p4NumberError = true;
				} else if (i == 9 || i == 10) {
					p5NumberError = true;
				}

				if (i == 0) {
					c0NumberError = true;
				} else if (i == 1) {
					c1NumberError = true;
				} else if (i == 2) {
					c2NumberError = true;
				} else if (i == 3) {
					c3NumberError = true;
				} else if (i == 4) {
					c4NumberError = true;
				} else if (i == 5) {
					c5NumberError = true;
				} else if (i == 6) {
					c6NumberError = true;
				} else if (i == 7) {
					c7NumberError = true;
				} else if (i == 8) {
					c8NumberError = true;
				} else if (i == 9) {
					c9NumberError = true;
				} else if (i == 10) {
					c10NumberError = true;
				}

			}
		}

		if (chars.length > 0) {
			s0 = chars[0] + "";
		}

		if (chars.length > 1) {
			s1 = chars[1] + "_";
		}

		if (chars.length > 2) {
			s1 = chars[1] + "" + chars[2];
		}

		if (chars.length > 3) {
			s2 = chars[3] + "_";
		}

		if (chars.length > 4) {
			s2 = chars[3] + "" + chars[4];
		}

		if (chars.length > 5) {
			s3 = chars[5] + "_";
		}

		if (chars.length > 6) {
			s3 = chars[5] + "" + chars[6];
		}

		if (chars.length > 7) {
			s4 = chars[7] + "_";
		}

		if (chars.length > 8) {
			s4 = chars[7] + "" + chars[8];
		}

		if (chars.length > 9) {
			s5 = chars[9] + "_";
		}

		if (chars.length > 10) {
			s5 = chars[9] + "" + chars[10];
		}

		p0 = s0 != null && isNumber(s0) ? Integer.valueOf(s0) : null;
		p1 = s1 != null && isNumber(s1) ? Integer.valueOf(s1) : null;
		p2 = s2 != null && isNumber(s2) ? Integer.valueOf(s2) : null;
		p3 = s3 != null && isNumber(s3) ? Integer.valueOf(s3) : null;
		p4 = s4 != null && isNumber(s4) ? Integer.valueOf(s4) : null;
		p5 = s5 != null && isNumber(s5) ? Integer.valueOf(s5) : null;

		format = s0 + "." + s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5;

		if (p0 != null && p0 == 0) {
			p0ValueError = true;
		}

		if (p1 != null && p1 == 0) {
			p1ValueError = ((p2 == null ? 0 : p2) + (p3 == null ? 0 : p3) + (p4 == null ? 0 : p4)
					+ (p5 == null ? 0 : p5)) != 0;
		}

		if (p2 != null && p2 == 0) {
			p2ValueError = ((p3 == null ? 0 : p3) + (p4 == null ? 0 : p4) + (p5 == null ? 0 : p5)) != 0;
		}

		if (p3 != null && p3 == 0) {
			p3ValueError = ((p4 == null ? 0 : p4) + (p5 == null ? 0 : p5)) != 0;
		}

		if (p4 != null && p4 == 0) {
			p4ValueError = (p5 == null ? 0 : p5) != 0;
		}

		isValueError = p0ValueError == true || p1ValueError == true || p2ValueError == true || p3ValueError == true
				|| p4ValueError == true || p5ValueError == true;

		// ---

		if (p5 != null && p5 > 0) {
			p5ValueSufix = true;
		} else if (p4 != null && p4 > 0) {
			p4ValueSufix = true;
		} else if (p3 != null && p3 > 0) {
			p3ValueSufix = true;
		} else if (p2 != null && p2 > 0) {
			p2ValueSufix = true;
		} else if (p1 != null && p1 > 0) {
			p1ValueSufix = true;
		} else if (p0 != null && p0 > 0) {
			p0ValueSufix = true;
		}

		formatPositionsufix = (p0ValueSufix == true ? "[" + s0 + "]" : s0) + "."
				+ (p1ValueSufix == true ? "[" + s1 + "]" : s1) + "." + (p2ValueSufix == true ? "[" + s2 + "]" : s2)
				+ "." + (p3ValueSufix == true ? "[" + s3 + "]" : s3) + "."
				+ (p4ValueSufix == true ? "[" + s4 + "]" : s4) + "." + (p5ValueSufix == true ? "[" + s5 + "]" : s5);

		if (p0ValueSufix) {

			sI0 = "0";
			sI1 = "00";
			sI2 = "00";
			sI3 = "00";
			sI4 = "00";
			sI5 = "00";

			formatSufix = s0 + "." + s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5;
			formatPrefix = "";

			formatIntegraPrefix = formatPrefix;
			formatIntegraSufix = "0.00.00.00.00.00";
//			formatIntegra = formatIntegraSufix;

		} else if (p1ValueSufix) {

			sI0 = s0;
			sI1 = "00";
			sI2 = "00";
			sI3 = "00";
			sI4 = "00";
			sI5 = "00";

			formatSufix = s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5;
			formatPrefix = s0;

			formatIntegraPrefix = formatPrefix;
			formatIntegraSufix = "00.00.00.00.00";
//			formatIntegra = formatPrefix + "." + formatIntegraSufix;

		} else if (p2ValueSufix) {

			sI0 = s0;
			sI1 = s1;
			sI2 = "00";
			sI3 = "00";
			sI4 = "00";
			sI5 = "00";

			formatSufix = s2 + "." + s3 + "." + s4 + "." + s5;
			formatPrefix = s0 + "." + s1;

			formatIntegraPrefix = formatPrefix;
			formatIntegraSufix = "00.00.00.00";
//			formatIntegra = formatPrefix + "." + formatIntegraSufix;

		} else if (p3ValueSufix) {

			sI0 = s0;
			sI1 = s1;
			sI2 = s2;
			sI3 = "00";
			sI4 = "00";
			sI5 = "00";

			formatSufix = s3 + "." + s4 + "." + s5;
			formatPrefix = s0 + "." + s1 + "." + s2;

			formatIntegraPrefix = formatPrefix;
			formatIntegraSufix = "00.00.00";
//			formatIntegra = formatPrefix + "." + formatIntegraSufix;

		} else if (p4ValueSufix) {

			sI0 = s0;
			sI1 = s1;
			sI2 = s2;
			sI3 = s3;
			sI4 = "00";
			sI5 = "00";

			formatSufix = s4 + "." + s5;
			formatPrefix = s0 + "." + s1 + "." + s2 + "." + s3;

			formatIntegraPrefix = formatPrefix;
			formatIntegraSufix = "00.00";
//			formatIntegra = formatPrefix + "." + formatIntegraSufix;

		} else if (p5ValueSufix) {

			sI0 = s0;
			sI1 = s1;
			sI2 = s2;
			sI3 = s3;
			sI4 = s4;
			sI5 = "00";

			formatSufix = s5;
			formatPrefix = s0 + "." + s1 + "." + s2 + "." + s3 + "." + s4;

			formatIntegraPrefix = formatPrefix;
			formatIntegraSufix = "00";
//			formatIntegra = formatPrefix + "." + formatIntegraSufix;
		}

		formatPrefixSufix = "[" + formatPrefix + "].[" + formatSufix + "]";
		formatIntegraPrefixSufix = "[" + formatIntegraPrefix + "].[" + formatIntegraSufix + "]";
		formatIntegra = sI0 + "." + sI1 + "." + sI2 + "." + sI3 + "." + sI4 + "." + sI5;

		integraCompute = sI0 + sI1 + sI2 + sI3 + sI4 + sI5;

		if (integra != null && integra.trim().length() > 0) {
			isIntegraEqualsError = integra.trim().equals(integraCompute) == false;
		}

	} // -------------------------------------------

	public boolean isError() {

		if (isNullError) {
			return true;
		}

		if (isEmptyError) {
			return true;
		}

		if (isLengthMinor11Error) {
			return true;
		}

		if (isLengthMayor11Error) {
			return true;
		}

		if (isCharsNotNumberError) {
			return true;
		}

		if (isValueError) {
			return true;
		}

		if (isIntegraEqualsError) {
			return true;
		}

		// -------------------------------------------

		return false;

	} // -------------------------------------------
	
	public boolean isErrorOnlyJerarquia() {

		if (isNullError) {
			return true;
		}

		if (isEmptyError) {
			return true;
		}

		if (isLengthMinor11Error) {
			return true;
		}

		if (isLengthMayor11Error) {
			return true;
		}

		if (isCharsNotNumberError) {
			return true;
		}

		if (isValueError) {
			return true;
		}

//		if (isIntegraEqualsError) {
//			return true;
//		}

		// -------------------------------------------

		return false;

	} // -------------------------------------------

	private boolean isNumber(String s) {

		if (s == null) {
			return false;
		}

		s = s.trim();

		if (s.length() == 0) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if ((c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7'
					|| c == '8' || c == '9') == false) {

				return false;
			}
		}

		return true;

	}

	public static String formtatCC(String cuentaJerarquia) {

		String formatted = "";

		if (cuentaJerarquia != null && cuentaJerarquia.length() == 11) {

			for (int i = 0; i < 11; i++) {

				if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9) {
					formatted += ".";
				}
				formatted += cuentaJerarquia.charAt(i);

			}

		} else if (cuentaJerarquia != null && cuentaJerarquia.length() != 11) {

			return cuentaJerarquia;
		}

		return formatted;
	}

}
