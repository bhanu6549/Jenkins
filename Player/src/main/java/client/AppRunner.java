package client;


import java.util.Scanner;

import exceptionPackage.PlayerDaoImplException;
import exceptionPackage.ServicePlayerImplException;
import service.Service;
import service.serviceImpl.ServiceImpl;

public class AppRunner {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		Service servicePlayer=new ServiceImpl();
		String playerName="";
		int runScored=0;
		int ballTaken=0;
		boolean flag1=true;
		boolean flag2=true;
		boolean flag3=true;
		do {
			System.out.println("Choose option\n1.Admin\n2.user\n3.exit");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				do {
					System.out.println("Welcome admin\n1.Insert player\n2.Delete the player\n3.Exit");
					int choiceAdmin=sc.nextInt();
					switch(choiceAdmin)
					{
					case 1:
						System.out.println("Enter the player name");
						sc.nextLine();
						playerName=sc.nextLine();
						System.out.println("Enter the run scored");
						runScored=sc.nextInt();
						System.out.println("Enter the ball taken");
						ballTaken=sc.nextInt();
						try {
							servicePlayer.addPlayer(playerName,runScored,ballTaken);
						} catch (ServicePlayerImplException e) {
							System.out.println(e.getMessage());
						}

						break;
					case 2:
						System.out.println("Enter the palyer name");
						sc.nextLine();
						playerName=sc.nextLine();
						try {
							servicePlayer.deletePlayer(playerName);
						} catch (ServicePlayerImplException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 3:
						flag2=false;
						break;
					}

				}while(flag2);
				break;
			case 2:
				do {
					System.out.println("Welcome user\n1.Update run\n2.Write strike rate in file\n3.Top three Strike Rate\n4.exit");
					int choiceUser=sc.nextInt();
					switch(choiceUser)
					{
					case 1:
						System.out.println("Enter the PlayerName");
						sc.nextLine();
						playerName=sc.nextLine();
						System.out.println("Enter the RunScored");
						runScored=sc.nextInt();
						System.out.println("Enter the ballTaken");
						ballTaken=sc.nextInt();
						try {
							servicePlayer.update(playerName,runScored,ballTaken);
						} catch (ServicePlayerImplException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						try {
							servicePlayer.writeFile();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 3:
						try {
							servicePlayer.topThreeStrike();
						} catch (ServicePlayerImplException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 4:
						flag3=false;
						break;

					}
				}while(flag3);
				break;
			case 3:
				flag1=false;
				break;
			}

		}while(flag1);

	}

}


