// pseudocode:
// 1. Count frequencies with a HashMap
// 2. Create a min-heap (PriorityQueue) that orders by frequency
// 3. For each entry (number, count) in the HashMap:
//      If heap.size() < k:
//          Add it to the heap
//      Else:
//          If count > frequency of heap's smallest element:
//              Remove the smallest from heap
//              Add the new one
// 4. Whatever's left in the heap = your answer


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1); // give me the current vaule for this key, or a default value (0) if its not there yet.
        }

        // Step 2: Min-heap ordered by frequency
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b)); // orders the heap by frequency (min on top)

        for (int num : count.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll(); // removes and returns the top of the heap, in this case the smallest frequency
            }
        }
        // Step 3: Build result array from heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll(); // pulling values out of the heap one at a time to fill the result array
        }

        return result;
    }
}
