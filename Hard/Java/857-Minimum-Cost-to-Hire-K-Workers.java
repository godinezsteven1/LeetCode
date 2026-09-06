class Solution {

    private class Pair {
        double ratio; 
        int quality; 
        Pair(int quality, double ratio) {
            this.quality = quality; 
            this.ratio = ratio;
        }
    }


    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        // worker must be paid min expectation 
        // pay is proprotioinal to quality. 
        // naive approach check double, 2x pay ex) 100=20  10 : 10 5 
        // base cases: quality length != wage length 
        // k <= 1
        // constraints? 

        // quality and wage 70:10 = 7.0  25:30 : 1.25? 
        ArrayList<Pair> wageQualityRatio = new ArrayList<>();
        for(int i = 0; i < quality.length; i++) {
            double ratio = (double) wage[i] / quality[i];
            wageQualityRatio.add(new Pair(quality[i], ratio));
        }
        wageQualityRatio.sort( (a,b) -> Double.compare(a.ratio, b.ratio));
        // max heap of quality
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int qualitySum = 0; // low mid high 
        double min = Double.MAX_VALUE;
        for(Pair worker: wageQualityRatio) {
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