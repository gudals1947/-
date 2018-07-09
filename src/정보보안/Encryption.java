package 정보보안;

import java.util.ArrayList;
import java.util.Collections;

public class Encryption {
	private ArrayList<Integer> bit_key_8 = new ArrayList<Integer>();
	private ArrayList<Integer> ip_list = new ArrayList<Integer>();
	private ArrayList<Integer> ip = new ArrayList<Integer>();
	private ArrayList<Integer> ip1 = new ArrayList<Integer>();
	private ArrayList<Integer> ip_result = new ArrayList<Integer>();
	private ArrayList<Integer> ip_final_result = new ArrayList<Integer>();
	private ArrayList<Integer> ip_converse_list = new ArrayList<Integer>(); 
	private ArrayList<Integer> ip_converse_result = new ArrayList<Integer>(); 
	private ArrayList<Integer> left_key = new ArrayList<Integer>();
	private ArrayList<Integer> right_key = new ArrayList<Integer>();
	private ArrayList<Integer> e_p = new ArrayList<Integer>(); 
	private ArrayList<Integer> e_p__result = new ArrayList<Integer>(); 
	private ArrayList<Integer> result1 = new ArrayList<Integer>();
	private ArrayList<Integer> k1 = new ArrayList<Integer>();
	private ArrayList<Integer> k2 = new ArrayList<Integer>();
	private ArrayList<Integer> xor = new ArrayList<Integer>();
	private ArrayList<Integer> left_key1 = new ArrayList<Integer>();
	private ArrayList<Integer> right_key1 = new ArrayList<Integer>();
	private ArrayList<String> line_result = new ArrayList<String>();
	private ArrayList<Integer> line_result1 = new ArrayList<Integer>();
	private ArrayList<Integer> line_result2 = new ArrayList<Integer>();
	private ArrayList<Integer> p4 = new ArrayList<Integer>();
	private ArrayList<Integer> fk_1 = new ArrayList<Integer>();
	private ArrayList<Integer> fk_2 = new ArrayList<Integer>();
	private ArrayList<Integer> sw = new ArrayList<Integer>();
	private int S0[][] = new int[4][4];
	private int S1[][] = new int[4][4];
	private String result = "";

	public void Encry(ArrayList<Integer> bit_key_8, ArrayList<Integer> k1, ArrayList<Integer> k2,
			ArrayList<Integer> ip_list, ArrayList<Integer> ip_converse_list, ArrayList<Integer> e_p, int[][] S0,
			int[][] S1, ArrayList<Integer> p4) {
		// TODO Auto-generated constructor stub
		this.bit_key_8 = bit_key_8;
		this.k1 = k1;
		this.k2 = k2;
		this.e_p = e_p;
		this.ip_list = ip_list;
		this.ip_converse_list = ip_converse_list;
		this.S0 = S0;
		this.S1 = S1;
		this.p4 = p4;
		
		Ip_result(ip_list, bit_key_8);  //IP로 전치
		ip_result = ip;                
		left_key = Left_Key_Create(ip); //왼쪽 4비트
		right_key = Right_Key_Create(ip); //오른쪽 4비트
		Fk(); // E/p 계산과정
		xor = Xor(e_p__result, k1); // E/P 값과 K1 XOR 연산
		left_key1 = Left_Key_Create(xor); //왼쪽 4비트
		right_key1 = Right_Key_Create(xor); //오른쪽 4비트
		S_result(left_key1, right_key1); //S박스 과정 수행
		P4(); //S박스 결과를 P4로 전치
		Endfk(); //P4결과값과 IP의 왼쪽 4비트 XOR
		this.bit_key_8.removeAll(this.bit_key_8);
		this.bit_key_8.addAll(xor);
		this.bit_key_8.addAll(right_key);
		fk_1.removeAll(fk_1);
		fk_1.addAll(this.bit_key_8);
		
		Sw();  //왼쪽 4비트와 오른쪽 4비트를 스위치
		
		left_key = Left_Key_Create(this.bit_key_8); //왼쪽 4비트
		right_key = Right_Key_Create(this.bit_key_8); //오른쪽 4비트
		Ip_result(e_p, this.bit_key_8); 
		Fk(); // E/p 계산과정
		xor = Xor(e_p__result, k2); //E/P 값과 K2 XOR 연산
		left_key1 = Left_Key_Create(xor); //왼쪽 4비트
		right_key1 = Right_Key_Create(xor); //오른쪽 4비트
		S_result(left_key1, right_key1); //S박스 과정 수행
		P4(); //S박스 결과를 P4로 전치
		Endfk(); //P4결과값과 SW의 왼쪽 4비트 XOR
		this.bit_key_8.removeAll(this.bit_key_8);
		this.bit_key_8.addAll(xor);
		this.bit_key_8.addAll(right_key);
		fk_2.removeAll(fk_2);
		fk_2.addAll(this.bit_key_8);
		Ip_converse_list(); //IP-1 전치과정수행
		
		ip_final_result.addAll(ip1);
	}

