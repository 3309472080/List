package list;

public class LinkedListsDemo {
    public static void main(String[] args) {
        SingleLinkedlist s =new SingleLinkedlist();
        Hero h1 = new Hero(1,"宋江","及时雨");
        Hero h2 = new Hero(2,"李江","及时云");
        Hero h3 = new Hero(3,"王江","及时风");
        Hero h4 = new Hero(4,"宁江","及时雪");
        Hero h5 = new Hero(4,"刘江","及时雷");
        s.adder(h4);
        s.adder(h3);
        s.adder(h2);
        s.adder(h1);
        s.set(h5);
        s.del(5);

        s.list();
    }
}
class Hero{
    int no;//英雄的序号
    String name;//英雄的名字
    String nickName;//英雄的昵称
    Hero next;//英雄的后节点
    //构造器，new出一个英雄的所有属性
    public Hero(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;

    }
    //调用toString方法输出英雄信息
    @Override
    public String toString() {
        return "Hero{" +
                "no=" + no +
                ", name='" + name +
                ", nickName='" + nickName +
                '}';
    }
}
class SingleLinkedlist{
    private Hero head = new Hero(0," "," ");
    //显示遍历链表
    public void list(){
        //判断当前链表是否为空
        if(head.next == null){
            System.out.println("当前链表为空");
            return;
        }
        Hero temp = head.next;
        while(true){
            //判断节点是否在最后
            if(temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
    //添加英雄
    public void add(Hero hero){
        Hero temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next= hero;
    }
    //按照顺序添加英雄
    public void adder(Hero hero){
        Hero temp = head;
        boolean isflag = false;
        while (true){
            if(temp.next == null){
                isflag =true;
                break;
            }
            if(hero.no == temp.next.no){
                System.out.println("该英雄以添加，不允许再次添加");
               break;
            }
            if(hero.no< temp.next.no){
                hero.next = temp.next;
                temp.next=hero;
                break;
            }
            temp = temp.next;
        }
        if(isflag){
            temp.next= hero;
        }
    }
    //修改英雄
    public void set(Hero hero){
    Hero temp = head;
    boolean isflag = false;

    while (true){
        if (temp.next == null) {
            isflag = true;
            break;
        }
        if(hero.no == temp.next.no){
            temp.next = hero;
            break;
        }
        temp = temp.next;
    }
    if(isflag){
        System.out.println("没有找到，不能修改");
    }
    }
    public void del(int no){
       Hero temp = head;
        while (true) {
            if(temp.next == null){
                System.out.println("列表没有找到");
                break;
            }
            if (no == temp.next.no) {
                temp.next =temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }
}