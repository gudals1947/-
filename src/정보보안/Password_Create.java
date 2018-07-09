package 정보보안;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Password_Create {
	ArrayList<Integer> bit_key_10 = new ArrayList<Integer>();
	ArrayList<Integer> bit_key_10_store = new ArrayList<Integer>();
	ArrayList<Integer> p10 = new ArrayList<Integer>();
	ArrayList<Integer> left_key = new ArrayList<Integer>();
	ArrayList<Integer> right_key = new ArrayList<Integer>();
	ArrayList<Integer> k1 = new ArrayList<Integer>();
	ArrayList<Integer> k2 = new ArrayList<Integer>();
	ArrayList<Integer> shift_key = new ArrayList<Integer>();
	ArrayList<Integer> shift_key_2 = new ArrayList<Integer>();
	
	public Password_Create(ArrayList<Integer> bit_key_10) {
		// TODO Auto-generated constructor stub
		this.bit_key_10 = bit_key_10;
		Collections.shuffle(this.bit_key_10);
		p10.addAll(this.bit_key_10);

		left_key = Left_Key_Create(bit_key_10); //왼쪽 5비트
		left_key = shift(left_key); //쉬프트연산
		right_key = Right_Key_Create(bit_key_10); //오른쪽 5비트
		right_key = shift(right_key); //쉬프트연산

		this.bit_key_10_store.removeAll(this.bit_key_10);
		this.bit_key_10_store.addAll(left_key); 
		this.bit_key_10_store.addAll(right_key);
		shift_store(bit_key_10_store);   //쉬프트 결과값 저장
		
		this.bit_key_10_store = Remove_Bit(bit_key_10_store);
		k1.addAll(bit_key_10_store); 
		Collections.shuffle(k1); //k1 전치 과정

		this.bit_key_10_store.removeAll(this.bit_key_10_store); 
		
		left_key = shift(left_key); //쉬프트 연산
		right_key = shift(right_key); //쉬프트 연산
		left_key = shift(left_key); //쉬프트 연산
		right_key = shift(right_key); //쉬프트 연산
		this.bit_key_10_store.addAll(left_key);
		this.bit_key_10_store.addAll(right_key);
		shift_store2(this.bit_key_10_store);  //쉬프트 결과값 저장
		this.bit_key_10_store = Remove_Bit(bit_key_10_store);
		k2.addAll(bit_key_10_store); 
		Collections.shuffle(k2); //k2 전치 과정
	}

	private void shift_store(ArrayList<Integer> shift_key) {
		// TODO Auto-generated method stub
		this.shift_key.removeAll(shift_key);
		this.shift_key.addAll(shift_key);
	}

	private void shift_store2(ArrayList<Integer> shift_key) {
		// TODO Auto-generated method stub
		this.shift_key_2.removeAll(shift_key);
		this.shift_key_2.addAll(shift_key);
	}

	private ArrayList<Integer> Remove_Bit(ArrayList<Integer> bit_key_10_store2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++) {
			int n = (int) (Math.random() * bit_key_10_store2.size());
			bit_key_10_store2.remove(n);
		}
		return bit_key_10_store2;
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

	private ArrayList<Integer> shift(ArrayList<Integer> key) {
		// TODO Auto-generated method stub
		int temp[] = new int[key.size()];
		for (int i = 0; i < key.size(); i++) {
			temp[i] = key.get(i);
		}
		for (int i = key.size() - 1; i >= 0; i--) {
			if (i != 0) {
				key.set(i - 1, temp[i]);
			} else if (i == 0) {
				key.set(key.size() - 1, temp[i]);
			}
		}
		return key;
	}

	public ArrayList<Integer> getP10() {
		return p10;
	}

	public ArrayList<Integer> getK1() {
		return k1;
	}

	public ArrayList<Integer> getK2() {
		return k2;
	}
	public ArrayList<Integer> getShift_key() {
		return shift_key;
	}
	public ArrayList<Integer> getShift_key_2() {
		return shift_key_2;
	}
}
