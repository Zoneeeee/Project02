package com.exception.java;

/**
 * @author sunjiacheng
 * @create 2019-10-18-13:50
 */
public class TestEcmDef
{
    public static void main(String[] args)
    {
        try {
            int i = Integer.parseInt(args[0]); //被除数
            int j = Integer.parseInt(args[1]); //除数
            ecm(i, j);
        } catch (NumberFormatException e) {
            System.out.println("输入的数据类型型不一致");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (ArithmeticException e) {
            System.out.println("分母为零");
        } catch (EcDef ecDef) {
            System.out.println(ecDef.getMessage());
        }

    }
    public static void ecm(int i, int j) throws EcDef {
        if(i < 0 || j < 0)
        {
            throw new EcDef("您输入的数值存在负数");
        }
        System.out.println(i/j);
    }
}

class EcDef extends Exception
{
    static final long serialVersionUID = -33875124229948L;

    public EcDef() {
    }

    public EcDef(String message) {
        super(message);
    }
}

