package pro.puradawid.constructor;

public class App
{
    private static final int WARMUP_CYCLES = 100000;
    private static final int TRIAL_CYCLES = 1000;

    private static volatile double t;

    public static void main( String[] args ) {
        if ("non-struct".equals(args[0])) {
            double sum = 0.0;
            for (int i = 0; i < WARMUP_CYCLES; i++) {
                testPlainParametersCuboidTime(10000);
            }
            for (int i = 0; i < TRIAL_CYCLES; i++) {
                double singleResult = testPlainParametersCuboidTime(10000);
                System.out.println(
                    "Testing data structured " + singleResult);
                sum += singleResult;
            }
            System.out.println("Avg. result = " + (sum / TRIAL_CYCLES));
        } else {
            double sum = 0.0;
            for (int i = 0; i < WARMUP_CYCLES; i++) {
                testDataStructuredParametersCuboidTime(10000);
            }
            for (int i = 0; i < TRIAL_CYCLES; i++) {
                double singleResult = testDataStructuredParametersCuboidTime(10000);
                System.out.println(
                    "Testing data structured " + singleResult);
                sum += singleResult;
            }
            System.out.println("Avg. result = " + (sum / TRIAL_CYCLES));
        }
    }

    private static double testPlainParametersCuboidTime(int howManyTimes) {
        int w = 1;
        int h = 1;
        int d = 1;
        long start = System.nanoTime();
        for (int i = 0; i < howManyTimes; i++) {
             PlainParametersCuboid cuboid = new PlainParametersCuboid(w++, h++, d++, 1, 1, 1);
             t = cuboid.volume();
        }
        long stop = System.nanoTime();
        return (stop - start) / (double) howManyTimes;
    }

    private static double testDataStructuredParametersCuboidTime(int howManyTimes) {
        int w = 1;
        int h = 1;
        int d = 1;
        long start = System.nanoTime();
        for (int i = 0; i < howManyTimes; i++) {
            DataStructureParametersCuboid
                cuboid = new DataStructureParametersCuboid(new DataStructureParametersCuboid.Dimension(w++, h++, d++), new DataStructureParametersCuboid.Colour(1, 1, 1));
            t = cuboid.volume();
        }
        long stop = System.nanoTime();
        return (stop - start) / (double) howManyTimes;
    }
}
