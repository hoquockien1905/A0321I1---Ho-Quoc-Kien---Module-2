public class Calculator {
    public static float calculate(float firstOpe, float secondOpe, char ope) throws Exception {
        switch (ope) {
            case '+':
                return firstOpe + secondOpe;
            case '-':
                return firstOpe - secondOpe;
            case '*':
                return firstOpe * secondOpe;
            case '/':
                if (secondOpe != 0) {
                    return firstOpe / secondOpe;
                } else {
                    throw new Exception("Can't divide by zero");
                }
            default:
                throw new Exception("Invalid value!");
        }
    }
}
