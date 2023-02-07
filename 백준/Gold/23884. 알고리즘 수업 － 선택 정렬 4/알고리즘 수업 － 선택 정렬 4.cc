#include <iostream>
#include <map>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	map<int, int> mp;

	int N, K, c = 0;
	cin >> N >> K;

	int *a = new int[N];
	
	for (int i = 0; i < N; i++)
	{
		cin >> a[i];
		mp.emplace(a[i], i);
	}
	
	for (int i = N - 1; i >= 0; i--)
	{
		int m = mp.rbegin()->second;
		mp.erase(--mp.end());
		if (i != m)
		{
			c++;
			int t = a[i];
			a[i] = a[m];
			a[m] = t;
			mp[a[m]] = m;
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