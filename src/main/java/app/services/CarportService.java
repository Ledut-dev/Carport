package app.services;

import app.entities.Carport;

public class CarportService {

	// === Constructors ===


	public CarportService() {
	}

	// === Methods ===
	// There has to be a more elegant solution, but this works for now
	private int calcPostsInLine(int distance, int maxPostDistance) {
		int postsInLine = 2;
		int remainingDistance = distance;

		while (remainingDistance > maxPostDistance) {
			postsInLine += 1;
			remainingDistance -= maxPostDistance;
		}

		return postsInLine;
	}

	public int calcPostsWidth(Carport carport) {
		return calcPostsInLine(carport.getWidth(), carport.getMaxPostDistanceWidth());
	}

	public int calcPostsDepth(Carport carport) {
		return calcPostsInLine(carport.getDepth(), carport.getMaxPostDistanceDepth());
	}

	public int calcPostQuantity(Carport carport) {
		return calcPostsWidth(carport) * calcPostsDepth(carport);
	}

	public int calcPostLength(Carport carport) {
		// rafter's width is currently always 200mm.
		// If this changes, find rafter material's height and width and use the longer measurement
		int rafterWidth = 20;
		return carport.getHeight() + 90 - rafterWidth;
	}
}
