package problemstatement3.striingperformance;

public class String_Buffer_Builder {
     // method for string performance
    public static void stringPerformance(){
        String str = "";
        double start  = System.nanoTime();
        // for the 1000 concatenation
        for(int i=0; i<1000; i++){
            str += "ab";
        }
        double end = System.nanoTime();

        double diff = ( end - start ) / 1000000;

        System.out.println("Time taken by string for 1000 concatenating " + diff + " ms");


       String str2 = "";
        // For 10000 word
        double start2 = System.nanoTime();
        for(int i=0; i<100000; i++){
            str2 += "ab";
        }
        double end2 = System.nanoTime();

        double diff2 = ( end2 - start2 ) / 1000000;

        System.out.println("Time taken by string for 100000 concatenating " + diff2 + " ms");

       String str3 = "";
        // For 100000 word
        // ----- > UNUSABLE
        double start3 = System.nanoTime();
        for(int i=0; i<1000000; i++){
            str += "ab";
        }

        double end3 = System.nanoTime();

        double diff3 = ( end3 - start3 ) / 1000000;

        System.out.println("Time taken by string for 100000 concatenating " + diff2 + " ms");
        System.out.println("*************************************************************************");
   }
    // Buffer Performance in Thousand
    public static void bufferthousand(String str){
        StringBuffer buff = new StringBuffer();
        double start = System.nanoTime();
        for(int i=0; i<1000; i++){
            buff.append(str);
        }
        double end = System.nanoTime();
        double diff = ( end - start ) / 1000000;
        System.out.println("Time taken by string Buffer for 1000 concatenating " + diff + " ms" );
    }
    // Buffer Performance in tenThousand
    public static void bufferTenthousand(String str){
        StringBuffer buff = new StringBuffer();
        double start = System.nanoTime();
        for(int i=0; i<10000; i++){
            buff.append(str);
        }
        double end = System.nanoTime();
        double diff = ( end - start ) / 1000000;
        System.out.println("Time taken by string Buffer for 10000 concatenating " + diff + " ms" );
    }
    // Buffer Performance in milion
    public static void buffermilion(String str){
        StringBuffer buff = new StringBuffer();
        double start = System.nanoTime();
        for(int i=0; i<1000000; i++){
            buff.append(str);
        }
        double end = System.nanoTime();
        double diff = ( end - start ) / 1000000;
        System.out.println("Time taken by string Buffer  for 1000000 concatenating " + diff + " ms" );
        System.out.println("*************************************************************************");
    }


    // Builder Performance in Thousand
    public static void builderthousand(String str){
        StringBuilder br = new StringBuilder();
        double start = System.nanoTime();
        for(int i=0; i<1000; i++){
            br.append(str);
        }
        double end = System.nanoTime();
        double diff = ( end - start ) / 1000000;
        System.out.println("Time taken by string Builder for 1000 concatenating " + diff + " ms" );
    }
    // Builder Performance in tenThousand
    public static void builderTenthousand(String str){
        StringBuilder br = new StringBuilder();
        double start = System.nanoTime();
        for(int i=0; i<10000; i++){
            br.append(str);
        }
        double end = System.nanoTime();
        double diff = ( end - start ) / 1000000;
        System.out.println("Time taken by string Builder for 10000 concatenating " + diff + " ms" );
    }
    // Builder Performance in a million
    public static void buildermilion(String str){
        StringBuilder br = new StringBuilder();
        double start = System.nanoTime();
        for(int i=0; i<1000000; i++){
            br.append(str);
        }
        double end = System.nanoTime();
        double diff = ( end - start ) / 1000000;
        System.out.println("Time taken by string Builder for 1000000 concatenating " + diff + " ms" );
        System.out.println("*************************************************************************");
    }

    // buffer performance ------------------
    public static void stringBufferPerformance(){
        String str = "ab";
        // for the 1000 operation
        bufferthousand(str);
        bufferTenthousand(str);
        buffermilion(str);
    }
  // Builder Performance ---------------------
    public static void stringBuilderPerformance(){
        String str = "ab";
        // for the 1000 operation
        builderthousand(str);
        builderTenthousand(str);
        buildermilion(str);
    }
  // main method
    public static void main(String[] args) {
        // method to check the String performance
        stringPerformance();
        stringBufferPerformance();
        stringBuilderPerformance();
    }
}
