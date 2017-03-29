 package test;
import java.io.*;
 
public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup threadGroup1 = 
        // ����������д��
            new ThreadGroup("group1") {
                // �̳�ThreadGroup�����¶������·���
                // ���̳߳�Ա����unchecked exception
                // ��ִ�д˷���
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println(t.getName() + ": " 
                             + e.getMessage());
                }
            };
        
        // ����������д��
        Thread thread1 = 
            // ����߳���threadGroup1��һԱ
            new Thread(threadGroup1,
              new Runnable() {
                public void run() {
                    // ����unchecked�쳣
                    throw new RuntimeException("�����쳣");
                }
            }); 
     
        thread1.start();
    }
}
