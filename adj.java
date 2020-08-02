import java.util.*;
class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int t= scan.nextInt();
        while(t-- >0){
            int n= scan.nextInt();
            String a= scan.next();
            String b= scan.next();
            int T = 26;
            ArrayList<Integer>[] ob = new ArrayList[T];
            int[] pos = new int[T];
            Arrays.fill(pos,-1);
            for(int i=0;i<T;i++)ob[i] = new ArrayList<>();
            boolean check = true;
            for(int i=0;i<n;i++){
                pos[a.charAt(i) - 'a'] = i;
                if(a.charAt(i) != b.charAt(i)){
                if(a.charAt(i) < b.charAt(i))check = false;
                else ob[b.charAt(i) - 'a'].add(i);
                }
            }
            for(int i=0;i<T;i++)if(!ob[i].isEmpty() && pos[i] == -1)check= false;

            if(check){
                int ans = 0;
                for(int i=0;i<T;i++)if(!ob[i].isEmpty())ans++;
                System.out.println(ans);
                for(int i = T-1;i >-1;i--){
                    if(ob[i].isEmpty())continue;
                    System.out.print(ob[i].size() + 1);
                    System.out.print(" " + pos[i]);
                    for(int x:ob[i])System.out.print(" "+x);
                    System.out.println();
                }
            }else System.out.println(-1);
        }
    }
}