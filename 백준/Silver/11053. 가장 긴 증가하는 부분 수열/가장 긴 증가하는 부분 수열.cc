#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n, max;

	cin >> n;

	int arr[n];
	int cnt[n];

	fill(cnt, cnt + n, 1); 

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	for (int i = 1; i < n; i++) {
		max = 0;
		for (int j = i - 1; j >= 0; j--) {
			if (arr[i] > arr[j]) {
				if (cnt[j] > max) {
					max = cnt[j];
				}
			}
		}
		cnt[i] += max;
	}

	sort(cnt, cnt + n);
	cout << cnt[n - 1] << '\n';
}