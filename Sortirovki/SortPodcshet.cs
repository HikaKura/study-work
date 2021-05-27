//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Text;
//using System.Threading.Tasks;

//namespace Sortirovki
//{
//    class SortPodcshet
//    {
//        public static Random rnd = new Random();
//        static void Main(string[] args)
//        {
//            Console.WriteLine("Ведите количество чисел для сортировки подсчетом.");
//            int N = Convert.ToInt32(Console.ReadLine());
//            int[] mas = new int[N];

//            for (int i = 0; i < mas.Length; i++)
//            {
//                mas[i] = rnd.Next(20);
//                Console.Write(mas[i] + " ");
//            }
//            Console.WriteLine();

//            int[] newMas = BasicCountingSort(mas, 20);

//            Console.WriteLine("Отсортированный массив:");
//            for (int i = 0; i < newMas.Length; i++)
//            {
//                Console.Write(newMas[i] + " ");
//            }

//            Console.ReadLine();
//        }

//        static int[] BasicCountingSort(int[] array, int k)
//        {
//            //заполняем массив count равный k = макс число в ориг массиве
//            var count = new int[k + 1];
//            for (var i = 0; i < array.Length; i++)
//            {
//                count[array[i]]++;
//            }

//            var index = 0;
//            //проходим по всему массиву count
//            for (var i = 0; i < count.Length; i++)
//            {
//                //находим ненулевой элемент и переносим в ориг массив столько раз, какое число стоит в подсчете (count)
//                for (var j = 0; j < count[i]; j++)
//                {
//                    array[index] = i;
//                    index++;
//                }
//            }

//            return array;
//        }
//    }
//}
