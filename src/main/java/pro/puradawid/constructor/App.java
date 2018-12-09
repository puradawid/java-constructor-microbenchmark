package pro.puradawid.constructor;

public class App
{
    private static final int WARMUP_CYCLES = 100000;
    private static final int TRIAL_CYCLES = 1000;

    private static volatile double t;

    public static void main( String[] args ) {
        PerformanceTest pt;

        if ("non-struct".equals(args[0])) {
            pt = new PlainValuesConstructorPerformanceTest();
        } else {
            pt = new DataStructuredConstructorPerformanceTest();
        }

        double sum = 0.0;

        for (int i = 0; i < WARMUP_CYCLES; i++) {
            pt.perform(10000);
        }

        for (int i = 0; i < TRIAL_CYCLES; i++) {
            double singleResult = pt.perform(10000);
            sum += singleResult;
        }

        System.out.println("Avg. result = " + (sum / TRIAL_CYCLES));
    }

    private static abstract class PerformanceTest {
        double perform(int howManyTimes) {
            int w = 1;
            int h = 1;
            int d = 1;
            long start = System.nanoTime();
            for (int i = 0; i < howManyTimes; i++) {
                t = createAndCalculate(w++, h++, d++);
            }
            long stop = System.nanoTime();
            return (stop - start) / (double) howManyTimes;
        }

        abstract double createAndCalculate(int w, int h, int d);
    }

    private static class DataStructuredConstructorPerformanceTest extends PerformanceTest {

        @Override
        double createAndCalculate(int w, int h, int d) {
            DataStructureParametersCuboid
                cuboid = new DataStructureParametersCuboid(
                new DataStructureParametersCuboid.Dimension(w, h, d),
                new DataStructureParametersCuboid.Colour(1, 1, 1));
            return cuboid.volume();
        }

    }

    private static class PlainValuesConstructorPerformanceTest extends PerformanceTest {

        @Override
        double createAndCalculate(int w, int h, int d) {
            PlainParametersCuboid cuboid = new PlainParametersCuboid(w, h, d, 1, 1, 1);
            return cuboid.volume();
        }

    }
}
