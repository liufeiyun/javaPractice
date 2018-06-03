package com.lfy.Junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Junit �ļ��������� @Test ��ע�⣺

����1.@Test: ���Է���

��������a)(expected=XXException.class)���������쳣��XXException.classһ���������ͨ��
��������b)(timeout=100)��������ִ������100����֮����ɣ������ͨ��

����2.@Ignore: �����ԵĲ��Է���������֮����ʱ�����д˶δ���

����3.@Before: ÿһ�����Է���֮ǰ����

����4.@After: ÿһ�����Է���֮������

����5.@BeforeClass: �����������Ҫ�Ǿ�̬������static �����������в��Կ�ʼ֮ǰ���У�ע������before�������в��Է���

����6.@AfterClass: ��������Ҫ�Ǿ�̬������static �����������в��Խ���֮�����У�ע������ @After
*/
/**
 * ע�⣺��д�������ԭ�򣺡�

����    �ٲ��Է����ϱ���ʹ��@Test��������

    �ڲ��Է�������ʹ��public void �������Σ����ܴ��κεĲ���

    ���½�һ��Դ����Ŀ¼��������ǵĲ��Դ��룬�������Դ������Ŀҵ�����ֿ�

    �ܲ��������ڵİ���Ӧ�úͱ����������ڵİ�������һ��

    �ݲ��Ե�Ԫ�е�ÿ������������Զ������ԣ����Է����䲻�����κε�����

    �޲�����ʹ��Test��Ϊ�����ĺ�׺�����Ǳ��룩

    �߲��Է���ʹ��test��Ϊ��������ǰ׺�����Ǳ��룩
*/
public class JunitTestAnnotation {

	@BeforeClass
    public static void beforeClass(){
        System.out.println("@BeforeClass");
    }
	
	public JunitTestAnnotation() {
        System.out.println("���캯��");
    }
     
    @Before
    public void befor(){
        System.out.println("@Before");
    }
     
    @Test
    public void test(){
        System.out.println("@Test");
    }
     
    @Ignore
    public void ignore(){
        System.out.println("@Ignore");
    }
     
    @After
    public void after(){
        System.out.println("@After");
    }
     
    @AfterClass
    public static void afterClass(){
        System.out.println("@AfterClass");
    }
}
