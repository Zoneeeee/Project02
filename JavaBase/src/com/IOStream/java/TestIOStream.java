package com.IOStream.java;

/**
 * @author sunjiacheng
 * @create 2019-11-01-11:07
 */

import java.io.Serializable;

/**
 * 抽象基类：
 * InputStream
 * OutputStream
 * Reader
 * Writer
 *
 * 输入input：读取外部数据（磁盘、光盘等存储设备的数据）到程序（内存）中
 * 输出output：将程序中（内存中）的数据，输出到磁盘、光盘等存储设备中
 *
 * 流的分类：
 * 1、按照 操作数据单位 的不同：字节流（8bit） 字符流（16bit）
 *      （1）字符流：文本文件
 *      （2）字节流：视频、音频、图片文件
 *
 * 2、按照 数据流的流向 的不同：输入流   输出流
 *
 * 3、按照 流的角色 的不同：节点流   处理流
 *      （1）节点流：程序直接操作文件
 *      （2）处理流：节点流外部包裹一层流，即为处理流，用于处理节点流之中的内容，缓冲流即为处理流
 *
 * 节点流（文件流）（4个）：
 * （1）字节输入/输出流 ：可用于实现文本文件和非文本文件的读写（主要用于非文本文件）
 * FileInputStream
 * FileOutputStream
 * （2）字符输入/输出流 ：只可实现文本文件的读写，不能实现非文本文件的读写（主要用于文本文件）
 * FileReader
 * FileWriter
 *
 *
 *
 * 缓冲流（处理流的一种）：提高节点流对文件操作的速度,提高效率
 * （1）处理字节输入/输出：主要用于处理非文本文件
 * BufferedInputStream
 * BufferedOutputStream
 * （2）处理字符输入/输出：主要用于处理文本文件
 * BufferedReader
 * BufferedWriter
 *
 * 缓冲流能提速的原因：
 * （1）BufferedInputStream/BufferedOutputStream：内部实现是以数组的形式
 * （2）BufferedInputStream/BufferedOutputStream：read()方法和write()方法是非阻塞式的（所以快）
 *      FileInputStream/FileOutputStream：read()方法和write()方法是阻塞式的（所以慢）
 *
 *
 *
 * 转换流（处理流的一种）：提供了字节流和字符流之间的转换
 * （1）InputStreamReader：输入型的字节流 -> 输入型的字符流
 * （2）OutputStreamWriter：输出型的字节流 -> 输出型的字符流
 *
 * 转换流应用场景：键盘输入时，默认输入的是输入型字节流，所以为了效率，可以通过转换流转换为输入型字符流，进行操作
 *
 *
 *
 * 标准输入输出流：都返回 字节流
 * （1）标准输出流（控制台输出）：System.out   返回值：PrintStream类型：输出型字节流（打印流）
 * （2）标准输入流（键盘输入）：System.in      返回值：InputStream类型：输入型字节流
 *
 *
 *
 * 打印流：
 * （1）PrintStream：输出型字节流（System.out的返回值为此类型）
 * （2）PrintWriter：输出型字符流
 *
 *
 *
 * 数据流（处理流的一种）：操作Java语言的基本数据类型的数据
 * （1）DataInputStream
 * （2）DataOutputStream
 *
 * 注：
 * （1）以上两个流类型，分别套接在 InputStream、OutputStream 节点流上
 * （2）写：通过 DataOutputStream 中定义的函数直接进行数据写入（区分类型写入）
 * （3）读：通过 DataInputStream 中定义的函数直接进行数据读取（区分类型读取）
 * （4）打开文件直接显示的内容，会出现乱码
 *
 *
 *
 * 对象流（处理流的一种）：操作Java语言的引用数据类型数据（对象）
 * （1）ObjectInputStream
 * （2）ObjectOutputStream
 *
 * 对象的序列化机制：
 * （1）允许把内存中的Java对象转换成平台无关的二进制流
 * （2）从而允许将这种二进制流持久的保存在磁盘上
 * （3）或者允许通过网络，将这种二进制流传输到另一个网络节点
 * （4）当其他程序获取了这种二进制流，就可以恢复成原来的Java对象
 *
 * 注：
 * （1）任何实现了 Serializable接口 的对象，都可以转化为字节数据，使其在保存和传输时可被还原
 * （2）如果对象A中组合对象B，则如果对对象A进行序列化，对象B也需要实现 Serializable接口
 * （3）在实现了 Serializable接口 之后，要在类中声明一个序列化版本序列号：
 *          private static final long serialVersionUID = 15453413464L;
 *      用来确保当类本身发生变化之后，反序列化的过程中，还能在原类地址找到这个类，避免出现异常
 *
 * 注：
 *    ObjectOutputStream 和 ObjectInputStream 不能序列化 static 和 transient 修饰的成员变量
 *
 *
 *
 * RandomAccessFile类 ： 字节流方式
 * （1）支持随机访问的方式，程序可以直接跳到文件的任意地方来读、写文件
 * （2）支持只访问文件的部分内容
 * （3）支持向已存在的文件后追加内容
 *
 * 内部实现：RandomAccessFile对象包含一个记录指针，用以标识当前读写处的位置，该对象可以自由移动记录指针
 *
 * 函数：
 * （1）long getFilePointer() : 获取文件记录指针的当前位置
 * （2）void seek(long pos) : 将文件记录指针定位到pos位置
 *
 * 访问模式：
 * r ： 以只读方式打开
 * rw ： 打开以便读取和写入
 * rwd ： 打开以便读取和写入；同步文件内容的更新
 * rws ： 打开以便读取和写入；同步 文件内容 和 元数据 的更新
 */

public class TestIOStream
{

}

class Person implements Serializable
{
    //序列化版本序列号
    private static final long serialVersionUID = 15453413464L;
    String name;
    Integer age;
    Pet pet;

    public Person(String name, Integer age, Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}

class Pet implements Serializable
{
    private static final long serialVersionUID = 15453452455385L;
    String name;

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
