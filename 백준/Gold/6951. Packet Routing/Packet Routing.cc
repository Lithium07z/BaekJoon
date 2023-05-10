#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int arr[100][100];
    memset(arr, 0, sizeof(arr));

	int N, W, P;
	int INF = 987654321;
	cin >> N >> W >> P;
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (i != j) {
				arr[i][j] = INF;
			}
		}
	}

	for (int i = 0; i < W; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		arr[a - 1][b - 1] = arr[b - 1][a - 1] = c;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				arr[j][k] = min(arr[j][k], arr[j][i] + arr[i][k]);
			}
		}
	}

	for (int i = 0; i < P; i++) {
		int a, b;
		cin >> a >> b;
		cout << arr[a - 1][b- 1] << "\n";
	}
}