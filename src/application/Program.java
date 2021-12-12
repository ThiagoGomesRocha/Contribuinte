package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.Person;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Person> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char person = sc.next().toLowerCase().charAt(0);

			System.out.print("Name: ");
			String name = sc.next();

			System.out.print("Anual Income: ");
			Double anualIncome = sc.nextDouble();

			if (person == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				Integer number = sc.nextInt();
				list.add(new Company(name, anualIncome, number));
			}

		}
		System.out.println();
		System.out.println("TAXES PAID:");
		for (Person p : list) {
			System.out.println(p.getName() + ": $ " + String.format("%.2f", p.taxPayment()));
		}
		Double sum = 0.00;
		for (Person p : list) {
			sum += p.taxPayment();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

		sc.close();
	}

}
