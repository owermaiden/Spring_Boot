import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {


    // simplifies what data provider does...Be carefull we don't add @test annotation
    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
    void testCase1(String args){
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints={3,6,9})
    void testCase2(int number){
        Assertions.assertEquals(0,number%3);
    }


    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
//    @EmptySource  -------------------------------------- send empty args...
//    @NullSource   -------------------------------------- send null args...
    @NullAndEmptySource
    void testCase3(String args){
        Assertions.assertTrue(!args.isEmpty());

    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String arg){
        Assertions.assertNotNull(arg);
    }

    static String[] stringProvider(){    // this method must be static and must return array or stream...
        String arr[]={"Java","JS","TS"};
        return arr;
    }

    @ParameterizedTest
    @CsvSource({                        // use comma seperated arguments
            "10,20,30",
            "20,20,40",
            "30,20,100"
    })
    void testCase5(int num1,int num2,int result){
        Assertions.assertEquals(result,Calculator.add(num1,num2));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv",numLinesToSkip = 1)  // resources da bu dosyayı olusturduk...
    void testCase6(int num1,int num2,int result){
        Assertions.assertEquals(result,Calculator.add(num1,num2));
//        Assertions.assertEquals(result,Calculator.add(num1,num2));
    }






}