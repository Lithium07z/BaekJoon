#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n, idx, max, l, s;

	cin >> n;

	int arr[n];
	int cnt[n];

	fill(cnt, cnt + n, 1); 

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	for (int i = idx; i < n; i++) {
		max = 0;
		for (int j = i - 1; j >= 0; j--) {
			if (arr[i] < arr[j]) {
				if (cnt[j] > max) {
					max = cnt[j];
				}
			}
		}
		cnt[i] += max;
	}	

	for (int i = 0; i < n; i++) {
		if (l < cnt[i]) {
			l = cnt[i];
			idx = i;
		}
	}

	sort(cnt, cnt + n);
	s = cnt[n - 1];

	cout << s << '\n';
}