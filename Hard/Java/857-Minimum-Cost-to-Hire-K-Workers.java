class Solution {


    private class Pair {
        double ratio;
        int quality; 
        Pair(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        /**
        constraints: 
            k has to be a postive number greater then 1;
            quality = wage (length)
            return double
        naive;
            Input: quality = [10,20,5], wage = [70,50,30], k = 2
            Output: 105.00000
            paid 70 q 10
            paid 35 q 5 

            Input: quality = [10,20,5], wage = [70,50,60], k = 2
            pay 0th: 120, 60 
            cant pay them half of the 0th -> 35 
            Output: 105.00000
            paid 70 q 10
            paid 35 q 5 
        optimal: 

        class pair {
        double ratio
        int quality 
        }
        ArrayList<Pair> wageQualityRatio = new ArrayList<>(); 
        semantic represetnation ratio double wage[i] / quality[i] Input: quality = [10,20,5], wage = [70,50,60], k = 2
                                                ratio: 7.0 instead of 1/7th 
                                        quality point
        sort wage quality ratio 
        [least pay expectancy --[here]-> highest pay expectency ]

        maxHeap
        qualitySum
        min = big number Double.MAX_VALUE
        for(Pair worker: wageQualityRatio)
            maxheap.add worker
            quality += worker.ratio
            if (maxHeap.size() >= k)
                qualitysum -= maxHeap.poll()
            if (maxHeap.size() == k) {
                math.min(min, qualitySum * worker.ratio)
            }
        return min
    
        */

        ArrayList<Pair> wageQualityRatio = new ArrayList<>(); // space O(n)
        for(int i = 0; i < quality.length; i++) { // time O(n)
            double ratio = (double) wage[i] / quality[i];
            wageQualityRatio.add(new Pair(ratio, quality[i]));
        }
        wageQualityRatio.sort((a,b) -> Double.compare(a.ratio, b.ratio)); // check time O(n log n)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double min = Double.MAX_VALUE;
        int qualitySum = 0;
        for(Pair worker: wageQualityRatio) { // time O(n)
            maxHeap.add(worker.quality);
            qualitySum += worker.quality;
            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }
            if (maxHeap.size() == k) {
                double cost = qualitySum * worker.ratio;
                min = Math.min(min, cost);
            }
        }

        return min;

    }
}