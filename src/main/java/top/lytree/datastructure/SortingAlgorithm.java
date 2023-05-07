package top.lytree.datastructure;

public final class SortingAlgorithm {

    /**
     * 选择排序
     * 从小到大
     *
     * @param array 数组
     * @return 排序后数组
     */
    public static int[] selectSort(int[] array) {
        if (isEmpty(array)) return array;
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            int min = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }//交换
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;

        }
        return array;
    }

    /**
     * 冒泡排序
     * 从小到大
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (isEmpty(array)) return array;
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = i; j < arrayLength - 1; j++) {
                if (array[i] > array[j + 1]) {
                    int temp = array[i];
                    array[i] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 插入排序
     * 从小到大
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (isEmpty(array)) return array;
        int arrayLength = array.length;
        int j;
        for (int i = 1; i < arrayLength; i++) {
            int min = array[i];
            for (j = i - 1; j >= 0 && min < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = min;
        }
        return array;
    }

    /**
     * 快排
     *
     * @param array 数组
     * @param l     左边界
     * @param r     右边界
     * @return
     */
    public static int[] quickSort(int[] array, int l, int r) {
        if (isEmpty(array)) return array;
        int arrayLength = array.length;
        int point = (r + l) / 2;

        return array;
    }

    private static boolean isEmpty(int[] array) {
        return array == null || array.length < 2;
    }
}
