package com.minseungkwon.datastructure.Sort;

public class SortAlgorithm {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int partition = partition(arr, start, end);
        if (start < partition - 1) {
            quickSort(arr, start, partition - 1);
        }
        if (end > partition) {
            quickSort(arr, partition, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int index = start;
        int part1 = start;
        int part2 = mid + 1;
        while (part1 <= mid && part2 <= end) {
            if (temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            } else {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }
        for (int i = part1; i <= mid; i++) {
            arr[index++] = temp[i];
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        bubbleSort(arr, arr.length - 1);
    }

    private static void bubbleSort(int[] arr, int last) {
        if (last > 0) {
            for (int i = 1; i <= last; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                }
            }
            bubbleSort(arr, last - 1);
        }
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        selectionSort(arr, 0);
    }

    private static void selectionSort(int[] arr, int start) {
        if (start < arr.length - 1) {
            int minIndex = start;
            for (int i = start; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }
            swap(arr, start, minIndex);
            selectionSort(arr, start + 1);
        }
    }
}
