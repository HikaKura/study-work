using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sortirovki
{
    class GnomSort
    {
        public static Random rnd = new Random();
        static void Main(string[] args)
        {
            Console.WriteLine("Ведите количество чисел для сортировки подсчетом.");
            int N = Convert.ToInt32(Console.ReadLine());
            int[] mas = new int[N];

            for (int i = 0; i < mas.Length; i++)
            {
                mas[i] = rnd.Next(20);
                Console.Write(mas[i] + " ");
            }
            Console.WriteLine();

            GnomeSort(mas);

            Console.WriteLine("Отсортированный массив:");
            for (int i = 0; i < mas.Length; i++)
            {
                Console.Write(mas[i] + " ");
            }

            Console.ReadLine();
        }


        static void GnomeSort(int[] inArray)
        {
            int i = 1;
            int j = 2;
            while (i < inArray.Length)
            {
                if (inArray[i - 1] < inArray[i])
                {
                    i = j;
                    j += 1;
                }
                else
                {
                    //если тек элемент меньше пред, то меняем местами, шагаем назад
                    Swap(inArray, i - 1, i);
                    i -= 1;
                    //если шаг на начале массива, возвращаемся с указателя j
                    if (i == 0)
                    {
                        i = j;
                        j += 1;
                    }
                }
            }
        }

        static void Swap(int[] array, int i, int j)
        {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }
}
