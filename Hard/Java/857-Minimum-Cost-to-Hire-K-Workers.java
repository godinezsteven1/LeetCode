class Solution {

    /**

    Clarification: 1 paid group, all real entries k > 1, answer double. 
    quality = [10,20,5], wage = [70,50,30], k = 2
    "if a worker’s quality is double that of another worker in the group, then they must be paid twice as much as the other worker."
    will quality and wage legnth always be equal? yes 

    if we hire person 0 (quality = 10 and wage 70) and hire person 2 (quality is 5 wage is 30)
    70 to first, 35 goes to second . 
    
    
    quality = [10,20,5], wage = [70,50,50], k = 2 (non naive solution)

    naive: 
        hire lowest quality points and do the checks 1) min wage check 2) if double in group pay. them twice. 
    
    optimal: 
    
        data structure person keeps track of semantic represetnation of what is a worker. 
        keep track of this ratio (double), and quality. 

        order it in increasing
        7, 8, 9, 10
        3, 5, (qualitySum) 
        at person 8 we have qs 5 * worker.ratio (this is curr cost)


        maxHeap; 10 (left child) 8

        return runnign min 


        quality = [10,20,5], wage = [70,50,50], k = 2 (non naive solution)
        p1 = 2.5 q 20
        p0 = 7.0 q 10
        p2 = 10.0 q 5

        qualitySum = 10 + 5 = 15

        maxHeap = 10 -> (left) 5 

        cost = 20 * 5 = 105
        min = 105

        wageQualityRatio 
_______
        ArrayList<Pair> wageQualityRatio = new ArrayList<>();
        for 
            quality[i] / wage[i] (double) & quality[i] = Pair add to list 
        wageQualityRatio.sort((a,b) -> Double.compare(a.ratio, b.ratio));

        double min = Double.MAX_VALUE;
        int qualitySum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(Pair worker: wageQualityRatio) {
            qualitySum += worker.quality;
            maxHeap.add(worker.quality)

            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll()
            }
            if (maxHeap.size() == k) {
                double cost = qualitySum * worker.ratio
                min = min(cost, min)
            }
        }

        return min;
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
        ArrayList<Pair> wageQualityRatio = new ArrayList<>();
        for(int i = 0; i < quality.length; i++) {
            double ratio = (double) wage[i] / quality[i];
            wageQualityRatio.add(new Pair(ratio, quality[i]));
        }
        wageQualityRatio.sort((a,b) -> Double.compare(a.ratio, b.ratio));

        double min = Double.MAX_VALUE;
        int qualitySum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(Pair worker: wageQualityRatio) {
            qualitySum += worker.quality;
            maxHeap.add(worker.quality);
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
