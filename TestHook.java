/**
钩子方法
*/
import java.util.Scanner;

public class TestHook{
	public static void main(String[] args){
		System.out.println("=========咖啡=========");
		Drink coffee = new Coffee();
		coffee.prepareDrink();
	}
}
abstract class Drink{
	final void prepareDrink(){
		boilWater();//烧水
		addMaterial();//添加主料
		brew();//冲泡
		pourInCup();//倒入杯子
		if(customerWantIngredients()){
			addIngredients();//添加辅料
		}
	}
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
	/**
	钩子方法：
	超类中通常是默认实现
	子类中可以选择覆写此方法
	*/
	boolean customerWantIngredients(){
		return true;
	}
}
class Coffee extends Drink{
	public void addMaterial(){
		System.out.println("2.加入咖啡粉");
	}
	public void addIngredients(){
		System.out.println("5.加糖加奶");
	}
	//子类覆写了钩子函数，实现自定义功能
	public boolean customerWantIngredients(){
		String answer = getUserInput();
		if("y".equals(answer)){
			return true;
		}else{
			return false;
		}
	}
	private String getUserInput(){
		String answer = null;
		System.out.println("您需要在咖啡中加糖或奶吗？(y/n)");
		Scanner sc = new Scanner(System.in);
		answer = sc.next();
		return answer;
	}
}