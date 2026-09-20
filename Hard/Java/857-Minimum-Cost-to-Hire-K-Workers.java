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
        

        // answer expected in double 
        /**

        base cases: k < 1, quality length != wage length || empty .. 
        
        
        naive: 
        quality = [10,20,5], wage = [70,50,60], k = 2


        optimal: 

        ratio = wage / quality 
        array(integer = ratio) add all of these values; 

        sort ascending 
        lowerst ratio --> ratio 
        lowest            highest


        maxHeap
        qualitysum 
        min 

        for worker in our array
            max heap . add worker quality 
            sum += worker.quality 

            heap size > k 
                sum -= heap.poll()
            heap == k 
            cost = qualitysum * worker.ratio
            min (cost, min)
        min 
         */


        ArrayList<Pair> wageQualityRatio = new ArrayList<>();
        for(int i = 0; i < wage.length; i++) {
            double ratio = (double) wage[i] / quality[i];
            wageQualityRatio.add(new Pair(ratio, quality[i]));
        }
        wageQualityRatio.sort((a,b) -> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int qualitySum = 0;
        double min = Double.MAX_VALUE;
        for(Pair worker: wageQualityRatio) {
            maxHeap.add(worker.quality);
            qualitySum += worker.quality;
            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }
            if (maxHeap.size() == k) {
                double cost = qualitySum * worker.ratio;
                min = Math.min(cost, min);
            }
        }
        return min;
    }
}