package app.menu;

public class MenuItem implements IMenuItem {
	
	private int shortcutNumber;
	private String textMessage;
	@SuppressWarnings("unused")
	private Menu subMenu;
	private IExecutableAction action;
	
	public MenuItem(int shortcutNumber, String textMessage, Menu subMenu, IExecutableAction action)
	{
		this.shortcutNumber = shortcutNumber;
		this.textMessage = textMessage;
		this.subMenu = subMenu;
		this.action = action;
	}
	
	public MenuItem(int shortcutNumber, String textMessage, IExecutableAction action)
	{
		this.shortcutNumber = shortcutNumber;
		this.textMessage = textMessage;
		this.action = action;
	}
	
	public void render()
	{
		System.out.println(shortcutNumber + " "  + textMessage);
	}
	
	public void execute()
	{
		if (action != null)
		{
			action.execute(new Object[] {this});
		}
	}
	
	public void setSubMenu(Menu subMenu)
	{
		this.subMenu = subMenu;
	}
}
