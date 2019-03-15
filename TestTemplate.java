/**
模板设计模式
*/
public class TestTemplate{
	public static void main(String[] args){
		System.out.println("=========咖啡=========");
		Drink coffee = new Coffee();
		coffee.prepareDrink();
		System.out.println("=========柠檬茶=========");
		Drink tea = new Tea();
		tea.prepareDrink();
	}
}
abstract class Drink{
	//不希望子类覆盖这个方法，因此用final修饰
	final void prepareDrink(){
		boilWater();//烧水
		addMaterial();//添加主料
		brew();//冲泡
		pourInCup();//倒入杯子
		addIngredients();//添加辅料
	}
	//咖啡和茶处理这些方法不同，因此这两个方法必须被声明为抽象，留给子类实现
	abstract void addMaterial();
	abstract void addIngredients();
	void boilWater(){
		System.out.println("1.烧开水");
	}
	void brew(){
		System.out.println("3.冲泡饮品");
	}
	void pourInCup(){
		System.out.println("4.倒入杯子");
	}
}
class Coffee extends Drink{
	public void addMaterial(){
		System.out.println("2.加入咖啡粉");
	}
	public void addIngredients(){
		System.out.println("5.加糖加奶");
	}
}
class Tea extends Drink{
	public void addMaterial(){
		System.out.println("2.加入茶叶");
	}
	public void addIngredients(){
		System.out.println("5.加柠檬");
	}
}