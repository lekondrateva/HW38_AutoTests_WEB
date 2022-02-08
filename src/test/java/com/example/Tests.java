package com.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Tests {
    /**
     * Запустить тесты: CTRL+SHIFT+F10
     **/

    public static final WebDriver webDriver;
    public static final HttpStatusCodeCheckPage httpStatusCodeCheckPage;
    public static final SubscribePage subscribePage;
    public static final UrlPage urlPage;
    public static final FillTheFieldPage fillTheFieldPage;
    public static final ElementsPage elementsPage;

    // Главная страница Skillfactory
    public static final String URL = "https://skillfactory.ru/";
    private static final String SF_LINK_XPATH = "//img[contains(@imgfield,'1595249309306')]";

    // Бесплатно
    public static final String FREEEVENTS_URL = "https://skillfactory.ru/events";
    public static final String FORFREE_EVENTS_LINK_XPATH = "//div[contains(@data-elem-id,'1563732786859')]/a";

    // Блог
    public static final String BLOG_URL = "https://blog.skillfactory.ru/";

    // Партнерам
    public static final String PARTNERS_PROGRAM_XPATH = "//div[@data-elem-id='1563732871939']";
    public static final String PARTNERS_PROGRAM_FORM_XPATH = "//div[@data-elem-id='1587723260884']";
    public static final String PARTNERS_PROGRAM_JOIN_XPATH = "//span[@class='t142__text' and contains(text(), 'Присоединиться')]";
    public static final String PARTNERS_PROGRAM_TARGET_URL = "https://my.advcake.com/o/skillfactory/affiliate/registration";

    // Сотрудничество
    public static final String PARTNERS_XPATH = "//a[@class = 'tn-atom' and @href='https://new.skillfactory.ru/partners']";
    public static final String PARTNERS_FORM_XPATH = "//div[@data-elem-id = '1634652627118']/a";

    public static final String NAME_XPATH = "(//input[@name = 'name'])[1]";
    public static final String name = "Тестов Тестик";
    public static final String COMPANY_XPATH = "(//input[@name = 'company'])[1]";
    public static final String company = "ООО Тестбук";
    public static final String SITE_XPATH = "(//input[@name = 'site'])[1]";
    public static final String site = "https://testikltd.by";
    public static final String EMAIL_XPATH = "(//input[@name = 'email'])[1]";
    public static final String partner_email = "testik@mail.ru";
    public static final String TEXT_XPATH = "(//textarea[@name = 'letter'])[1]";
    public static final String text = "тестовое сообщение";

    public static final String SUBMIT_XPATH = "(//button[@type = 'submit'])[1]";

    public static final String PARTNER_RESULT_TEXT_XPATH = "(//div[@class=\"t702__title t-title t-title_xxs\"])[1]";
    public static final String ExpectedPartnerResultMessage = "Готовы обсудить сотрудничество";

    // Подписка на рассылку "Бесплатный гид по направлениям в IT"
    public static final String SUBSCRIBE_RESULT_MESSAGE = "//div[@id='tildaformsuccesspopuptext']";
    public static final String EMAIL_INPUT_FIELD_XPATH = "(//input[@name=\"email\"])[1]";
    public static final String email = "sftettstmailffy@mail.ru";
    public static final String ExpectedMessage1 = "Спасибо! Данные успешно отправлены.";
    public static final String ExpectedMessage2 = "Thank you! Your data has been submitted.";

    // Направление Data science
    public static final String DATA_SCIENCE_DIRECTION_XPATH = "//*[@id=\"rec384365805\"]/div/div/div[11]/div/a";
    public static final String DATA_SCIENTIST_XPATH = "//*[@id=\"rec324797732\"]/div[1]/div/div[3]/div[1]/a/div[2]/div[1]";
    public static final String DATA_SCIENTIST_URL = "https://skillfactory.ru/data-scientist-pro";

    // Habr
    public static final String HABR_XPATH = "//div[@data-elem-id='1608735712198']";
    public static final String HABR_URL = "https://habr.com/ru/company/skillfactory/blog/";

    // Новогодняя распродажа
    public static final String NEW_YEAR_SALE_XPATH = "//div[@class='popmechanic-close']";

    // Facebook
    public static final String FB_XPATH = "//div[@data-elem-id='1608548393846']";
    public static final String FB_URL = "https://www.facebook.com/skillfactoryschool/";

    // Twitter
    public static final String TWIT_XPATH = "//div[@data-elem-id='1608548393850']/a";
    public static final String TWIT_URL = "https://twitter.com/skillfactoryru";

    // Instagram
    public static final String INSTA_XPATH = "//div[@data-elem-id='1608548393853']/a";
    public static final String INSTA_URL = "https://www.instagram.com/skillfactoryschool/";

    // Youtube
    public static final String YOUTUBE_XPATH = "//div[@data-elem-id='1608548393857']/a";
    public static final String YOUTUBE_URL = "https://www.youtube.com/channel/UClOTq6XN8g7-16QLGnZ6_EA";

    // Разработка игр
    public static final String RAZRABOTKA_IGR_URL = "https://skillfactory.ru/razrabotka-igr";

    // Аналитика данных
    public static final String DA_URL = "https://skillfactory.ru/analitika-dannyh";

    // Telegram
    public static final String TELEGRAM_XPATH = "//div[@data-elem-id='1608548393860']/a";
    public static final String TELEGRAM_URL = "https://t.me/skillfactory";

    // Программирование
    public static final String PROGR_URL = "https://skillfactory.ru/programmirovanie";

    // Contented
    public static final String CONTENTED_XPATH = "//div[@data-elem-id='1608548339887']/a";
    public static final String CONTENTED_URL = "https://contented.ru/";

    // Веб-разработка
    public static final String WEB_URL = "https://skillfactory.ru/web-razrabotka";

    // Тестирование
    public static final String TEST_XPATH = "//div[@data-elem-id='1630325189438']/div/a";
    public static final String TEST_URL = "https://skillfactory.ru/testirovanie";

    // Product Live
    public static final String PRODUCT_LIVE_XPATH = "//div[@data-elem-id='1616065796924']/a";
    public static final String PRODUCT_LIVE_URL = "https://productlive.io/";


    // Процесс инициализации необходимых ресурсов
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LenOK\\IdeaProjects\\HW38_Autotesting_SF_Web\\src\\test\\java\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        httpStatusCodeCheckPage = new HttpStatusCodeCheckPage(webDriver);
        subscribePage = new SubscribePage(webDriver);
        urlPage = new UrlPage(webDriver);
        fillTheFieldPage = new FillTheFieldPage(webDriver);
        elementsPage = new ElementsPage(webDriver);
    }

    // 1 - При нажатии на значок Skillfactory в левом верхнем углу открывается главная страница
    @Test
    public void goSFMainPage() {
        webDriver.get(URL);
        urlPage.goUrlXpath(SF_LINK_XPATH);
        urlPage.verifyLinkUrl(URL);
        //webDriver.close();
    }

    // 2 - "Бесплатно" - Получить ссылку элемента, сравнить с ожидаемой ссылкой
    @Test
    public void verifyUrlFreeEvents() {
        webDriver.get(URL);
        urlPage.verifyUrlOfElement(FORFREE_EVENTS_LINK_XPATH, FREEEVENTS_URL);
        //webDriver.close();
    }

    // 3 - "Партнерам" - Проверить доступность формы Регистрации издателя
    @Test
    public void openPartnerRegistrationForm() {
        webDriver.get(URL);
        webDriver.findElement(By.xpath(PARTNERS_PROGRAM_XPATH)).click();
        webDriver.findElement(By.xpath(PARTNERS_PROGRAM_FORM_XPATH)).click();
        urlPage.goUrlXpath(PARTNERS_PROGRAM_JOIN_XPATH);
        urlPage.verifyLinkUrl(PARTNERS_PROGRAM_TARGET_URL);
        //webDriver.close();
    }

    // 4 -"Сотрудничество" - Заполнить и отправить заявку на сотрудничество, убедиться, что получено сообщение об отправке
    @Test
    public void requestThePartnership() {
        webDriver.get(URL);
        webDriver.findElement(By.xpath(PARTNERS_XPATH)).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PARTNERS_FORM_XPATH))).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        fillTheFieldPage.findFieldAndInput(NAME_XPATH, name);
        fillTheFieldPage.findFieldAndInput(COMPANY_XPATH, company);
        fillTheFieldPage.findFieldAndInput(SITE_XPATH, site);
        fillTheFieldPage.findFieldAndInput(EMAIL_XPATH, partner_email);
        fillTheFieldPage.findFieldAndInput(TEXT_XPATH, text);
        webDriver.findElement(By.xpath(SUBMIT_XPATH)).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String PartnerResultMessage = subscribePage.getResultMessage(PARTNER_RESULT_TEXT_XPATH);
        System.out.println(PartnerResultMessage);
        assertEquals(ExpectedPartnerResultMessage, PartnerResultMessage);
        //webDriver.close();
    }

    // 5 - При переходе в раздел "Блог" код ответа 200
    @Test
    public void getResponseBlog() throws IOException {
        httpStatusCodeCheckPage.getResponseCode(BLOG_URL);
        //webDriver.close();
    }

    // 6 - Подписаться на рассылку "Бесплатный гид по направлениям в IT", либо вывести сообщение о необходимости ввода капчи
    @Test
    public void subscribeDirections() {
        webDriver.get(URL);
        subscribePage.subscribe(EMAIL_INPUT_FIELD_XPATH, email);
        //WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        List<WebElement> elems = webDriver.findElements(By.xpath(SUBSCRIBE_RESULT_MESSAGE));
        if (elems.size() == 0) {
            System.out.println("Captcha input is required");
        } else {
            String SubscribeResultMessage = subscribePage.getResultMessage(SUBSCRIBE_RESULT_MESSAGE);
            System.out.println(SubscribeResultMessage);
            assertThat(SubscribeResultMessage, isOneOf(ExpectedMessage1, ExpectedMessage2));
        }
        //webDriver.close();
    }

    // 7 - Перейти в направление DS, перейти на курс "Data scientist", убедиться, что открывается ожидаемая ссылка
    @Test
    public void openDScourse() {
        webDriver.get(URL);
        webDriver.findElement(By.xpath(DATA_SCIENCE_DIRECTION_XPATH)).click();
        ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        urlPage.goUrlXpath(DATA_SCIENTIST_XPATH);
        urlPage.verifyLinkUrl(DATA_SCIENTIST_URL);
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(0));
        //webDriver.close();
    }

    // 8 HABR - Открыть ссылку на Habr с главной страницы, убедиться, что открывается ожидаемая ссылка
    @Test
    public void goHabr() {
        webDriver.get(URL);
        boolean element = elementsPage.existsElement(NEW_YEAR_SALE_XPATH);
        if (element) {
            webDriver.findElement(By.xpath(NEW_YEAR_SALE_XPATH)).click();
        } else {
            System.out.println("There is no any New Year Sale");
        }
        urlPage.goUrlXpath(HABR_XPATH);
        ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        urlPage.verifyLinkUrl(HABR_URL);
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(0));
        //webDriver.close();
    }

    // 9 Facebook - Открыть ссылку на Facebook с главной страницы, убедиться, что открывается ожидаемая ссылка
    @Test
    public void goFacebook() {
        webDriver.get(URL);
        boolean element = elementsPage.existsElement(NEW_YEAR_SALE_XPATH);
        if (element) {
            webDriver.findElement(By.xpath(NEW_YEAR_SALE_XPATH)).click();
        } else {
            System.out.println("There is no any New Year Sale");
        }
        urlPage.goUrlXpath(FB_XPATH);
        ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        urlPage.verifyLinkUrl(FB_URL);
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(0));
        //webDriver.close();
    }

    // 10 - Twitter - Получить ссылку элемента, сравнить с ожидаемой ссылкой
    @Test
    public void verifyUrlTwitter() {
        webDriver.get(URL);
        urlPage.verifyUrlOfElement(TWIT_XPATH, TWIT_URL);
        //webDriver.close();
    }

    // 11 Instagram - Получить ссылку элемента, сравнить с ожидаемой ссылкой
    @Test
    public void verifyUrlInstagram() {
        webDriver.get(URL);
        urlPage.verifyUrlOfElement(INSTA_XPATH, INSTA_URL);
        //webDriver.close();
    }

    // 12 YouTube - Открыть ссылку на Youtube с главной страницы, убедиться, что открывается ожидаемая ссылка
    @Test
    public void goYoutube() {
        webDriver.get(URL);
        boolean element = elementsPage.existsElement(NEW_YEAR_SALE_XPATH);
        if (element) {
            webDriver.findElement(By.xpath(NEW_YEAR_SALE_XPATH)).click();
        } else {
            System.out.println("There is no any New Year Sale");
        }
        urlPage.goUrlXpath(YOUTUBE_XPATH);
        ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        urlPage.verifyLinkUrl(YOUTUBE_URL);
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(0));
        //webDriver.close();
    }

    // 13 При переходе в раздел "Разработка игр" код ответа 200
    @Test
    public void getResponseRazrabotkaIgr() throws IOException {
        httpStatusCodeCheckPage.getResponseCode(RAZRABOTKA_IGR_URL);
        //webDriver.close();
    }

    // 14 При переходе в раздел "Аналитика данных" код ответа 200
    @Test
    public void getResponseAnalitikaDannyh() throws IOException {
        httpStatusCodeCheckPage.getResponseCode(DA_URL);
        //webDriver.close();
    }

    // 15 Telegram - Открыть ссылку на Telegram с главной страницы, убедиться, что открывается ожидаемая ссылка
    @Test
    public void goTelegram() {
        webDriver.get(URL);
        boolean element = elementsPage.existsElement(NEW_YEAR_SALE_XPATH);
        if (element) {
            webDriver.findElement(By.xpath(NEW_YEAR_SALE_XPATH)).click();
        } else {
            System.out.println("There is no any New Year Sale");
        }
        urlPage.goUrlXpath(TELEGRAM_XPATH);
        ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        urlPage.verifyLinkUrl(TELEGRAM_URL);
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(0));
        //webDriver.close();
    }

    // 16 При переходе в раздел "Программирование" код ответа 200
    @Test
    public void getResponseProgramming() throws IOException {
        httpStatusCodeCheckPage.getResponseCode(PROGR_URL);
        //webDriver.close();
    }

    // 17 Contented - Открыть ссылку на Contented с главной страницы, убедиться, что открывается ожидаемая ссылка
    @Test
    public void goContented() {
        webDriver.get(URL);
        boolean element = elementsPage.existsElement(NEW_YEAR_SALE_XPATH);
        if (element) {
            webDriver.findElement(By.xpath(NEW_YEAR_SALE_XPATH)).click();
        } else {
            System.out.println("There is no any New Year Sale");
        }
        urlPage.goUrlXpath(CONTENTED_XPATH);
        ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        urlPage.verifyLinkUrl(CONTENTED_URL);
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(0));
        //webDriver.close();
    }

    // 18 Веб-разработка - При переходе в раздел "Веб-разработка" код ответа 200
    @Test
    public void getResponseWebRazrabotka() throws IOException {
        httpStatusCodeCheckPage.getResponseCode(WEB_URL);
       // webDriver.close();
    }

    // 19 Тестирование - Получить ссылку элемента, сравнить с ожидаемой ссылкой
    @Test
    public void verifyUrlTesting() {
        webDriver.get(URL);
        urlPage.verifyUrlOfElement(TEST_XPATH, TEST_URL);
        //webDriver.close();
    }

    // 20 - Productlive - Открыть ссылку на ProductLive с главной страницы, убедиться, что открывается ожидаемая ссылка
    @Test
    public void goProductlive() {
        webDriver.get(URL);
        boolean element = elementsPage.existsElement(NEW_YEAR_SALE_XPATH);
        if (element) {
            webDriver.findElement(By.xpath(NEW_YEAR_SALE_XPATH)).click();
        } else {
            System.out.println("There is no any New Year Sale");
        }
        urlPage.goUrlXpath(PRODUCT_LIVE_XPATH);
        ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        urlPage.verifyLinkUrl(PRODUCT_LIVE_URL);
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(0));
        //webDriver.close();
    }
}
