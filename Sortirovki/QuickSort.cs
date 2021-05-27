//using System;
//using System.Collections.Generic;
//using System.Diagnostics;
//using System.Linq;
//using System.Text;
//using System.Threading.Tasks;

//namespace Sortirovki
//{
//    class QuickSort
//    {
//        public static Random rnd = new Random();
//        static void Main(string[] args)
//        {
//            Console.WriteLine("Ведите количество чисел для сортировки.");
//            int N = Convert.ToInt32(Console.ReadLine());
//            int[] mas = new int[N];
//            Stopwatch SW = new Stopwatch();

//            for (int i = 0; i < mas.Length; i++)
//            {
//                mas[i] = rnd.Next(20);
//                Console.Write(mas[i] + " ");
//            }
//            Console.WriteLine();

//            SW.Start();
//            Sorting(mas, 0, mas.Length - 1);
//            SW.Stop();

//            Console.WriteLine("Отсортированный массив:");
//            for (int i = 0; i < mas.Length; i++)
//            {
//                Console.Write(mas[i] + " ");
//            }

//            Console.WriteLine();
//            Console.WriteLine("Замеренное время в миллисекундах: " + Convert.ToString(SW.ElapsedTicks));
//            Console.ReadLine();
//        }

//        public static void Sorting(int[] arr, long first, long last)
//        {
//            //выбираем опорный элемент - средний в группе
//            double p = arr[(last - first) / 2 + first];
//            int temp;
//            long i = first, j = last;
//            while (i <= j)
//            {
//                //двигаемся до тех пор пока не найдем элемент в левой группе больше опорного
//                while (arr[i] < p && i <= last) ++i;
//                //двигаемся до тех пор пока не найдем элемент в правой группе меньше опорного
//                while (arr[j] > p && j >= first) --j;
//                //меняем найденные элементы
//                if (i <= j)
//                {
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                    ++i; --j;
//                }
//            }
//            //сортируем элементы в сл левой группе
//            if (j > first) Sorting(arr, first, j);
//            //сортируем элементы в сл правой группе
//            if (i < last) Sorting(arr, i, last);
//        }

//    }
//}
