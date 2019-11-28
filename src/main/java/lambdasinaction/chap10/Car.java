package lambdasinaction.chap10;

import java.util.Optional;

public class Car {

	public Car(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}

	private Optional<Insurance> insurance;

	public Optional<Insurance> getInsurance() {
		return insurance;
	}
}
