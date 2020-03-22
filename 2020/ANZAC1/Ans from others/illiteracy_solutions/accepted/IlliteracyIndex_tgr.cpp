#include <iostream>
#include <vector>
#include <string>
#include <map>
using namespace std ;
char rot(char a) {
   if (a < 'F')
      return a + 1 ;
   else
      return 'A' ;
}
int ind(const string &a) {
   int r = 0 ;
   for (int i=0; i<a.size(); i++)
      r = 6 * r + a[i] - 'A' ;
   return r ;
}
int main() {
   string src, dst ;
   cin >> src >> dst ;
   if (src == dst) {
      cout << 0 << endl ;
      return 0 ;
   }
   int sz = 1 ;
   for (int i=0; i<src.size(); i++)
      sz *= 6 ;
   vector<string> q ;
   vector<int> dist(sz, -1) ;
   q.push_back(src) ;
   dist[ind(src)] = 0 ;
   for (int i=0; i<q.size(); i++) {
      int d = dist[ind(q[i])] ;
      for (int j=0; j<q[i].size(); j++) {
         string s = q[i] ;
         switch (s[j]) {
case 'A':
            if (j > 0)
               s[j-1] = rot(s[j-1]) ;
            if (j + 1 < s.size())
               s[j+1] = rot(s[j+1]) ;
            break ;
case 'B':
            if (j > 0 && j + 1 < s.size())
               s[j+1] = s[j-1] ;
            break ;
case 'C':
            s[s.size()-1-j] = rot(s[s.size()-1-j]) ;
            break ;
case 'D':
            if (j + j < s.size())
               for (int k=0; k<j; k++)
                  s[k] = rot(s[k]) ;
            else
               for (int k=j+1; k<s.size(); k++)
                  s[k] = rot(s[k]) ;
            break ;
case 'E':
            if (j + j < s.size()) {
               if (j > 0) {
                  s[0] = rot(s[0]) ;
                  s[2*j] = rot(s[2*j]) ;
               }
            } else {
               if (j + 1 < s.size()) {
                  s[s.size()-1] = rot(s[s.size()-1]) ;
                  s[2*j-s.size()+1] = rot(s[2*j-s.size()+1]) ;
               }
            }
            break ;
case 'F':
            if (j & 1)
               s[j>>1] = rot(s[j>>1]) ;
            else
               s[(j+s.size())>>1] = rot(s[(j+s.size())>>1]) ;
            break ;
         }
         if (s == dst) {
            cout << (d + 1) << endl ;
            return 0 ;
         }
         int off = ind(s) ;
         if (dist[off] == -1) {
            dist[off] = d + 1 ;
            q.push_back(s) ;
         }
      }
   }

   cout << -1 << endl ;
}
