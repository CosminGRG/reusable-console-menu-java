import app.menu.*;

public class MainClass {

	public static void main(String[] args) {
		
		Menu mainMenu = new Menu("Main Menu");
		Menu subMenu = new Menu("Sub Menu");
		Menu subSubMenu = new Menu("Sub Sub Menu");
		
		subMenu.AddMenuItem(1, "TEST SUBMENU", (parameters) -> { PrintTest(); });
		subMenu.AddSubMenu(2, "Sub Sub Menu", subSubMenu);
		
		mainMenu.AddMenuItem(1, "TEST", (parameters) -> { PrintTest(); });
		mainMenu.AddSubMenu(2, "SUBMENU TEST", subMenu);
		
		
		mainMenu.InitMenu();
		
	}
	
	public static void PrintTest()
	{
		System.out.println("TEST!");
	}
	
}
