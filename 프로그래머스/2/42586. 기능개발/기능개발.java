import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Tuple> q = new LinkedList<Tuple>();
        for(int i = 0; i < progresses.length; i++) {
            q.add(new Tuple(progresses[i], speeds[i]));
        }

        List<Integer> list = new ArrayList<Integer>();
        int date = 0;
        while(!q.isEmpty()) {
            date++;
            int feature = 0;
            Tuple t = q.peek();
            while(!q.isEmpty() && t.speed * date + t.progress >= 100) {
                feature++;
                q.poll();
                t = q.peek();
            }
            if(feature > 0) {
                list.add(feature);
            }
        }

        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}

class Tuple {
    int progress;
    int speed;

    public Tuple(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}