//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Text;
//using System.Threading.Tasks;

//namespace Sortirovki
//{
//    class RazryadSort
//    {

//        public static Random rnd = new Random();
//        static void Main(string[] args)
//        {
//            Console.WriteLine("Ведите количество чисел для сортировки.");
//            int N = Convert.ToInt32(Console.ReadLine());
//            int[] mas = new int[N];

//            for (int i = 0; i < mas.Length; i++)
//            {
//                mas[i] = rnd.Next(20);
//                Console.Write(mas[i] + " ");
//            }
//            Console.WriteLine();

//            int[] Newmas = SortL(mas);

//            Console.WriteLine("Отсортированный массив:");
//            for (int i = 0; i < mas.Length; i++)
//            {
//                Console.Write(mas[i] + " ");
//            }

//            Console.ReadLine();
//        }

//        public static int[] SortL(int[] arr)
//        {
//            if (arr == null || arr.Length == 0)
//                return arr;

//            int i, j;
//            var tmp = new int[arr.Length];
//            for (int shift = sizeof(int) * 8 - 1; shift > -1; --shift)
//            {
//                j = 0;
//                for (i = 0; i < arr.Length; ++i)
//                {
//                    var move = (arr[i] << shift) >= 0;
//                    if (shift == 0 ? !move : move)
//                        arr[i - j] = arr[i];
//                    else
//                        tmp[j++] = arr[i];
//                }
//                Array.Copy(tmp, 0, arr, arr.Length - j, j);
//            }

//            return arr;
//        }
//    }
//}
