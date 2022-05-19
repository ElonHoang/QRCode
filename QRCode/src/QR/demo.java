package QR;

public class demo {
	//Cac so mac dinh
	public static final String NUMS_INDEX_1 = "000201";
	public static final String NUMS_INDEX_2 = "010212";
	public static final String NUMS_INDEX_3 = "38";
	public static final String TOTAL_PBP = "08";
	public static final String COUNTRY = "58";
	public static final String MONEY = "54";
	public static final String CODE = "53";
	public static final String CODE_PBP = "62";
	public static final String DEFAULT_CODE_INDEX_3 = "0208QRIBFTTA";
	public static final String DEFAULT_CODE_INDEX_2 = "0006970449";
	public static final String DEFAULT_CODE_INDEX_1 = "0010A000000727";
	public static final String LAST_DEFAULT_INDEX = "6304";
	public static final String CODE_ACCOUNT = "01";
	/// ISO 4217
	public static final String CODE_MONEY_VN = "704";
	public static final String CODE_MONEY_US = "840";
	public static final String CODE_MONEY_UK = "826";

	/// Variable
//	public static int countPBP = 0;
//	public static int countAccUser = 0;
//	public static int countCalSum = 0;
	/// Data fake
	static String pre = "VQR";
	static String bill = "0000003113";
	static String partner = "BA2205050334";
	static String stk = "999999319999";
	static String country = "VN";
	static String moneyNum = "20000000";

	public static String TotalPreBillPartner(String prefix, String billNum, String partnerCode) {
		String total = "";
		String count = prefix + billNum + partnerCode;// gop 3 chuoi sau khi nhap
		total = TOTAL_PBP + (int) count.length() + count;// tinh tong so ki tu chuoi "count" va gan phia truoc chuoi count
		//countPBP = (int)total.length();
		return total;
	}
	//Result : 0825
				//VQR0000003113BA2205050334
	public static int countTotalPreBillPartner() {
		int cal = 0;
		cal = TotalPreBillPartner(pre,bill,partner).length();//Tinh tong so chuoi trong TotalPreBillPartner
		return cal;
	}
	//Result : 29
	
	public static String getCodePBP() {
		String rsCode = "";
		rsCode = CODE_PBP + countTotalPreBillPartner() + TotalPreBillPartner(pre, bill, partner);//In ra so chuoi tim dc tu countTotalPreBillPartner
																									//+ TotalPreBillPartner
		return rsCode;			
	}
	//Result : 6229
				//0825
					//VQR0000003113BA2205050334

	public static String calMoneyNum(String amount) {
		String money = "";
		if (amount.length() < 10) {
			money = MONEY + "0" + (int) amount.length() + amount;//Chuoi tien gom so tien va tong so ki tu cau tien
																//Neu tien nho hon 10 thi ta them so 0 vao phia truoc
																//vi length < 10 thi in ra 3 chu khong phai 03
		} else {
			money = MONEY + (int) amount.length() + amount;
		}
		return money;
	}
		//Result : 5408
					//20000000
	
	public static String getCountry(String country) {

		String rsCountry = "";
		switch (country) {
		case "VN":
			// case "VietNam":
			Country vnCountry = Country.VN;
			rsCountry = COUNTRY + "0" + "2" + vnCountry;//Tong so ki tu cua quoc gia , tuong tu nhu cach tinh cua calMoneyNum
														//Ki tu cac quoc gia deu la 2 ki tu
														// nguon : https://download.vn/danh-sach-ten-ten-viet-tat-cua-cac-quoc-gia-tren-the-gioi-38185
			break;
		case "US":
			Country usCountry = Country.US;
			rsCountry = COUNTRY + "0" + "2" + usCountry;
			break;
		case "UK":
			Country ukCountry = Country.UK;
			rsCountry = COUNTRY + "0" + "2" + ukCountry;
			break;
		}
		return rsCountry;
	}
	//Result : 5802VN 
	
	
	public static String moneyCode(String mon) {
		String rsCountryC = "";
		if (mon == null)
			return null;
		switch (mon) {
		case "VN":
		//case "VietNam":
			if (CODE_MONEY_VN.length() < 10) {
				rsCountryC = CODE + "0" + (int) CODE_MONEY_VN.length() + CODE_MONEY_VN; //Tuong tu nhu calMoneyNum
																						//Tinh Tong ki tu viet tat cua quoc gia do va + phia truoc
																						//Nguon :https://vi.wikipedia.org/wiki/ISO_4217
			} else {
				rsCountryC = CODE + (int) CODE_MONEY_VN.length() + CODE_MONEY_VN;
			}
			break;
			//Them 1 vai quoc gia khac
		case "US":		
		//case "AMERICAN":
			if (CODE_MONEY_US.length() < 10) {
				rsCountryC = CODE + "0" + (int) CODE_MONEY_US.length() + CODE_MONEY_US;
			} else {
				rsCountryC = CODE + (int) CODE_MONEY_US.length() + CODE_MONEY_US;
			}
			break;
		case "UK":
		//case "ENGLAND":
			if (CODE_MONEY_UK.length() < 10) {
				rsCountryC = CODE + "0" + (int) CODE_MONEY_UK.length() + CODE_MONEY_UK;
			} else {
				rsCountryC = CODE + (int) CODE_MONEY_UK.length() + CODE_MONEY_UK;
			}
			break;
		default:
			if (CODE_MONEY_VN.length() < 10) {
				rsCountryC = CODE + "0" + (int) CODE_MONEY_VN.length() + CODE_MONEY_VN;
			} else {
				rsCountryC = CODE + (int) CODE_MONEY_VN.length() + CODE_MONEY_VN;
			}
			break;
		}
		return rsCountryC;
	}
	//Result : 5303
				//704 - VN, 840 - US, 826 - UK



	

