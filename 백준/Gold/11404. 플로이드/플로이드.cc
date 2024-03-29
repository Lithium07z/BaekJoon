#include <iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n, m, INF = 987654321;
	cin >> n >> m;

	int **arr = new int *[n + 1];

	for (int i = 1; i <= n; i++)
	{
		arr[i] = new int[n + 1];
		for (int j = 1; j <= n; j++)
		{
			if (i == j)
			{
				arr[i][j] = 0;
			}
			else
			{
				arr[i][j] = INF;
			}
		}
	}

	for (int i = 0; i < m; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		if (arr[a][b] != 0 && arr[a][b] > c)
		{
			arr[a][b] = c;
		}
	}

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			for (int k = 1; k <= n; k++)
			{
				if (arr[j][k] > arr[j][i] + arr[i][k])
				{
					arr[j][k] = arr[j][i] + arr[i][k];
				}
			}
		}
	}

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			if (arr[i][j] == INF)
			{
				cout << "0 ";
			}
			else
			{
				cout << arr[i][j] << " ";
			}
		}
		cout << "\n";
	}
}