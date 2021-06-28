package heap;

import java.util.*;

class Coordinate {

    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistanceFromOrigin () {
        return this.x * this.x + this.y * this.y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class KClosestPointToOrigin {

    public static void main(String[] args) {
        Coordinate coordinateOne = new Coordinate(2, 3);
        Coordinate coordinateTwo = new Coordinate(1, 4);
        Coordinate coordinateThree = new Coordinate(3, 5);
        Coordinate coordinateFour = new Coordinate(0, 4);

        List<Coordinate> coordinateList = new ArrayList<>();
        coordinateList.add(coordinateOne);
        coordinateList.add(coordinateTwo);
        coordinateList.add(coordinateThree);
        coordinateList.add(coordinateFour);

        System.out.println(findKClosestPointToOriginUsingList(coordinateList, 2));
        System.out.println(findKClosestPointToOriginUsingMinHeap(coordinateList, 2));
        System.out.println(findKClosestPointToOriginUsingMaxHeap(coordinateList, 2));
    }

    public static List<Coordinate> findKClosestPointToOriginUsingMaxHeap (List<Coordinate> coordinateList, int k) {

        List<Coordinate> result = new ArrayList<>();
        if (coordinateList.size() == 0 || k > coordinateList.size()) {
            return result;
        }

        PriorityQueue<Coordinate> maxHeap = new PriorityQueue<>((coordinateOne, coordinateTwo) -> {
            return coordinateTwo.getDistanceFromOrigin() - coordinateOne.getDistanceFromOrigin();
        });

        for (int i = 0; i < k; i++) {
            maxHeap.offer(coordinateList.get(i));
        }

        for (int i = k; i < coordinateList.size(); i++) {
            if (maxHeap.peek().getDistanceFromOrigin() > coordinateList.get(i).getDistanceFromOrigin()) {
                maxHeap.poll();
                maxHeap.offer(coordinateList.get(i));
            }
        }

        for (int i = 1; i <= k; i++) {
            result.add(maxHeap.poll());
        }
        return result;
    }

    public static List<Coordinate> findKClosestPointToOriginUsingMinHeap (List<Coordinate> coordinateList, int k) {

        List<Coordinate> result = new ArrayList<>();
        if (coordinateList.size() == 0 || k > coordinateList.size()) {
            return result;
        }

        PriorityQueue<Coordinate> minHeap = new PriorityQueue<>(Comparator.comparingInt(Coordinate::getDistanceFromOrigin));

        for (Coordinate eachCoordinate : coordinateList) {
            minHeap.offer(eachCoordinate);
        }

        for (int i = 1; i <= k; i++) {
            result.add(minHeap.poll());
        }
        return result;
    }

    public static List<Coordinate> findKClosestPointToOriginUsingList (List<Coordinate> coordinateList, int k) {

        List<Coordinate> result = new ArrayList<>();
        if (coordinateList.size() == 0 || k > coordinateList.size()) {
            return result;
        }

        coordinateList.sort(Comparator.comparingInt(Coordinate::getDistanceFromOrigin));

        int i = 0;
        while (i < k) {
            result.add(coordinateList.get(i));
            i++;
        }
        return result;
    }
}
