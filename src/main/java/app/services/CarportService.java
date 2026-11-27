package app.services;

import app.entities.Carport;

public class CarportService {

	// === Constructors ===


	public CarportService() {
	}

	// === Methods ===
	// There has to be a more elegant solution, but this works for now
	public int calcPostsInRow(Carport carport) {
		int postsInRow = 2;
		int remainingWidth = carport.getWidth();

		while (remainingWidth > carport.getMaxPostDistanceWidth()) {
			postsInRow += 1;
			remainingWidth -= carport.getMaxPostDistanceWidth();
		}

		return postsInRow;
	}

	public int calcPostQuantity(Carport carport) {
		return 0;
	}
}
