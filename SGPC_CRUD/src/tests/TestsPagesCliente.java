package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestsPagesCliente {

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
	void test() {

		driver.get("http://localhost:8080/SGP_CRUD/");

		driver.findElement(By.id("usuario")).click();
		driver.findElement(By.id("usuario")).sendKeys("admin");

		driver.findElement(By.id("senha")).click();
		driver.findElement(By.id("senha")).sendKeys("admin");

		driver.findElement(By.id("entrar")).click();

		driver.get("http://localhost:8080/SGP_CRUD/novo-cliente");

		driver.findElement(By.id("nomeClie")).click();
		driver.findElement(By.id("nomeClie")).sendKeys("teste");

		driver.findElement(By.id("sobreClie")).click();
		driver.findElement(By.id("sobreClie")).sendKeys("teste");

		driver.findElement(By.id("cpfClie")).click();
		driver.findElement(By.id("cpfClie")).sendKeys("523325");

		driver.findElement(By.id("dataNascClie")).click();
		driver.findElement(By.id("dataNascClie")).sendKeys("01/01/2000");

		driver.findElement(By.id("localClie")).click();
		driver.findElement(By.id("localClie")).sendKeys("teste");

		driver.findElement(By.id("gravar")).click();

		driver.get("http://localhost:8080/SGP_CRUD/all-clientes");
		driver.findElement(By.linkText("Lista de Clientes")).click();

		driver.get("http://localhost:8080/SGP_CRUD/all-clientes");
		driver.findElement(By.linkText("Alterar")).click();

		driver.findElement(By.name("nomeClie")).click();
		driver.findElement(By.name("nomeClie")).clear();
		driver.findElement(By.name("nomeClie")).sendKeys("teste");

		driver.findElement(By.name("sobreClie")).click();
		driver.findElement(By.name("sobreClie")).clear();
		driver.findElement(By.name("sobreClie")).sendKeys("teste");

		driver.findElement(By.name("cpfClie")).click();
		driver.findElement(By.name("cpfClie")).clear();
		driver.findElement(By.name("cpfClie")).sendKeys("52352332");

		driver.findElement(By.name("dataNascClie")).click();
		driver.findElement(By.name("dataNascClie")).clear();
		driver.findElement(By.name("dataNascClie")).sendKeys("01-01-2000");

		driver.findElement(By.name("localClie")).click();
		driver.findElement(By.name("localClie")).clear();
		driver.findElement(By.name("localClie")).sendKeys("teste");

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
