package com.myproject.ssm.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MathUtils {

	public static void main(String[] args) {
		List<Double> list = new ArrayList<Double>();
		list.add(1.23423);
		//
		list.add(3.23423);
		list.add(3.1231);
		//
		list.add(2.34432);
		list.add(5.6786);
		double sum = 9.26;
		boolean flag = addImprove(list, sum);
		if (flag) {
			// dosomething
		}
		double val = add(list.get(1), list.get(3));
		System.out.println(val);
	}

	public static void mathDemo(double num1) {
		long num = Math.round(num1);

		// BigDecimal decimal=new BigDecimal(num1);
		// decimal.add(12.1212);

	}

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal b2 = new BigDecimal(v2).setScale(2, BigDecimal.ROUND_HALF_UP);
		return b1.add(b2).doubleValue();
	}

	public static double add(List<Double> list) {
		BigDecimal bigDecimal = new BigDecimal(list.get(0).toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
		for (int i = 0; i < list.size(); i++) {
			if (i == 3) {
				bigDecimal = bigDecimal.add(new BigDecimal(list.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP));
			} else if (i == 4) {
				bigDecimal = bigDecimal.add(new BigDecimal(list.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP));
			}
		}
		System.out.println(bigDecimal.doubleValue());
		return 0;
	}

	public static boolean addImprove(List<Double> list, double sum) {
		boolean flag = false;
		Double v1 = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (i == 3) {
				v1 = add(v1, list.get(i));
			} else if (i == 4) {
				v1 = add(v1, list.get(i));
			}
		}
		if (v1 == sum) {
			flag = true;
			System.out.println(flag);
		} else {
			System.out.println(flag);
		}
		return flag;
	}

}