	public String result() {
		// TODO Auto-generated method stub
		Integer b;
		int i = 0;
		String a = "";
		while (true) {
			if (result1.get(i) == 1) { //1byte인 경우 (영어)
				for (int j = 0; j < 8; j++) {
					result += Integer.toBinaryString(ip_final_result.get(0));
					ip_final_result.remove(0);
				}
				i++;
			} else if (result1.get(i) == 2) { //2byte인 경우 (한글, 특수문자)
				for (int j = 0; j < 16; j++) {
					result += Integer.toBinaryString(ip_final_result.get(0));
					ip_final_result.remove(0);
				}
				i++;
			}
			b = Integer.valueOf(result, 2);
			try {
				a += String.format("%c", b);
				result = "";
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (ip_final_result.size() == 0) {
				break;
			}
		}
		return a;
	}

	public Encryption(ArrayList<Integer> result1) {
		// TODO Auto-generated constructor stub
		this.result1 = result1;
	}

	private void Ip_converse_list() {
		// TODO Auto-generated method stub
		ip1.removeAll(ip1);
		ip_converse_result.removeAll(ip_converse_result);
		for (int i = 0; i < bit_key_8.size(); i++) {
			ip1.add(fk_2.get(ip_converse_list.get(i) - 1));
		}
		ip_converse_result.addAll(ip1);
	}

	private void Sw() {
		// TODO Auto-generated method stub
		sw.removeAll(sw);
		this.bit_key_8.removeAll(this.bit_key_8);
		this.bit_key_8.addAll(right_key);
		this.bit_key_8.addAll(xor);
		sw.addAll(this.bit_key_8);
	}

	private void Endfk() {
		// TODO Auto-generated method stub
		xor = Xor(line_result2, left_key);
	}


	private void Ip_result(ArrayList<Integer> list, ArrayList<Integer> bit_key_8) {
		// TODO Auto-generated method stub
		ip.removeAll(ip);
		for (int i = 0; i < list.size(); i++) {
			ip.add(bit_key_8.get(list.get(i) - 1));
		}
	}

	private void P4() {
		// TODO Auto-generated method stub

		P4_1();
	}

	private void P4_1() {
		// TODO Auto-generated method stub
		for (int i = 0; i < p4.size(); i++) {
			line_result2.add(line_result1.get(p4.get(i) - 1));
		}
	}

	private void S_result(ArrayList<Integer> left_key12, ArrayList<Integer> right_key12) {
		// TODO Auto-generated method stub
		line_result1.removeAll(line_result1);
		line_result2.removeAll(line_result2);
		line_result.removeAll(line_result);
		line_result.add(Line_seach(left_key12, 0)); //왼쪽 S박스
		line_result.add(Line_seach(right_key12, 1)); //오른쪽 S박스
		for (int i = 0; i < line_result.size(); i++) {
			for (int j = 0; j < line_result.size(); j++) {
				line_result1.add(Integer.parseInt(String.valueOf(line_result.get(i).charAt(j))));
			}
		}
	}

	private String Line_seach(ArrayList<Integer> key, int check) {
		// TODO Auto-generated method stub
		String num = "", num1 = "";
		int row, column;
		for (int i = 0; i < key.size(); i++) {
			if (i == 0 || i == 3) {
				num += String.valueOf(key.get(i));
			} else {
				num1 += String.valueOf(key.get(i));
			}
		}
		row = Integer.parseInt(num, 2);
		column = Integer.parseInt(num1, 2);
		
		String result = "";
		if (check == 0) {
			result = Integer.toBinaryString(S0[row][column]);
		} else if (check == 1) {
			result = Integer.toBinaryString(S1[row][column]);
		}
		for (int i = 0; i < 2; i++) {
			if (result.equals("" + i)) {
				result = "0" + i;
				break;
			}
		}
		return result;
	}

	private void Fk() {
		// TODO Auto-generated method stub
		e_p__result.removeAll(e_p__result);

		for (int i = 0; i < e_p.size(); i++) {
			e_p__result.add(this.right_key.get(e_p.get(i) - 1));
		}

	}

	private ArrayList<Integer> Xor(ArrayList<Integer> result, ArrayList<Integer> key) {
		// TODO Auto-generated method stub
		ArrayList<Integer> xor = new ArrayList<Integer>();
		xor.removeAll(xor);
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i) == key.get(i)) {
				xor.add(0);
			} else {
				xor.add(1);
			}
		}
		return xor;
	}

	private ArrayList<Integer> Right_Key_Create(ArrayList<Integer> bit_key_8) {
		// TODO Auto-generated method stub
		ArrayList<Integer> right_key = new ArrayList<Integer>();
		right_key.removeAll(right_key);
		for (int i = bit_key_8.size() / 2; i < bit_key_8.size(); i++) {
			right_key.add(bit_key_8.get(i));
		}
		return right_key;
	}

	private ArrayList<Integer> Left_Key_Create(ArrayList<Integer> bit_key_8) {
		// TODO Auto-generated method stub
		ArrayList<Integer> left_key = new ArrayList<Integer>();
		left_key.removeAll(left_key);
		for (int i = 0; i < bit_key_8.size() / 2; i++) {
			left_key.add(bit_key_8.get(i));
		}
		return left_key;
	}

	public void result1(ArrayList<Integer> result1) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> getIp_result() {
		return ip_result;
	}

	public ArrayList<Integer> getFk_1() {
		return fk_1;
	}

	public ArrayList<Integer> getSw() {
		return sw;
	}

	public ArrayList<Integer> getFk_2() {
		return fk_2;
	}

	public ArrayList<Integer> getIp_converse_result() {
		return ip_converse_result;
	}

}
