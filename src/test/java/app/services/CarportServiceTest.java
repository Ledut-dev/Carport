package app.services;

import app.entities.Carport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarportServiceTest {
	private final CarportService carportService = new CarportService();
	private Carport carport;

	@BeforeEach
	public void setUp() {
		carport = new Carport();
	}

	@Test
	public void calcPostsWidth300() {
		carport.setWidth(300);

		int expectedPosts = 2;
		assertEquals(expectedPosts, carportService.calcPostsWidth(carport));
	}

	@Test
	public void calcPostsWidth500() {
		carport.setWidth(500);

		int expectedPosts = 2;
		assertEquals(expectedPosts, carportService.calcPostsWidth(carport));
	}

	@Test
	public void calcPostsWidth600() {
		carport.setWidth(600);

		int expectedPosts = 3;
		assertEquals(expectedPosts, carportService.calcPostsWidth(carport));
	}

	@Test
	public void calcPostsWidth2100() {
		carport.setWidth(2100);

		int expectedPosts = 6;
		assertEquals(expectedPosts, carportService.calcPostsWidth(carport));
	}

	@Test
	public void calcPostsDepth400() {
		carport.setDepth(400);

		int expectedPosts = 2;
		assertEquals(expectedPosts, carportService.calcPostsDepth(carport));
	}

	@Test
	public void calcPostsDepth600() {
		carport.setDepth(600);

		int expectedPosts = 3;
		assertEquals(expectedPosts, carportService.calcPostsDepth(carport));
	}

	@Test
	public void calcPostsDepth1500() {
		carport.setDepth(1500);

		int expectedPosts = 5;
		assertEquals(expectedPosts, carportService.calcPostsDepth(carport));
	}


	@Test
	public void calcPostQuantityWidth300Depth400() {
		carport.setWidth(300);
		carport.setDepth(400);

		int expectedPosts = 4;
		assertEquals(expectedPosts, carportService.calcPostQuantity(carport));
	}

	@Test
	public void calcPostQuantityWidth300Depth600() {
		carport.setWidth(300);
		carport.setDepth(600);

		int expectedPosts = 6;
		assertEquals(expectedPosts, carportService.calcPostQuantity(carport));
	}

	@Test
	public void calcPostQuantityWidth300Depth1500() {
		carport.setWidth(300);
		carport.setDepth(1500);

		int expectedPosts = 10;
		assertEquals(expectedPosts, carportService.calcPostQuantity(carport));
	}


	@AfterEach
	public void tearDown() {
	}
}