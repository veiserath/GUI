package com.company;
//dokonczyc
public class Sortowanie {

    Sortowanie(){

    }


    static int[] insertSort(int someTable[]) {
    int arrayLength = someTable.length;
    for (int i = 1; i < arrayLength; i++){
        int key = someTable[i];
        int j = i - 1;

        while (j >= 0 && someTable[j] > key){
            someTable[j+1] = someTable[j];
            j = j - 1;
        }
        someTable[j+1] = key;
    }
    return someTable;
    }

    static int[] selectionSort(int someTable[]) {
        int arrayLength = someTable.length;
        for (int i = 0; i < arrayLength - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arrayLength; j++){
                if (someTable[minIndex] > someTable[j]){
                    minIndex = j;
                }
            }
            int tmp = someTable[minIndex];
            someTable[minIndex] = someTable[i];
            someTable[i] = tmp;
        }
    return someTable;
    }
        //cos tu nie dziala ten mergeSort
    static void mergeSort(int someTable[], int arrayLength) {
//    if (arrayLength < 2){
//        System.out.println("Tablica za mala by posortowac");
//    }
    int mid = arrayLength/2;
    int [] left = new int[mid];
    int [] right = new int[arrayLength - mid];

    for (int i = 0; i < mid; i++){
        left[i] = someTable[i];
    }
    for (int i = mid; i < arrayLength; i++){
        right[i - mid] = someTable[i];
    }
    mergeSort(left,mid);
    mergeSort(right,arrayLength-mid);

    merge(someTable,left,right,mid,arrayLength-mid);

    }
    public static void merge(int[] someArray, int[] leftArray, int[] rightArray, int left, int right){
        int i = 0, j = 0, k = 0;
        while (i < left && j < right){
            if (leftArray[i] <= rightArray[j]){
                someArray[k++] = leftArray[i++];
            }
            else{
                someArray[k++] = rightArray[j++];
            }
        }
        while ((i < left)){
            someArray[k++] = leftArray[i++];
        }
        while (j < right){
            someArray[k++] = rightArray[j++];
        }

    }

    static void printTable(int printMe[]) {
        for (int i = 0; i < printMe.length; i++) {
            System.out.print(printMe[i] + " ");
        }
    }
}

