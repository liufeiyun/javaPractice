package com.lfy.ThreadsSynchronize;

public class Test {

	public static void main(String[] args) {

		//创建 3 个窗口
//        TicketSell1 t1 = new TicketSell1("A窗口");
//        TicketSell1 t2 = new TicketSell1("B窗口");
//        TicketSell1 t3 = new TicketSell1("C窗口");
//        t1.start();
//        t2.start();
//        t3.start();
        /**==================1、使用同步代码块解决=====================*/
//        TicketSellSolution1 t1 = new TicketSellSolution1("A窗口");
//        TicketSellSolution1 t2 = new TicketSellSolution1("B窗口");
//        TicketSellSolution1 t3 = new TicketSellSolution1("C窗口");
//        t1.start();
//        t2.start();
//        t3.start();
        /**==================2、使用同步方法（貌似同步方法不能解决同步问题）=====================*/
//        TicketSellSolution2 t1 = new TicketSellSolution2("A窗口");
//        TicketSellSolution2 t2 = new TicketSellSolution2("B窗口");
//        TicketSellSolution2 t3 = new TicketSellSolution2("C窗口");
//        t1.start();
//        t2.start();
//        t3.start();
		/**==================3、使用锁机制（貌似同步方法不能解决同步问题）=====================*/
//          TicketSellSolution3 t1 = new TicketSellSolution3("A窗口");
//          TicketSellSolution3 t2 = new TicketSellSolution3("B窗口");
//          TicketSellSolution3 t3 = new TicketSellSolution3("C窗口");
//          t1.start();
//          t2.start();
//          t3.start();
	    /**==================3、使用锁机制（貌似同步方法不能解决同步问题）=====================*/
//		Thread t1 = new Thread(new TicketSellSolution4());
//        Thread t2 = new Thread(new TicketSellSolution4());
//        Thread t3 = new Thread(new TicketSellSolution4());
//        t1.start();
//        t2.start();
//        t3.start();
	}

}
