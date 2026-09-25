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
        ArrayList<Pair> wageQualityRatio = new ArrayList<>();
        for(int i = 0; i < quality.length; i++) {
            double ratio = (double) wage[i] / quality[i];
            wageQualityRatio.add(new Pair(ratio, quality[i]));
        }
        wageQualityRatio.sort((a,b) -> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int qualitySum = 0;
        double minCost = Double.MAX_VALUE;

        for(Pair worker: wageQualityRatio) {
            maxHeap.add(worker.quality);
            qualitySum += worker.quality;
            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }
            if (maxHeap.size() == k) {
                double cost = qualitySum * worker.ratio;
                minCost = Math.min(cost, minCost);
            }
        }

        return minCost;


    }
}