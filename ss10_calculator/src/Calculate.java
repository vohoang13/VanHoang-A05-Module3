import java.io.IOException;

public class Calculate {
    public Calculate(){}

    public double getCalculate(float first, float second, String select){
        double result = 0;
        switch (select){
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                try {
                    result = first / second;
                }catch (Exception e){
                    e.printStackTrace();
            }
        }
        return result;
    }
}
