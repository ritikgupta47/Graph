import java.util.*;
public class keysAndRooms {
    public static void main(String[] args) {
    
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            vis[curr] = true;
            for(int keys : rooms.get(curr)){
                if(vis[keys] == false){
                    vis[keys] = true;
                    q.add(keys);
                }
            }
        }
        for(int i = 0; i < n ; i++){
            if(vis[i] == false){
                return false;
            }
        }
        return true;
    }
}
