package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PLU
{	
	public static void main(String[] args) throws IOException
	{
		String os;
		if(System.getProperty("os.name").contains("Windows")) os = "kody_w";
		else os = "kody_l";
		System.out.println();
		System.out.println("Nauka kodów PLU \tv1.3");
		System.out.println();
		
		Scanner data = null;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Wybierz kategoriê produktów:");
		System.out.println("1.Bu³ki");
		System.out.println("2.Chleby");
		System.out.println("3.Owoce");
		System.out.println("4.Warzywa");
		System.out.println("5.Wszystko");
		
		int choice = 5;
		try
		{
			choice = in.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Wprowadzono niepoprawne dane, program koñczy pracê.");
			System.exit(0);
		}
		System.out.println();
		switch(choice)
		{
		case 1:
			try
			{
				data = new Scanner(new File("." + File.separatorChar + os + File.separatorChar + "bulki.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Nie odnaleziono pliku, program koñczy pracê.");
				System.exit(0);
			}
			break;
		case 2:
			try
			{
				data = new Scanner(new File("." + File.separatorChar + os + File.separatorChar + "chleby.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Nie odnaleziono pliku, program koñczy pracê.");
				System.exit(0);
			}
			break;
		case 3:
			try
			{
				data = new Scanner(new File("." + File.separatorChar + os + File.separatorChar + "owoce.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Nie odnaleziono pliku, program koñczy pracê.");
				System.exit(0);
			}
			break;
		case 4:
			try
			{
				data = new Scanner(new File("." + File.separatorChar + os + File.separatorChar + "warzywa.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Nie odnaleziono pliku, program koñczy pracê.");
				System.exit(0);
			}
			break;
		case 5:
			try
			{
				data = new Scanner(new File("." + File.separatorChar + os + File.separatorChar + "dane.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Nie odnaleziono pliku, program koñczy pracê.");
				System.exit(0);
			}
			break;
			default:
				System.out.println("Wprowadzono niepoprawne dane, program koñczy pracê.");
				System.exit(0);
		}

		int a = data.nextInt();
		data.nextLine();
		a/=2;
		
		String[] products = new String[a];
		String[] plu = new String[a];
		
		int i = 0;
		while(data.hasNextLine())
		{
			products[i] = data.nextLine();
			plu[i] = data.nextLine();
			i++;
		}
		
		int rand;
		String inp;
		int corr = 0;
		for(int n = a ; n > 0 ; n--)
		{
			rand = (int) (Math.random() * n);
			System.out.println("Podaj kod PLU dla: " + products[rand]);
			inp = in.next();
			if(inp.equals(plu[rand]))
			{
				System.out.println("Kod poprawny!");
				corr++;
			}
			else
			{
				System.out.println("B³¹d! Poprawny kod to: " + plu[rand]);
			}
			System.out.println();
			
			products[rand] = products[n-1];
			plu[rand] = plu[n-1];
		}
		System.out.printf("Zdoby³eœ %d / %d pkt", corr, a);
		System.out.println();
		System.in.read();
	}	
}
