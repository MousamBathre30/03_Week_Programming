package stringBufferproblem.CompareStringBufferAndBuilder;

public class CompareBuilderAndBuffer {


    public static void main(String[] args) {

        long startTime,endTime;

        // Testing String Builder Performance

        startTime = System.nanoTime();

        StringBuilder sb = new StringBuilder();

        sb.append("Java".repeat(100000));

        endTime = System.nanoTime();

        System.out.println("StringBuilder Time: " + (endTime-startTime) + " ns");

        // Testing the String buffer Performance

        startTime = System.nanoTime();

        StringBuffer sbuff = new StringBuffer();

        sbuff.append("java".repeat(100000));

        endTime = System.nanoTime();

        System.out.println("StringBuffer Time: " + (endTime-startTime) + " ns" );
    }
}
