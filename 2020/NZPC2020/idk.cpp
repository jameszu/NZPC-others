
// #include <stdio.h>
// #include <algorithm>
// #include <iostream>
// #include <cstring>
// using namespace std;
// const int maxm = 25;
// const int maxn = 250;
// const int maxk = 810;
// int dp[maxm][maxk],path[maxm][maxk],v[maxn],s[maxn],id[maxm];
 
// //dp[i][j]表示前选了i个人差为j的最大和为多少。
// //path[i][j]表示前i个人差为j的是第几个人。
// //v[i]表示|Pi - Di|，S[i]表示|Pi + Di|。
// //id[i]表示取的点集
 
// int vis(int j,int i,int k)//往前回溯找是否取过第i个人
// {
//     while(j > 0 && path[j][k] != i)
//     {
//         k -= v[path[j][k]];
//         j--;
//     }
//     return j;
// }
 
// int main()
// {
//     int n,m;
//     int cas = 0;
//     while(scanf("%d %d",&n,&m) && n)
//     {
//         for(int i = 1;i <= n;i++)
//         {
//             int a,b;
//             scanf("%d %d",&a,&b);
//             v[i] = a - b;
//             s[i] = a + b;
//         }
 
//         memset(dp,-1,sizeof(dp));//dp[i][j]为-1表示这种情况不能达到
//         memset(path,0,sizeof(path));
 
//         int fix = m * 20;//原本差值是在(-fix,fix)之间的，将j加上fix,则区间映射到(0,2 * fix)之间，才可以用数组的下标表示。
 
//         dp[0][fix] = 0;
//         // printf("%d", dp[900][0]);
//         for(int j = 1;j <= m;j++)//枚举取到第几个
//         {
//             for(int k = 0;k <= fix * 2;k++)//枚举差值
//             {
//                 if(dp[j - 1][k] >= 0)//当前一个值存在时
//                 {
//                     for(int i = 1;i <= n;i++)//枚举取的哪个人
//                     {
//                         if(dp[j][k + v[i]] < dp[j - 1][k] + s[i])
//                         {
//                             if(!vis(j - 1,i,k))//如果第i个人之前没有被取到
//                             {
//                                 dp[j][k + v[i]] = dp[j - 1][k] + s[i];//类似于01背包的转化
//                                 path[j][k + v[i]] = i;//更新取点集
//                             }
//                         }
//                     }
//                 }
//             }
//         }
 
//         int k;
//         for(k = 0;k <= fix;k++)
//         {
//             if(dp[m][fix - k] != -1 || dp[m][fix + k] != -1)//从差值为0的左右两边开始找最小差值
//                 break;
//         }
 
//         int minv,maxs;
//         if(dp[m][fix - k] < dp[m][fix + k])
//         {
//             minv = fix + k;
//             maxs = dp[m][fix + k];
//         }
//         else
//         {
//             minv = fix - k;
//             maxs = dp[m][fix - k];
//         }
 
//         int maxD = (minv + maxs - fix) / 2;//D = (D + P + (D - P)) / 2,要减去加的fix
//         int maxP = (maxs - minv + fix) / 2;//P = (D + P - (P - P)) / 2,同理加上多减的fix值
 
//         int i,j;
//         for(i = 1,j = m,k = minv;j > 0;i++)//更新id值
//         {
//             id[i] = path[j][k];
//             k -= v[id[i]];
//             j--;
//         }
 
//         sort(id + 1,id + 1 + m);
 
//         printf("Jury #%d\n",++cas);
//         printf("Best jury has value %d for prosecution and value %d for defence:\n",maxD,maxP);
//         for(int i = 1;i <= m;i++)
//             printf(" %d",id[i]);
//         printf("\n\n");
//     }
//     return 0;
// }


#include<cstdio>
#include<ctype.h>
#include<algorithm>
#include<iostream>
#include<cstring>
#include<vector>
using namespace std;
int dp[21][801];
vector<int> path[21][801];
 
int main()
{
    int times=1;
//    freopen("input.txt","r",stdin);
//    freopen("output.txt","w",stdout);
    int subtraction[201],_plus[201];
    int n,m,i,j,k;
    while(~scanf("%d%d",&n,&m) && n && m)
    {
        for(i=0;i<m;++i)//清空vector
            for(j=0;j<801;++j)
                path[i][j].clear();
        memset(dp,-1,sizeof(dp));
        int d,p;
        for(i = 0; i < n; i++)
        {
            cin>>d>>p;
            subtraction[i] = d-p;
            _plus[i] = d+p;
        }
        int fix = 20*m;
        dp[0][fix] = 0;
        for(k = 0; k < n; k++)//选择一个
            for(i = m-1; i >= 0; i--)//进行逆推
            {
                for(j = 0; j < 2*fix; j++)
                {
                    if(dp[i][j] >= 0)
                    {
                        if(dp[i+1][j+subtraction[k]] <= dp[i][j] + _plus[k])
                        {
                            dp[i+1][j+subtraction[k]] = dp[i][j] + _plus[k];
                            path[i+1][j+subtraction[k]] = path[i][j];//每次更新都要把path全部复制过来，就是因为这个才用的vector
                            path[i+1][j+subtraction[k]].push_back(k);
                        }
                    }
                }
            }
        for(i = 0; dp[m][fix+i] == -1 && dp[m][fix-i] == -1; i++);
        int temp = (dp[m][fix+i] > dp[m][fix-i]) ? i : -i;
        int sumD = ( dp[m][fix+temp] + temp )/2;
        int sumP = ( dp[m][fix+temp] - temp )/2;
        printf( "Jury #%d\n", times++ );
        printf( "Best jury has value %d for prosecution and value %d for defence:\n", sumD,sumP);
        for( i=0; i < m; i++ )
            printf( " %d", path[m][fix+temp][i]+1);
        printf( "\n\n" );
 
    }
    return 0;
}
