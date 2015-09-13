/**
 * Created with IntelliJ IDEA.
 * User: cartmanie@gmail.com
 * Date: 15/9/13
 * Time: 10:23
 * All rights reserved
 * To change this template use File | Settings | File Templates.
 */
public class PascalTriangle {

    private static int[] triangle(int n)
    {
        if (n == 1)
        {
            int a[] = new int[3];
            a[0] = 1;
            a[1] = 1;
            a[2] = 1;
            return a;
        }

        if (n==2)
        {
            int a[] = new int[6];
            a[0] = 1;
            a[1] = 1;
            a[2] = 1;

            a[3] = 1;
            a[4] = 2;
            a[5] = 1;
            return a;
        }

        int target_count = get_target_count(n);
        int target_count_old = get_target_count(n-1);
        int target_count_older = get_target_count(n-2);

        int a[] = new int[target_count];
        int old[] = triangle(n - 1);
        for (int i = 0; i < old.length; i++) {
            a[i] = old[i];
        }

        int edge_left = old.length;
        int edge_right = target_count-1;
        for (int j = old.length, inc =0; j < target_count && inc<old.length-1; j++) {
            if (edge_left == j)
            {
                a[j] = old[target_count_older];
            }
            else
            if (edge_right == j)
            {
                a[j] = old[old.length-1];
            }
            else
            {
                a[j] = old[target_count_older+inc]+old[target_count_older+inc+1];
                inc++;
            }
        }
        return a;
    }

    private static int get_target_count(int n) {
        if (n==1)
        {
            return 3;
        }

        if (n==2)
        {
            return 6;
        }

        return get_target_count(n-1)+(3+n-2);

    }

    private static void dump_triangle(int a[])
    {
        System.out.println("---------------------------------------------");
        int current_begin = 0;
        int current_end = 0;
        int current_count = 1;



       while (current_end<a.length-1)
       {
            int start = current_begin;
            int end = current_end;
            dump_line(a,start,end);

           current_count = current_count+1;
           current_begin = current_end+1;
           current_end = current_begin+current_count-1;
       }
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
    }

    private static void dump_line(int[] a, int start, int end) {
        for (int i = start; i <= end; i++) {
           System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(" hello world");
        {
            int a[] = triangle(1);
            dump_triangle(a);
        }


        {
            int a[] = triangle(2);
            dump_triangle(a);
        }


        {
            int a[] = triangle(3);
            dump_triangle(a);
        }


        {
            int a[] = triangle(4);
            dump_triangle(a);
        }


        {
            int a[] = triangle(5);
            dump_triangle(a);
        }


        {
            int a[] = triangle(6);
            dump_triangle(a);
        }


        {
            int a[] = triangle(7);
            dump_triangle(a);
        }


        {
            int a[] = triangle(8);
            dump_triangle(a);
        }

    }
}
