#include <bits/stdc++.h>
using namespace std;

bool check(string s){
	for(int i=0;i<=s.length()/2;i++){
		if(s[i]!=s[s.length()-i-1])
			return 0;
	}
	return 1;
}

int main(){
	string s;
	getline(cin, s);
	if(check(s))
		cout<<"la xau doi xung";
	else
		cout<<"khong la xau doi xung";
}
