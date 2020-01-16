package com.Collection.java;

/**
 * @author sunjiacheng
 * @create 2019-10-22-9:55
 */

/**
 * Map与Collection并列存在，用于保存具有映射关系的数据：key-value
 * 1、Map中的key和value都可以是任何引用类型的数据
 * 2、Map中的key用Set来存放，无序、不允许重复，即同一个Map中的元素对应的类需要重写 hashCode()和equals()方法
 * 3、常用String类作为Map的Key
 * 4、Map中的value用Collection来存放，可以重复
 * 5、一个key-value，是一个Entry，所有的Entry使用Set存放的，也是不可重复的
 * 6、向HashMap中添加元素时，会调用key所在类的equals()方法，判断两个Key是否相同，若相同，则只能添加后来添加的那个key（与Set不同）
 *
 * 注：
 *  （1）多个key 可指向同一个 value
 *  （2）一个key 不能指向多个 value
 *  （3）key：无序的，不可重复的，使用Set存储key
 *  （4）value：无序的，可重复的，使用Collection存储value
 *  （5）Entry：无序的，不可重复的，使用Set存储Entry
 *
 * 注：
 *  （1）HashMap判断两个key相等的标准：两个key通过equals()方法，返回true，且hashCode的值也相等
 *  （2）HashMap判断两个value相等的标准：两个value通过equals()方法，返回true
 *
 * 注：HashMap 底层实现
 *  （1）JDK7.0以及之前：数组 + 链表
 *  （2）JDK8.0：数组 + 链表 + 红黑树
 *
 * HashMap的底层实现原理（JDK 7.0）
 * （1）HashMap map = new HashMap();
 *      实例化之后，底层创建了一个长度为 16 的一维数组 Entry[] table
 * （2）map.put(key1, value1);
 *      首先调用 key1 所在类的 hashCode() 方法,计算 key1 的 hash值，这个 Hash值 在经过某种算法计算之后，得到在 Entry 数组中的存放位置
 *          如果此位置上的数据为空，此时的 key1-value1 添加成功
 *          如果此位置上的数据不为空，比较 key1 和已经存在在此位置上的 一个或多个数据（链表形式）的 Hash值
 *              如果 key1 的 hash值 与该位置上的其他所有数据的 hash值 都不同，则添加成功
 *              如果 key1 的 hash值 与该位置上的某一个数据（key2-value2）的 hash值相同，继续比较：调用 key1 所在类的 equals(key2) 方法
 *                  如果 equals() 返回 false，则 key1-value1 添加成功
 *                  如果 equals() 返回 true，则 使用 value1 代替 value2
 *
 * 补充：在不断的添加过程中，会涉及到扩容的问题，默认的扩容方式：扩容为原来容量的2倍，并将原有数据复制过来
 *
 *
 * HashMap的底层实现原理（JDK 8.0）
 * （1）HashMap map = new HashMap();
 *      实例化之后，底层没有创建一个长度为16的数组
 * （2）map.put(key1, value1);
 *      首次调用 put() 方法时，底层创建一个长度为 16 的数组，类型为 Node[]
 * （3）当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8  且 当前数组的长度 > 64 时，此索引位置上的所有数据改为使用红黑树存储（查找效率更高）
 *
 * DEFAULT_INITIAL_CAPACITY：HashMap的默认容量：16
 * DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 * threshold：扩容的临界值：容量 * 加载因子 = 16 * 0.75 = 12
 * TREEIFY_THRESHOLD：链表长度大于该默认值（8）转化为红黑树
 * MIN_TREEIFY_CAPACITY：链表被树化时的最小数组容量：64
 *
 * 思考：为什么要定义一个加载因子，计算出临界量，让数组提前扩容？
 * HashMap结构在设计时，主张链表结构在保证数组利用率的情况下，要尽量少，所以经过统计学计算得出最优的解决方案：加载因子 0.75
 *
 */

/*
 * LinkedHashMap：使用链表维护添加进Map中的顺序，故遍历Map时，是按添加的顺序遍历的
 * 1、参考LinkedHashSet，LinkedHashMap在添加元素时，效率会低于HashMap，因为它要维护一个链表
 *
 * 2、LinkedHashMap 的底层实现
 * HashMap 中使用了 Node 数组
 * LinkedHashMap 中使用了 Entry 数组，继承了 HashMap 中的 Node 内部类 ，在 Entry 的基础上，加了两个属性 before 和 after 用于记录前后两个添加的数据
 *
 * 3、由于数组中元素都指向了前后两个元素，所以遍历时会按照添加的顺序遍历
 *
 */

/*
 * TreeMap：按照添加进Map中的元素的key的指定属性进行排序（只看key，相当于TreeSet）
 * 1、要求key，必须是同一个类的对象
 * 2、TreeMap:底层实现：红黑树
 */

/*
 * Hashtable：不建议使用
 * 1、不允许key-value为：null-null
 * 2、线程安全，但古老
 * 3、Hashtable判断两个key相等，两个value相等的标准和HashMap一致
 *
 * Properties：Hashtable的子类，常用于处理属性文件（配置文件），键和值都为String类型的
 */

/*
 *
 * 常用方法：
 * Object put(Object key, Object value)
 * Object remove(Object key)
 * void putAll(Map t)
 * void clear()
 * Object get(Object key)
 * boolean containsKey(Object key)
 * boolean containsValue(Object value)
 * int size()
 * boolean isEmpty()
 * boolean equals(Object obj)
 *
 */

public class TestMap
{
    public static void main(String[] args)
    {

    }
}
