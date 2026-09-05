class Solution {

    private class Pair {
        int quality;
        double ratio;

        Pair(int quality, double ratio) {
            this.quality = quality;
            this.ratio = ratio;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        ArrayList<Pair> wageQualityRatio = new ArrayList<>();
        for(int i = 0; i < quality.length; i++) {
            double ratio = (double) wage[i] / quality[i];
            wageQualityRatio.add(new Pair(quality[i], ratio));
        }
        wageQualityRatio.sort((a, b) -> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int qualitySum = 0;
        double min = Double.MAX_VALUE;
        for (Pair worker: wageQualityRatio) {
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