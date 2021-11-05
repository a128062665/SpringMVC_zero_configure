package com.xsp;

import java.util.Date;
import java.util.Scanner;

public class HuoCheGouPiao {

	String chepiao;
	String cp1 = "T40";
	String cp2 = "T298";
	String cp3 = "Z158";
	String cp4 = "K1024";
	static Scanner sc1 = new Scanner(System.in);
	static int peopleNumber;
	static String name[];

	public void show() {
		System.out.println("-----------------------------------车站大屏-----------------------------------\r\n"
				+ "车次            出发站--到达站            出发时间            到达时间              历时 \r\n"
				+ "T40             惠州--北京              00:12            12:20             12:08\r\n"
				+ "T298            惠州--上海              00:06            10:50             10:44\r\n"
				+ "Z158            惠州--汕头              12:48            21:05             08:18\r\n"
				+ "K1024           惠州--重庆              12:39            02:16             13:37\r\n"
		);

	}

	public void buy() {
		System.out.println("请输入乘客人数：");
		peopleNumber = sc1.nextInt();
		name = new String[peopleNumber];

		Scanner sc2 = new Scanner(System.in);
		System.out.println("请输入乘车人姓名:");
		for(int i = 0;i<peopleNumber;i++) {
			name[i]= sc2.next();
		}
		System.out.println("乘车人姓名:");
		for(int i=0;i<peopleNumber;i++) {
			System.out.println(name[i]);
		}

//------------------------------------------------


		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		while(true) {
			String SFZ[] = new String[peopleNumber];
			for(int i = 0;i<SFZ.length;i++) {
				System.out.println("请输入身份证,第"+(i+1)+"个人的身份证是:");
				SFZ[i] = sc3.next();

			}
			for(int i = 0;i<SFZ.length;i++) {
				if(SFZ[i].length() == 18) {
					System.out.println("第"+(i+1)+"个人的身份证无误!");

				}
				else {
					while(true){
						System.out.println("第"+(i+1)+"个人输入的身份证有错误！请重新输入:");
						SFZ[i] = sc4.next();
						if(SFZ[i].length() == 18){
							System.out.println("第"+(i+1)+"个人的身份证无误!");
							break;
						}else{
							continue;
						}
					}

				}

			}
			break;


		}
		while(true) {
			System.out.println("请输入需要购买的火车票：");
			Scanner sc5 = new Scanner(System.in);
			while(true) {
				chepiao = sc5.next();

				if(chepiao.equals(cp1)) {
					System.out.println("您已选取T40次列车  惠州--北京  00:12开，请"+ name +"尽快支付,并可换取纸质车票。");
					break;
				}
				else if(chepiao.equals(cp2)) {
					System.out.println("您已选取T298次列车  惠州--上海  00:06开，请"+ name +"尽快支付,并可换取纸质车票。");
					break;
				}
				else if(chepiao.equals(cp3)) {
					System.out.println("您已选取Z158次列车  惠州--汕头  12:48开，请"+ name +"尽快支付,并可换取纸质车票。");
					break;
				}
				else if(chepiao.equals(cp4)) {
					System.out.println("您已选取K1024次列车  惠州--重庆  12:39开，请"+ name +"尽快支付,并可换取纸质车票。");
					break;
				}
				else {
					System.out.println("无该车次!请重新输入:");
					continue;
				}
			}
			break;
		}

	}
	static int a;//未成年人人数
	public void peopleAge() {

		int age[] = new int[peopleNumber];
		a = 0;//a未成年人数
		Scanner sc6 = new Scanner(System.in);
		System.out.println("请依次输入年龄:");
		for(int i=0;i<age.length;i++) {
			age[i] = sc6.nextInt();
		}
		for(int i=0;i<age.length;i++) {//12周岁以下
			if(age[i]<12) {
				a++;
				break;
			}
		}
		System.out.println("有"+a+"人不满12周岁,"+a+"人可免票!");
	}
	public void payMoney() {
		System.out.println("嗯W键进行支付，每摁一次支付100元.");
		int zhifuPeople = peopleNumber-a;
		int money = zhifuPeople*100;
		System.out.println("您总共需支付"+money+"元");
		int n =0;//作计算使用
		char p = ' ';//键入W字符所用
		Scanner s2 = new Scanner(System.in);

		while(n < money) {
			p = s2.next().charAt(0);
			if(p == 'w') {
				n += 100;
				System.out.println("您已支付"+n+"元");
			}
		}
		System.out.println("支付完成,出票！");

	}
	public void issueBill() {
		Date date = new Date();//创建时间对象
		String year = String.format("%tY", date);//格式化
		String month = String.format("%tm", date);
		String day = String.format("%td", date);
		String hour = String.format("%tH", date);
		String minute = String.format("%tM", date);
		String second = String.format("%tS", date);
		for(int i = 0;i<peopleNumber;i++) {//2总人数，此处2只是暂时，还要定义一个变量来存储人数
			System.out.println("+-------------------------------------+");
			System.out.println("             姓名:"+name[i]+"   车次:"+chepiao);
			System.out.println("出票时间是:"+year+"年"+month+"月"+day+"日"+" "+hour+"时"+minute+"分"+second+"秒");
			System.out.println("+---------------支 付 凭 证--------------+");
			System.out.println();

		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuoCheGouPiao t1 = new HuoCheGouPiao();
		t1.show();
		t1.buy();
		t1.peopleAge();
		t1.payMoney();
		t1.issueBill();
	}

}
