package it.epicode.numero2.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.numero2.beans.Bevanda;
import it.epicode.numero2.beans.Franchising;
import it.epicode.numero2.beans.Pizza;
import it.epicode.numero2.beans.Topping;
import it.epicode.numero2.beans.decorators.AnanasDecorator;
import it.epicode.numero2.beans.decorators.MozzarellaDecorator;
import it.epicode.numero2.beans.decorators.PomodoroDecorator;
import it.epicode.numero2.beans.decorators.ProsciuttoDecorator;
import it.epicode.numero2.beans.decorators.SalameDecorator;

@SpringBootApplication
public class BeWeek5Esercizio1Application2 {

	public static void main(String[] args) {
		SpringApplication.run(BeWeek5Esercizio1Application2.class, args);
		pizzeria();
	}

public static void pizzeria() {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("it.gaetanoquarto.esercizio2");
		ctx.refresh();
		
		Topping t1 = new AnanasDecorator();
		Topping t2 = new MozzarellaDecorator();
		Topping t3 = new PomodoroDecorator();
		Topping t4 = new ProsciuttoDecorator();
		Topping t5 = new SalameDecorator();
		
		Pizza p1 = (Pizza) new Pizza();
		Pizza pMargherita = new PomodoroDecorator(new MozzarellaDecorator(p1));
		Pizza pProsciutto = new PomodoroDecorator(new MozzarellaDecorator(new ProsciuttoDecorator(p1)));
		Pizza pAnanas = new PomodoroDecorator(new MozzarellaDecorator(new ProsciuttoDecorator(new AnanasDecorator(p1))));
		Pizza pSalameProsciutto = new PomodoroDecorator(new MozzarellaDecorator(new ProsciuttoDecorator(new SalameDecorator(p1))));
		Pizza pSalame = new PomodoroDecorator(new MozzarellaDecorator(new SalameDecorator(p1)));
		
		Bevanda b1 = new Bevanda(1.29, "Limonata(0,33cl)", 128);
		Bevanda b2 = new Bevanda(1.29, "Acqua(0.5l)", 0);
		Bevanda b3 = new Bevanda(7.49, "Vino(0,75l, 13%)", 607);
		
		Franchising f1 = new Franchising("Maglia", 21.99);
		Franchising f2 = new Franchising("Tazza", 4.99);
		
		
		System.out.printf("%nBenvenuti in Godfather's Pizza!%n");
		
		System.out.printf("%n%nPIZZE:%n");
		System.out.println("Pizza Margherita " + "(" + pMargherita.getNome() + ")" + " | PREZZO: €" + (Math.round(pMargherita.getPrezzo() * 100.00)) / 100.00 + " | CALORIE: " + pMargherita.getCalorie());
		System.out.println("Pizza Prosciutto " + "(" + pProsciutto.getNome() + ")" + " | PREZZO: €" + (Math.round(pProsciutto.getPrezzo() * 100.00)) / 100.00 + " | CALORIE: " + pProsciutto.getCalorie());
		System.out.println("Pizza Hawaii " + "(" + pAnanas.getNome() + ")" + " | PREZZO: €" + (Math.round(pAnanas.getPrezzo() * 100.00)) / 100.00 + " | CALORIE: " + pAnanas.getCalorie());
		System.out.println("Pizza Salame " + "(" + pSalame.getNome() + ")" + " | PREZZO: €" + (Math.round(pSalame.getPrezzo() * 100.00)) / 100.00 + " | CALORIE: " + pSalame.getCalorie());
		System.out.println("Pizza Salame e prosciutto " +"(" + pSalameProsciutto.getNome() + ")" + " | PREZZO: €" + (Math.round(pSalameProsciutto.getPrezzo() * 100.00)) / 100.00 + " | CALORIE: " + pSalameProsciutto.getCalorie());
		
		System.out.printf("%n%nTOPPING:%n");
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t4);
		System.out.println(t5);
		
		System.out.printf("%n%nBEVANDE:%n");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		System.out.printf("%n%nFRANCHISING:%n");
		System.out.println(f1);
		System.out.println(f2);
		
		ctx.close();
	}
	
}
