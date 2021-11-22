import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @Execution(ExecutionMode.CONCURRENT)
    class WebsiteTest {

        WebDriver driver;

        @BeforeAll
        static void setDriver() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setup() {
            driver = new ChromeDriver();
        }

        @AfterEach
        void tearDown() {
            driver.quit();
        }

        @DisplayName("Testuję SII portal")
        @ParameterizedTest
        @ValueSource(strings = {"Logowanie na koncie"})
        @Tag("Regression")
        void pageOneTest(String expectedTitle) {
            driver.get("https://siiportal.sii.pl/");
            driver.manage().window().maximize();
            String actualTitle = driver.getTitle();

            assertThat(actualTitle, equalTo(expectedTitle));
        }

        @DisplayName("Testuję Onet.pl")
        @ParameterizedTest
        @ValueSource(strings = {"Onet – Jesteś na bieżąco"})
        @Tag("Regression")
        void pageTwoTest(String expectedTitle) {

            driver.get("https://www.onet.pl/");
            driver.manage().window().maximize();
            String actualTitle = driver.getTitle();

            assertThat(actualTitle, equalTo(expectedTitle));
        }

        @DisplayName("Testuję Kotuszkowo.pl")
        @ParameterizedTest
        @ValueSource(strings = {"Kotuszkowo- blog o kotach"})
        @Tag("Regression")
        void pageThreeTest(String expectedTitle) {

            driver.get("http://kotuszkowo.pl/");
            driver.manage().window().maximize();
            String actualTitle = driver.getTitle();

            assertThat(actualTitle, equalTo(expectedTitle));
        }

        @DisplayName("Testuję filmweb.pl")
        @ParameterizedTest
        @ValueSource(strings = {"Filmweb - filmy takie jak Ty!"})
        @Tag("Regression")
        void pageFourTest(String expectedTitle) {

            driver.get("https://www.filmweb.pl/");
            driver.manage().window().maximize();
            String actualTitle = driver.getTitle();

            assertThat(actualTitle, equalTo(expectedTitle));
        }

        @DisplayName("Testuję Dokumentację Selenium")
        @ParameterizedTest
        @ValueSource(strings = {"WebDriver | Selenium"})
        @Tag("Regression")
        void pageFiveTest(String expectedTitle) {

            driver.get("https://www.selenium.dev/documentation/webdriver/");
            driver.manage().window().maximize();
            String actualTitle = driver.getTitle();

            assertThat(actualTitle, equalTo(expectedTitle));
        }
    }

