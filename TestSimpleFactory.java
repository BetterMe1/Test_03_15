/*
简单工厂模式
*/
/*
概要
1. 一个抽象产品类
2. 具体产品类
3. 一个工厂
*/
/*
创建生产电脑的工厂，客户需要购买什么样的电脑，只要输入类型编号就可以获取该电脑。将类
的实例化交给工厂易于解耦
*/
import java.util.Scanner;
public class TestSimpleFactory{
	public static void main(String[] args){
		Client client = new Client();
		System.out.println("请输入您想要的电脑型号:mac,surface,alien");
		Scanner sc = new Scanner(System.in);
		String type = sc.next();
		Computer computer =  ComputerFactory.getInstance(type);
		client.buyComputer(computer);
	}
}

class Client{
	public void buyComputer(Computer computer){
		computer.printComputer();
	}
}
interface Computer{
	void printComputer();
}

class Mac implements Computer{
	public void printComputer(){
		System.out.println("漂亮，贵，好用");
	}
}
class Surface implements Computer{
	public void printComputer(){
		System.out.println("实用，精品");
	}
}
class Alien implements Computer{
	public void printComputer(){
		System.out.println("流畅，好用");
	}
}
class ComputerFactory{
	public static Computer getInstance(String type) {
		Computer computer = null;
		if("mac".equals(type)){
			computer = new Mac();
		}else if("surface".equals(type)){
			computer = new Surface();
		}else if("alien".equals(type)){
			computer = new Alien();
		}else{
			System.out.println("不能生产指定类型的电脑");
		}
		return computer;	
	}
}