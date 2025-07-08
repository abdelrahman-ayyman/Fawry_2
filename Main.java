// Assumptions
/**
 * I assume that Ebooks have quantity as well as an indicator to number of licenses the store has to sell the ebook. If not, an interface might be introducted instead.
 * Assuming DemoBooks are not electronic.
 * Assuming weight is in grams and immutable
 */

class Main
{
    public static void main(String[] args)
    {
        
        tb testManager = new tb();
        try {
            testManager.testCase_1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            testManager.testCase_2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            testManager.testCase_3();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            testManager.testCase_4();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            testManager.testCase_5();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            testManager.testCase_6();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            testManager.testCase_66();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            testManager.testCase_7();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            testManager.testCase_8();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            testManager.testCase_9();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}