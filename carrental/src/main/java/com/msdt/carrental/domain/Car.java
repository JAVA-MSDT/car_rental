package com.msdt.carrental.domain;

import java.util.Objects;

/**
 * 
 * @author Ahmed Samy https://github.com/JAVA-MSDT
 */
public class Car {

	private long carId;
	private String carModel;
	private String carReleaseYear;
	private String carColor;
	private String carCompany;
	private int quantity;

	public Car() {

	}

	public Car(final String carModel, final String carReleaseYear, final String carColor, final String carCompany,
			final int quantity) {

		this.carModel = carModel;
		this.carReleaseYear = carReleaseYear;
		this.carColor = carColor;
		this.carCompany = carCompany;
		this.quantity = quantity;
	}

	public Car(final long carId, final String carModel, final String carReleaseYear, final String carColor,
			final String carCompany, final int quantity) {

		this.carId = carId;
		this.carModel = carModel;
		this.carReleaseYear = carReleaseYear;
		this.carColor = carColor;
		this.carCompany = carCompany;
		this.quantity = quantity;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(final long carId) {
		this.carId = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(final String carModel) {
		this.carModel = carModel;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(final String carColor) {
		this.carColor = carColor;
	}

	public String getCarCompany() {
		return carCompany;
	}

	public void setCarCompany(final String carCompany) {
		this.carCompany = carCompany;
	}

	public String getCarReleaseYear() {
		return carReleaseYear;
	}

	public void setCarReleaseYear(String carReleaseYear) {
		this.carReleaseYear = carReleaseYear;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carModel=" + carModel + ", carReleaseYear=" + carReleaseYear + ", carColor="
				+ carColor + ", carCompany=" + carCompany + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carColor, carCompany, carId, carModel, carReleaseYear, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(carColor, other.carColor) && Objects.equals(carCompany, other.carCompany)
				&& carId == other.carId && Objects.equals(carModel, other.carModel)
				&& Objects.equals(carReleaseYear, other.carReleaseYear) && quantity == other.quantity;
	}

}
