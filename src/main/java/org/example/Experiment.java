package org.example;
import java.util.Arrays;

public class Experiment {
    private Sorter sorter=new Sorter();
    private Searcher searcher=new Searcher();

    public long measureSortTime(int[] arr, String type) {
        long start=System.nanoTime();
        if (type.equals("basic")) sorter.basicSort(arr);
        else sorter.advancedSort(arr);
        return System.nanoTime()-start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start=System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime()-start;
    }

    public void runAllExperiments() {
        int[] sizes={10, 100, 1000};
        for (int n:sizes) {
            System.out.println("Size: "+n);
            int[] a1=sorter.generateRandomArray(n);
            int[] a2= Arrays.copyOf(a1, n);

            System.out.println("Random Data");
            System.out.println("Basic Sort: "+measureSortTime(a1, "basic")+"ns");
            System.out.println("Advanced Sort: "+measureSortTime(a2, "advanced")+"ns");

            System.out.println("Sorted Data");
            System.out.println("Basic Sort: "+measureSortTime(a1, "basic")+"ns");
            System.out.println("Advanced Sort: "+measureSortTime(a2, "advanced")+"ns");

            System.out.println("Search Time: "+measureSearchTime(a1, -1)+"ns");
        }
    }
}
