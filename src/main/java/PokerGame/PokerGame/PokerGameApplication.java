package PokerGame.PokerGame;

import LogicGame.CardGame;
import RestController.RestMainController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackageClasses = RestMainController.class)
public class PokerGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokerGameApplication.class, args);
	}


//	@Bean
//	CommandLineRunner init() {
//		return args -> {
//			CardGame cardGame = new CardGame();
//
//			System.out.println("Card Game \n Player Options");
//			System.out.println("1. Start Game \n  \n2. Exit Game");
//			System.out.print("Please provide your option : ");
//
//			int i = 1;
//
//			while (i != 0) {
//				Scanner in = new Scanner(System.in);
//				i = in.nextInt();
//
//				switch (i) {
//					case 1:
//						System.out.println("Provide the Number of Players( should be greater than 1 and less than 4) : ");
//						in = new Scanner(System.in);
//						i = in.nextInt();
//						cardGame.InitializeSessionGame(i);
//						cardGame.displayWinners();
//						break;
//
//					case 2:
//						System.exit(0);
//				}
//
//				System.out.println();
//				System.out.println("Card Game \n Select User Options");
//				System.out.println("1. Start Game \n2. Exit Game");
//				System.out.print("Please provide your option : ");
//			}
//		};
//	}
}
