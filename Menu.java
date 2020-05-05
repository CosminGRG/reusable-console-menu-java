/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.menu;

/**
 *
 * @author ykscr
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu{
	
    private String menuName;
    private ArrayList<IMenuItem> menuItems;
    private boolean closeMenu = false;

    public Menu(String menuName)
    {
        this.menuName = menuName;
        menuItems = new ArrayList<IMenuItem>();

        IExecutableAction close = (parameters) -> { 
                closeMenu = true;
                ConsoleController.Clear();
        };
        this.menuItems.add(new MenuItem(0, "Exit", close));
    }

    public void AddSubMenu(int shortcutNumber, String textMessage, Menu subMenu)
    {
        IExecutableAction action = (parameters) -> { 
            ConsoleController.Clear();
            subMenu.InitMenu(); 
        };
        menuItems.add(new MenuItem(shortcutNumber, textMessage, subMenu, action));
    }

    public void AddMenuItem(int shortcutNumber, String textMessage, IExecutableAction action)
    {
        menuItems.add(new MenuItem(shortcutNumber, textMessage, action));
    }
    
    public void AddMenuItem(MenuItem menuItem)
    {
        menuItems.add(menuItem);
    }

    public void InitMenu()
    {
        do
        {
            RenderMenu();

            int option = 0;
            boolean validOption = false;

            while (!validOption)
            {
                try 
                {
                        option = ReadOption();
                        if (menuItems.get(option) != null)
                        {
                                validOption = true;
                        }
                }
                catch (IndexOutOfBoundsException error)
                {
                        System.out.println("Index out of bounds.");
                }
                catch (InputMismatchException error)
                {
                        System.out.println("Input Mismatch.");
                }
            }

            IMenuItem currentMenuItem = menuItems.get(option);
            currentMenuItem.execute();
        }while (!closeMenu);
    }
	
    public void RenderMenu()
    {
        //ConsoleController.Clear();
        System.out.println(menuName);
        for (IMenuItem key : menuItems)
        {
                key.render();
        }
    }
	
    private int ReadOption()
    {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);

        int option = input.nextInt();

        //input.close();

        return option;
    }
}