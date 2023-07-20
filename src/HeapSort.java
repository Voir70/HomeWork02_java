// Java-программа для реализации пирамидальной сортировки
public class HeapSort
{
    /**
     * Метод запуска сортировки массива
     * @param arr
     */
    public void sort(int arr[])
    {
        //длина массива
        int n = arr.length;

        //создаём дерево, построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }


        //Делаем сортировку массива, уже отсортированного дерева,
        //Один за другим извлекаем элементы из кучи
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    /**
     * Главный метод в котором будет меняться структура данных
     * так чтоб родитель был максимальны элементом по сравнению
     * со своими детьми в дереве
     * @param arr
     * @param n
     * @param i
     */
    void heapify(int arr[], int n, int i)
    {
        // Находим самый большой среди корневых, левых дочерних и правых дочерних элементов
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        //Если, дочерний элемент оказался больше родителя, то делаем обмен,
        //дочернего элемента с родителем. Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            /*Проверяем ещё раз чтоб дочерние элементы были меньше чем родители,
            если, вдруг у дочерних элементов есть свои дочерние элементы
            Рекурсивно преобразуем в двоичную кучу затронутое поддерево*/
            heapify(arr, n, largest);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i < n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {2,12,-9,5,-7,10};

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("Отсортированный массив представляет собой");
        printArray(arr);
    }
}