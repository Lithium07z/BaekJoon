#include <iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, K, c = 0;
	cin >> N >> K;

	int *a = new int[N];

	for (int i = 0; i < N; i++)
	{
		cin >> a[i];
	}

	for (int i = N - 1; i >= 0; i--)
	{
		int m = 0;
		for (int j = 0; j <= i; j++)
		{
			if (a[m] < a[j])
			{
				m = j;
			}
		}
		if (i != m)
		{
			c++;
			int t = a[i];
			a[i] = a[m];
			a[m] = t;
			if (c == K) {
				for (int k = 0; k < N; k++) {
					cout << a[k] << " ";
				}
				return 0;
			}
		}
	}
	cout << -1;
}