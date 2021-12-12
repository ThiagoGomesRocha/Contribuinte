package entities;

public class Individual extends Person {
	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double annualIncome, Double healthCareSpending) {
		super(name, annualIncome);
		this.healthExpenditures = healthCareSpending;
	}

	public Double getHealthCareSpending() {
		return healthExpenditures;
	}

	public void setHealthCareSpending(Double healthCareSpending) {
		this.healthExpenditures = healthCareSpending;
	}

	@Override
	public Double taxPayment() {
		if (super.getAnnualIncome() >= 20000.00) {
			if (healthExpenditures > 0) {
				return (super.getAnnualIncome() * 25 / 100) - (healthExpenditures * 50 / 100);
			} else {
				return super.getAnnualIncome() * 25 / 100;
			}
		} else {
			return super.getAnnualIncome() * 15 / 100;
		}
	}

}
