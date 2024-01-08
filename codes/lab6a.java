package codes;
import java.util.Scanner;
public class lab6a extends Thread
{
	public static void main(String args[])
	{
		lab6a con = new lab6a();
		con.start();
	}
	
	static int count(int coins[], int n, int sum)
    {
 
        if (sum == 0) return 1;
        if (sum < 0) return 0;
        if (n <= 0) return 0;
        return count(coins, n - 1, sum)
            + count(coins, n, sum - coins[n - 1]);
    }
	
	public void run()
	{
		Scanner x = new Scanner(System.in);
		System.out.print("How many types of coins do you have? ");
		int num = x.nextInt();
		int[] coins = new int[num];
		System.out.println("Enter their denominations...");
		for(int i = 0; i<num; i++)
		{
			int incoin;
			while(true)
			{
				incoin = x.nextInt();
				if(incoin<=0)
					System.out.print("coin denomination cannot be <=0 !!!\n"
							+ "enter again... ");
				else break;
			}
			coins[i] = incoin;
		}
		System.out.print("good. now tell me what sum you want to make... ");
		int sum = x.nextInt();
		x.close();
		int n = coins.length;
        System.out.print("The number of combinations are = "+count(coins, n, sum));
	}
}
