public class TryCatch {
    public static void main(String[] args) {
        try {
            System.out.println("try...");
            return;
        } catch (Exception e) {
            System.out.println("catch到了异常");
        }finally {
            System.out.println("finally中的代码，就算try..catch中有return也会执行");
        }
        System.out.println("捕捉到异常后会继续执行catch代码块之后的代码");
    }
}
