
public class Solution {

	static int N = 6;
	static int V[] = {2,1,2,2,2,3};
	
	static void swap(int x, int y)
	{
		int t = V[x];	V[x] = V[y];	V[y] = t;
	}

	
	static boolean checkBabyJin(int [] test)
	{
		int run = 0;
		int same = 0;
		if (test[0] == test [1] && test[1] == test[2])
		{
			same++;
		}
		else if (test[0] + 1 == test[1] && test[1] + 1 == test[2])
		{
			run++;
		}
		if (test[3] == test[4] && test[4] == test[5])
		{
			same++;
		}
		if (test[3] + 1 == test[4] && test[4] + 1 == test[5])
		{
			run++;
		}
		if (same + run == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	static void getNextPermutation() { 
		int i = N - 1;
		while (V[i - 1] >= V[i]) {
			i = i - 1;
			if( i - 1 == 0) break;
		}

		int j = N;
		while (V[j - 1] <= V[i - 1]) {
			j = j - 1;
			if( j - 1 == 0) break;
		}

		swap(i - 1, j - 1); // (i-1)과 (j-1)의 위치의 값 교환

		i++; j = N;
		while (i < j)
		{
			swap(i - 1, j - 1);
			i++;  j--;
		}
		for (int k = 0; k < N; k++)
		{
			System.out.print(V[k] + " ");
		}
		System.out.println();
	}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 1;
		for(int i = 1; i <= N; i++) count = count*i;
		boolean check = false;
		while(--count > 0){
			if(check = checkBabyJin(V))
			{
				System.out.print("BABY JIN");
				break;
			}
			getNextPermutation();
		}
		
	}

}
