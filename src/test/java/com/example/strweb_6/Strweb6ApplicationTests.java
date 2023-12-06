package com.example.strweb_6;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Strweb6ApplicationTests {

	@Test
	void testIsExpensiveWithLowPrice() {
		Product product = new Product();
		product.setPrice(30.0);
		assertFalse(product.isExpensive(), "Product with price 30.0 should not be expensive");
	}

	@Test
	void testIsExpensiveWithHighPrice() {
		Product product = new Product();
		product.setPrice(60.0);
		assertTrue(product.isExpensive(), "Product with price 60.0 should be expensive");
	}

	@Test
	void testGetDescriptionSummaryWithShortDescription() {
		Product product = new Product();
		product.setDescription("Short description");
		assertEquals("Short description", product.getDescriptionSummary(), "Summary should match short description");
	}

	@Test
	void testGetDescriptionSummaryWithLongDescription() {
		Product product = new Product();
		product.setDescription("This is a long description for testing getDescriptionSummary method.");
		assertTrue(product.getDescriptionSummary().length() <= 50, "Summary should be less than or equal to 50 characters");
		assertTrue(product.getDescriptionSummary().endsWith("..."), "Summary should end with '...'");
	}

	@Test
	void testIsExpensiveWithNegativePrice() {
		Product product = new Product();
		product.setPrice(-10.0);
		assertFalse(product.isExpensive(), "Product with negative price should not be expensive");
	}

	@Test
	void testGetDescriptionSummaryWithNullDescription() {
		Product product = new Product();
		product.setDescription(null);
		assertEquals("", product.getDescriptionSummary(), "Summary should be an empty string for null description");
	}

	@Autowired
	private MenuService menuService;

	@Test
	void testLoadMenuFromXml() {
		// Предположим, что у вас есть файл XML, который вы можете использовать для тестирования
		// Укажите путь к вашему тестовому XML-файлу
		String testXmlFilePath = "info.xml";

		// Установим значение аннотации Value нашего бина
		menuService.loadMenuFromXml(testXmlFilePath);

		// Загрузим меню из тестового XML-файла
		Menu menu = menuService.loadMenuFromXml(testXmlFilePath);

		// Проверим, что объект меню не является null
		assertNotNull(menu, "Loaded menu should not be null");

	}
}

