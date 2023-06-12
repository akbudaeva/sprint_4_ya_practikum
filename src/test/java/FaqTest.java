import org.example.allpages.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class FaqTest extends BaseTest {

        private final String locatorOfQuestion;
        private final String locatorOfAnswer;
        private final String textOfAnswer;
        public FaqTest(String locatorOfQuestion, String locatorOfAnswer, String textOfAnswer){
            this.locatorOfAnswer=locatorOfAnswer;
            this.locatorOfQuestion=locatorOfQuestion;
            this.textOfAnswer=textOfAnswer;

        }
    @Parameterized.Parameters
    public static Object[][] expectedAnswers() {
        return new Object[][]{
                {MainPage.questionButtons[0], MainPage.answerToTheQuesrions[0], "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPage.questionButtons[1], MainPage.answerToTheQuesrions[1], "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPage.questionButtons[2], MainPage.answerToTheQuesrions[2], "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPage.questionButtons[3], MainPage.answerToTheQuesrions[3], "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPage.questionButtons[4], MainPage.answerToTheQuesrions[4], "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPage.questionButtons[5], MainPage.answerToTheQuesrions[5], "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPage.questionButtons[6], MainPage.answerToTheQuesrions[6], "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPage.questionButtons[7], MainPage.answerToTheQuesrions[7], "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    @Test
    public void testCheakTextEqQuestion(){
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollPageToQuestions();
        mainPage.clickOnButtonQuestion(locatorOfQuestion);
        String actualAnswerText = driver.findElement(By.id(locatorOfAnswer)).getText();
        assertEquals("Текст неправильный", textOfAnswer, actualAnswerText);
    }
}


