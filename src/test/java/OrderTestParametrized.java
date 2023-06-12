
import org.example.allpages.MainPage;
import org.example.allpages.OrderPage;
import org.example.allpages.RentPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTestParametrized extends BaseTest {
    private final String firstName;
    private final String lastName;
    private final String deliveryAddress;
    private final String phoneNumber;
    private final String startDateRent;
    private final String commentField;

    public OrderTestParametrized(String firstName, String lastName, String deliveryAddress, String phoneNumber, String startDateRent, String commentField) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
        this.startDateRent = startDateRent;
        this.commentField = commentField;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Анастасия", "Будаева", "копозиторов 10", "89876543394", "28.08.1993", "орпав пмриот"},
                {"Иван", "Будько", "невский 34", "89875656767", "04.07.2016", "смпроить итоь"},
        };
    }
    //Заказ через кнопку наверху
    @Test
    public void testOrderButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.order(firstName, lastName, deliveryAddress, phoneNumber);

        RentPage rentPage = new RentPage(driver);
        rentPage.rent(startDateRent, commentField);

        assertTrue(rentPage.checkOrderWindow());
    }

    //Заказ по кнопке в середине странице
    @Test
    public void testOrderMiddle() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToPushOrderButton();
        mainPage.clickButtonOrderAtMiddle();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.order(firstName, lastName, deliveryAddress, phoneNumber);

        RentPage rentPage = new RentPage(driver);
        rentPage.rent(startDateRent, commentField);

        assertTrue(rentPage.checkOrderWindow());
    }
}
