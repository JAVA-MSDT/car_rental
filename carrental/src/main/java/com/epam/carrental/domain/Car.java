package com.epam.carrental.domain;

public class Car {

	private long carId;
	private String carModel;
	private String cardReleaseYear;
	private String carColor;
	private String carCompany;

	public Car() {
		super();
	}

	public Car(final String carModel, final String cardReleaseYear, final String carColor, final String carCompany) {
		super();
		this.carModel = carModel;
		this.cardReleaseYear = cardReleaseYear;
		this.carColor = carColor;
		this.carCompany = carCompany;
	}

	public Car(final long carId, final String carModel, final String cardReleaseYear, final String carColor, final String carCompany) {
		super();
		this.carId = carId;
		this.carModel = carModel;
		this.cardReleaseYear = cardReleaseYear;
		this.carColor = carColor;
		this.carCompany = carCompany;
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

	public String getCardReleaseYear() {
		return cardReleaseYear;
	}

	public void setCardReleaseYear(final String cardReleaseYear) {
		this.cardReleaseYear = cardReleaseYear;
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

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carModel=" + carModel + ", cardReleaseYear=" + cardReleaseYear + ", carColor="
				+ carColor + ", carCompany=" + carCompany + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((carColor == null) ? 0 : carColor.hashCode());
		result = (prime * result) + ((carCompany == null) ? 0 : carCompany.hashCode());
		result = (prime * result) + (int) (carId ^ (carId >>> 32));
		result = (prime * result) + ((carModel == null) ? 0 : carModel.hashCode());
		result = (prime * result) + ((cardReleaseYear == null) ? 0 : cardReleaseYear.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Car other = (Car) obj;
		if (carColor == null) {
			if (other.carColor != null) {
				return false;
			}
		} else if (!carColor.equals(other.carColor)) {
			return false;
		}
		if (carCompany == null) {
			if (other.carCompany != null) {
				return false;
			}
		} else if (!carCompany.equals(other.carCompany)) {
			return false;
		}
		if (carId != other.carId) {
			return false;
		}
		if (carModel == null) {
			if (other.carModel != null) {
				return false;
			}
		} else if (!carModel.equals(other.carModel)) {
			return false;
		}
		if (cardReleaseYear == null) {
			if (other.cardReleaseYear != null) {
				return false;
			}
		} else if (!cardReleaseYear.equals(other.cardReleaseYear)) {
			return false;
		}
		return true;
	}

}
