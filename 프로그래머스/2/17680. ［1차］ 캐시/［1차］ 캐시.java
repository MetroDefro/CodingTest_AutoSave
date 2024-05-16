import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        LinkedList<String> cityList = new LinkedList<String>();
        if(cacheSize == 0)
            return cities.length * 5;
        for (String city : cities) {
            String cityName = city.toLowerCase();
            if(cityList.contains(cityName)) {
                time += 1;
                cityList.remove(cityName);
            } else {
                time += 5;
                if(cityList.size() >= cacheSize) {
                    cityList.poll();
                }
            }
            cityList.add(cityName);
        }

        return time;
    }
}