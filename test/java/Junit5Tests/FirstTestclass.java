
//practice
package Junit5Tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestclass {
        @ParameterizedTest(name = "Run: {index} - value: {arguments}")
        @ValueSource(ints = {1, 2, 3})
        void intValues(int number) {

                System.out.println("The parameters: " + number);
        }
        @ParameterizedTest
        @CsvFileSource(files = "C:\\Users\\Maheen\\IdeaProjects\\Junit\\src\\test\\resources\\params\\shoppingList.csv",numLinesToSkip = 1)
        void csvFileSource_StringDoubleIntStringString(String name, double price,
                                                       int qty, String uom,
                                                       String provider) {
                System.out.println("name = " + name + ", price = " + price +
                        ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);

        }
        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {"firstString","SecondString"})
        void stringValues(String theParam)
        {
                System.out.println("The parameters: " + theParam);
        }

        @ParameterizedTest
        @CsvSource(value={"steve,rogers","captain,marvel","bucky,barnes"})
        void csvSource_StringString(String param1, String param2) {
                System.out.println("param1 = " + param1 + ", param2 = " + param2);
        }
        @ParameterizedTest
        @CsvSource(value = {"steve,32,true","captain,21,false","bucky,5,true"})
        void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
                System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
        }
        @ParameterizedTest
        @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
        void csvSource_StringWithDiffDelimiter(String param1, String param2) {
                System.out.println("param1 = " + param1 + ", param2 = " + param2);
        }
        @BeforeAll
        static void beforeAll()
        {
                System.out.println("-- Before All --");
        }
        @BeforeEach
        void beforeEach()
        {
                System.out.println("-- Before Each --");
        }
        @AfterAll
        void afterAll()
        {
                System.out.println("-- After All --");
        }
        @AfterEach
        void afterEach(){
                System.out.println("-- After Each --");
        }
        @Test
        @Disabled(value = "Disabled for a demo ")
        //accessModifier returnType nameofMethod(params)
        void firstMethod()
        {
                System.out.println("First Test");
        }

        @Test
        @DisplayName("US1234 - TC12 - this is second method")
        void secondMethod()
        {
                System.out.println("Second Test");
        }
}