	public static String accountUser(String stk) {
		String rsAcc = "";
		rsAcc = CODE_ACCOUNT + stk.length() + stk; // Ma mac dinh + Tong so ki tu trong tai khoan + tai khoan 
		//countAccUser = (int)rsAcc.length();
		return rsAcc;
		
	}
	//Result : 0112
					//999999319999
	public static String countAccUser() {
		int c = 0;
		String s = "";
		c = (int)DEFAULT_CODE_INDEX_2.length() + accountUser(stk).length(); // Dem tong so chuoi trong accountUser va DEFAULT_CODE_INDEX_2 va hien thi
		s = CODE_ACCOUNT + c + DEFAULT_CODE_INDEX_2 + accountUser(stk);
		return s;
	}
	//Result : 0126
				//0006970449
					//0112
						//999999319999

	public static String sumAll() {// Tong so cac ki tu tat ca cac chuoi tu cac method ben tren 
		String sumAll = "";
		 sumAll = DEFAULT_CODE_INDEX_1 + countAccUser() + DEFAULT_CODE_INDEX_3 ;
		return sumAll;
	}
	//Result : 0010
				//A000000727
					//0126
						//0006970449
							//0112
								//999999319999
							//0208
								//QRIBFTTA 
	public static String calSumAll() {// Tong ki tu chua ben trong SumAll va cong them so mac dinh va hien thi ra
		int c = 0;
		String a = "";
		c = (int)sumAll().length();
		a = NUMS_INDEX_3 + c + sumAll() ;
		return a;	
	}
	// Result :3856
				//0010A000000727
					//0126
						//0006970449
							//0112
								//999999319999
									//0208
										//QRIBFTTA
	
	public static int crc16(final byte[] value) {
	    final int polynomial = 0x1021; // 0001 0000 0010 0001 (0, 5, 12)

	    int result = 0xFFFF; // initial value

	    final byte[] bytes = value;

	    for (final byte b : bytes) {
	      for (int i = 0; i < 8; i++) {
	        final boolean bit = (b >> 7 - i & 1) == 1;
	        final boolean c15 = (result >> 15 & 1) == 1;
	        result <<= 1;
	        if (c15 ^ bit) {
	          result ^= polynomial;
	        }
	      }
	    }

	    result &= 0xffff;

	    return result;
	  }
	
//	public static String countGenCRC() {//dem co bao nhieu ki tu dc genCRC
//		String c = "";
//		if(genCRC().length() < 10) {
//			c = "0" +  genCRC().length();
//		}else {
//			c = String.valueOf(genCRC().length());
//		}
//		return c;
//	}
	//Result : 04
	
	
	public static String genCRC() {
		String rsGen = "";
		rsGen = NUMS_INDEX_1 + NUMS_INDEX_2 + calSumAll() 
				+ moneyCode(country) + calMoneyNum(moneyNum) 
				+ getCountry(country) + getCodePBP() 
				+ LAST_DEFAULT_INDEX ;
		
		//System.out.println(rsGen);
		int convert = crc16(rsGen.getBytes());
		return 
				Integer.toHexString(convert);
			//;
	}
	// 5583
	
	
	
	
	public static String all() {
		String rsGen = "";
		rsGen = NUMS_INDEX_1 + NUMS_INDEX_2 + calSumAll() 
				+ moneyCode(country) + calMoneyNum(moneyNum) 
				+ getCountry(country) + getCodePBP() + LAST_DEFAULT_INDEX;
		return rsGen;
	}
	

	public static String genQRcode() {
	String qr = "";
		qr = all() + genCRC();
	return qr;
}
//Result : 00020101021238560010A0000007270126000697044901129999993199990208QRIBFTTA53037045408200000005802VN62290825VQR0000003113BA220505033463045583 
	public static void main(String[] args) {
		//int xxx = crc16("00020101021238560010A0000007270126000697044901129999993199990208QRIBFTTA53037045408200000005802VN62290825VQR0000003113BA22050503346304".getBytes());
		
		//System.out.println(Integer.toHexString(xxx));
		System.out.println(genQRcode());
	}

	

}
