package com.testSelenium;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestsPagesProduto {

	private static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\f0fp631\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	void testCadastroProdutoCamposPreenchidos() {

		driver.get("http://localhost:8080/SGP_CRUD/");

		driver.findElement(By.id("usuario")).click();
		driver.findElement(By.id("usuario")).sendKeys("admin");

		driver.findElement(By.id("senha")).click();
		driver.findElement(By.id("senha")).sendKeys("admin");

		driver.findElement(By.id("login-submit")).click();

		driver.get("http://localhost:8080/SGP_CRUD/novo-produto");

		driver.findElement(By.id("nomProd")).click();
		driver.findElement(By.id("nomProd")).sendKeys("teste");

		driver.findElement(By.id("descProd")).click();
		driver.findElement(By.id("descProd")).sendKeys("teste");

		driver.findElement(By.id("qntProd")).click();
		driver.findElement(By.id("qntProd")).sendKeys("10");

		driver.findElement(By.id("obsProd")).click();
		driver.findElement(By.id("obsProd")).sendKeys("teste");

		driver.findElement(By.id("gravar")).click();

		driver.get("http://localhost:8080/SGP_CRUD/get-produtos");

		driver.findElement(By.linkText("Lista Produto")).click();
		driver.findElement(By.id("exportar")).click();
		driver.findElement(By.id("importar")).click();

		driver.get("http://localhost:8080/SGP_CRUD/alteracao-produtos");
		driver.findElement(By.linkText("Alterar")).click();

		driver.findElement(By.name("nomProd")).click();
		driver.findElement(By.name("nomProd")).clear();
		driver.findElement(By.name("nomProd")).sendKeys("teste");

		driver.findElement(By.name("descProd")).click();
		driver.findElement(By.name("descProd")).clear();
		driver.findElement(By.name("descProd")).sendKeys("teste");

		driver.findElement(By.name("qntProd")).click();
		driver.findElement(By.name("qntProd")).clear();
		driver.findElement(By.name("qntProd")).sendKeys("10");

		driver.findElement(By.name("obsProd")).click();
		driver.findElement(By.name("obsProd")).clear();
		driver.findElement(By.name("obsProd")).sendKeys("teste");

		driver.findElement(By.id("gravar")).click();

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}

}
