/*
工厂方法模式
*/
/*
1. 一个抽象产品类
2. 多个具体产品类
3. 一个抽象工厂
4. 多个具体工厂 - 每一个具体产品对应一个具体工厂
*/
/*
工厂方法模式是针对每个产品提供一个工厂类，在客户端中判断使用哪个工厂类去创建对象。
*/

public class TestFactoryMethod{
	public static void main(String[] args){
		Client client = new Client();
		ComputerFactory factory = new MacFactory();
		client.buyComputer(factory.createComputer());
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
interface ComputerFactory{
	Computer createComputer();
}
class MacFactory implements ComputerFactory{
	public Computer createComputer(){
		return new Mac();
	}
}
class SurfaceFactory implements ComputerFactory{
	public Computer createComputer(){
		return new Surface();
	}
}