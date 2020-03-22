#include <iostream>
#include <vector>
#include <string>
using namespace std ;
int main() {
   int N, S ;
   cin >> N >> S ;
   vector<string> b(N) ;
   for (int i=0; i<N; i++)
      cin >> b[i] ;
   vector<vector<int>> cnt(N+1, vector<int>(N+1)) ;
   for (int i=0; i<N; i++)
      for (int j=0; j<N; j++)
         cnt[i+1][j+1] = cnt[i][j+1] + cnt[i+1][j] - cnt[i][j] +
                         (b[i][j] == 'D') ;
   vector<int> cnt2(S*S+1) ;
   for (int i=S; i<=N; i++)
      for (int j=S; j<=N; j++)
         cnt2[cnt[i][j]+cnt[i-S][j-S]-cnt[i-S][j]-cnt[i][j-S]]++ ;
   for (int i=0; i<=S*S; i++)
      if (cnt2[i])
         cout << i << " " << cnt2[i] << endl ;
}
