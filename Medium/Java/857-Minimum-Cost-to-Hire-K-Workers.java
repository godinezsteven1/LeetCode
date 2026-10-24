class Solution {

    /**
    Constraints:
        need exactly k workers? no more no less 
        will k be a positive number greater then 1? 
        largest value to expect of k/ and smallest 
        largest quality/wage number to expect? 
        largest and smallest length for quality and wage
        will they always be the same length 
        index correspond to each other 
        time complexity expected?
        space expected? 

        paid group has to be paid their min wage && pay proportional to quality 

    naive: 
        Input: quality = [10,20,5], wage = [70,50,30], k = 2
        Output: 105.00000

        brute force: 
        for 
            for 
                calculate paid group and compare it to min


        return min paid group 

    optimal: 
        quality = [10,20,5], wage = [70,50,30], k = 2

        1. semantic representation of whats going on 
            double ratio = (double) wage[i] / quality[i];  // 70/10 = 7.0 
            ds that keeps track of two thigs . 
            private class Pair {
                double ratio;
                int quality; 
                Pair(...) {...}
            }
            ArrayList<Pair> wageQualityRatio = new arrayList<>(); 
            for 
                wageQualityRatio.add(new Pair(...))
        2. order it 
            quality = [10,20,5], wage = [70,50,30], k = 2
            wageQualityRatio.sort((a,b) -> Double.compare(a.ratio, b.ratio));
            wageQualityRatio = 2.5, 6.0, 7.0
            "worker's pay must be directly proportional to their quality"

            i-th worker can pay for everyone before them. 
        3. track largest quality points and compare 
        // paid group will be measured by everyones quality sum in group x current persons ratio. 
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            int qualitySum = 0;
            double min = Double.MAX_VALUE; 
wageQualityRatio = 2.5, 6.0, 7.0 k = 2
qualitySum = 5 + 10  15 * 6 = 90 
maxHeap = 5, 10 
            for(Pair worker: wageQualityWorker) {
                qualitySum += worker.quality; 
                maxHeap.add(worker.quality); 
                if (maxHeap.size() > k) {
                    qualitySum -= maxHeap.poll();
                }
                if (maxHeap.size() == k) {
                    double cost = qualitySum * worker.ratio;
                    min = Math.min(cost, min);
                }
            } 

        return min ; 
     */


    private class Pair {
        double ratio;
        int quality;

        Pair(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality; 
        }
    }
    


    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        ArrayList<Pair> wageQualityRatio = new ArrayList<>(); // O(n)
        for(int i = 0; i < quality.length; i++) {  // O(n)
            double ratio = (double) wage[i] / quality[i]; 
            wageQualityRatio.add(new Pair(ratio, quality[i]));
        }
        wageQualityRatio.sort((a,b) -> Double.compare(a.ratio, b.ratio)); // O(n log n )

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // O(n)
        int qualitySum = 0;
        double min = Double.MAX_VALUE;

        for(Pair worker: wageQualityRatio) { // O(n)
            qualitySum += worker.quality;
            maxHeap.add(worker.quality);
            if (maxHeap.size() > k ) {
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